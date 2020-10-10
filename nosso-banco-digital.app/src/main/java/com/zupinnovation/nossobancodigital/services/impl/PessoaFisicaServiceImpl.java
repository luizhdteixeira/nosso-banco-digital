package com.zupinnovation.nossobancodigital.services.impl;

import com.zupinnovation.nossobancodigital.persistences.model.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.repositories.PessoaFisicaRepository;
import com.zupinnovation.nossobancodigital.persistences.dto.PessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.services.PessoaFisicaService;
import com.zupinnovation.nossobancodigital.services.mappers.PessoaFisicaMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    private final PessoaFisicaRepository repository;
    private final PessoaFisicaMapper mapper;

    public PessoaFisicaServiceImpl(PessoaFisicaRepository repository, PessoaFisicaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Boolean documentAndEmailEqual(PessoaFisicaDTO dto) {
        Optional<PessoaFisica> verifyDocumentAndEmail = repository
                .findByDocumentAndEmail(dto.getDocument(), dto.getEmail());
        final boolean[] equal = {false};
        verifyDocumentAndEmail.ifPresent(pessoaFisica -> equal[0] = true);
        return equal[0];
    }

    @Override
    public Boolean documentEqual(String document) {
        Optional<PessoaFisica> verifyPessoaFisica = repository.findByDocument(document);
        final boolean[] equal = {false};
        verifyPessoaFisica.ifPresent(pessoaFisica -> equal[0] = true);
        return equal[0];
    }

    @Override
    public PessoaFisica save(PessoaFisicaDTO dto) {
        PessoaFisica entity = mapper.dtoToEntityPessoaFisica(dto);
        if (nonNull(entity)) {
            return repository.save(entity);
        }
        return null;
    }
}
