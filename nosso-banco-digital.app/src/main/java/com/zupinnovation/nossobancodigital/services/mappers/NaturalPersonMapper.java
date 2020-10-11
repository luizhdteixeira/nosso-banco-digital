package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NaturalPersonMapper {

    NaturalPerson dtoToEntityNaturalPerson(NaturalPersonDTO dto);
    NaturalPersonDTO entityToDtoNaturalPerson(NaturalPerson entity);
}
