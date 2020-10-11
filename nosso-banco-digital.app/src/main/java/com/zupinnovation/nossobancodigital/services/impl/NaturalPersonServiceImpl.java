package com.zupinnovation.nossobancodigital.services.impl;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.persistences.repositories.NaturalPersonRepository;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.services.NaturalPersonService;
import com.zupinnovation.nossobancodigital.services.mappers.AddressMapper;
import com.zupinnovation.nossobancodigital.services.mappers.NaturalPersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {

    private final NaturalPersonRepository repository;
    private final NaturalPersonMapper naturalPersonMapper;
    private final AddressMapper addressMapper;

    public NaturalPersonServiceImpl(NaturalPersonRepository repository, NaturalPersonMapper naturalPersonMapper, AddressMapper addressMapper) {
        this.repository = repository;
        this.naturalPersonMapper = naturalPersonMapper;
        this.addressMapper = addressMapper;
    }


    @Override
    public Optional<NaturalPerson> documentAndEmailEqual(NaturalPersonDTO dto) {
        return repository.findByDocumentAndEmail(dto.getDocument(), dto.getEmail());
    }

    @Override
    public Optional<NaturalPerson> findByDocument(String document) {
        return repository.findByDocument(document);
    }

    @Override
    public NaturalPerson saveNaturalPerson(NaturalPersonDTO dto) {
        NaturalPerson entity = naturalPersonMapper.dtoToEntityNaturalPerson(dto);
        if (nonNull(entity)) {
            return repository.save(entity);
        }
        return null;
    }

    @Override
    public NaturalPerson saveAddressNaturalPerson(UUID uuid, AddressDTO dto) {
        if (StringUtils.isEmpty(uuid.toString()) || isNull(dto)) {
            return null;
        }
        Optional<NaturalPerson> queryNaturalPerson = repository.findById(uuid);
        if (queryNaturalPerson.isPresent()) {
            NaturalPerson naturalPerson = queryNaturalPerson.get();
            naturalPerson.setAddressNaturalPerson(addressMapper.dtoToEntity(dto));
            repository.save(naturalPerson);
            return naturalPerson;
        }
        return null;
    }

    @Override
    public NaturalPerson savePhotographyNaturalPerson(UUID uuid, MultipartFile multipartFile) {
        return null;
    }

}
