package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonReceiveDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NaturalPersonMapper {

    NaturalPerson dtoToEntityNaturalPerson(NaturalPersonDTO dto);
    NaturalPersonDTO entityToDtoNaturalPerson(NaturalPerson entity);
    NaturalPersonReceiveDTO entityToDtoNaturalPersonReceive(NaturalPerson entity);
}
