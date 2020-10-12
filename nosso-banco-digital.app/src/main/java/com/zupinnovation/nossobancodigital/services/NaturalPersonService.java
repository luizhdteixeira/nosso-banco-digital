package com.zupinnovation.nossobancodigital.services;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface NaturalPersonService {

    Optional<NaturalPerson> documentAndEmailEqual(NaturalPersonDTO dto);
    Optional<NaturalPerson> findByDocument(String document);
    Optional<NaturalPerson> saveNaturalPerson(NaturalPersonDTO dto);
    Optional<NaturalPerson> saveAddressNaturalPerson(UUID uuid, AddressDTO dto);
    Optional<NaturalPersonDTO> savePhotographyNaturalPerson(UUID uuid, MultipartFile multipartFile) throws IOException;

}
