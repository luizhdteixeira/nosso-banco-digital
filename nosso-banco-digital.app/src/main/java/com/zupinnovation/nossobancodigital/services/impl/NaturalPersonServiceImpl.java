package com.zupinnovation.nossobancodigital.services.impl;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.PhotographyDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.persistences.repositories.NaturalPersonRepository;
import com.zupinnovation.nossobancodigital.services.NaturalPersonService;
import com.zupinnovation.nossobancodigital.services.mappers.AddressMapper;
import com.zupinnovation.nossobancodigital.services.mappers.NaturalPersonMapper;
import com.zupinnovation.nossobancodigital.services.mappers.PhotographyMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {

    private final NaturalPersonRepository repository;
    private final NaturalPersonMapper naturalPersonMapper;
    private final AddressMapper addressMapper;
    private final PhotographyMapper photographyMapper;

    public NaturalPersonServiceImpl(NaturalPersonRepository repository, NaturalPersonMapper naturalPersonMapper, AddressMapper addressMapper, PhotographyMapper photographyMapper) {
        this.repository = repository;
        this.naturalPersonMapper = naturalPersonMapper;
        this.addressMapper = addressMapper;
        this.photographyMapper = photographyMapper;
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
    public Optional<NaturalPerson> saveNaturalPerson(NaturalPersonDTO dto) {
        if (nonNull(dto)) {
            NaturalPerson entity = naturalPersonMapper.dtoToEntityNaturalPerson(dto);
            return Optional.of(repository.save(entity));
        }
        return Optional.empty();
    }

    @Override
    public Optional<NaturalPerson> saveAddressNaturalPerson(UUID uuid, AddressDTO dto) {
        if (StringUtils.isEmpty(uuid.toString()) || isNull(dto)) {
            return Optional.empty();
        } else {
            Optional<NaturalPerson> optionalNaturalPerson = repository.findById(uuid);
            optionalNaturalPerson.ifPresent(naturalPerson -> {
                naturalPerson.setAddressNaturalPerson(addressMapper.dtoToEntity(dto));
                repository.save(naturalPerson);
            });
            return optionalNaturalPerson;
        }

    }

    @Override
    public Optional<NaturalPersonDTO> savePhotographyNaturalPerson(UUID uuid, MultipartFile multipartFile) throws IOException {
        if (StringUtils.isEmpty(uuid.toString()) || isNull(multipartFile)) {
            return Optional.empty();
        } else {
            Optional<NaturalPerson> optionalNaturalPerson = repository.findByAddress_Uuid(uuid);
            PhotographyDTO photographyDTO = new PhotographyDTO(multipartFile.getName(), multipartFile.getBytes());
            optionalNaturalPerson.ifPresent(naturalPerson -> {
                naturalPerson.getAddressNaturalPerson().setPhotography(photographyMapper.dtoToEntityPhotography(photographyDTO));
                repository.save(naturalPerson);
            });
            return optionalNaturalPerson.map(naturalPersonMapper::entityToDtoNaturalPerson);
        }
    }

}
