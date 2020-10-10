package com.zupinnovation.nossobancodigital.services.impl;

import com.zupinnovation.nossobancodigital.persistences.dto.EnderecoPessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.persistences.model.EnderecoPessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.repositories.EnderecoPessoaFisicaRepository;
import com.zupinnovation.nossobancodigital.services.EnderecoPessoaFisicaService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoPessoaFisicaServiceImpl implements EnderecoPessoaFisicaService {

    private final EnderecoPessoaFisicaRepository enderecoPessoaFisicaRepository;

    public EnderecoPessoaFisicaServiceImpl(EnderecoPessoaFisicaRepository enderecoPessoaFisicaRepository) {
        this.enderecoPessoaFisicaRepository = enderecoPessoaFisicaRepository;
    }

    @Override
    public EnderecoPessoaFisica save(EnderecoPessoaFisicaDTO enderecoPessoaFisicaDTO) {
        EnderecoPessoaFisica enderecoPessoaFisica;
        return null;
    }
}
