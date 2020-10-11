package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.dto.PhotographyDTO;
import com.zupinnovation.nossobancodigital.persistences.model.Photography;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotographyMapper {

    PhotographyDTO entityToDtoPhotography(Photography entity);
    Photography dtoToEntityPhotography(PhotographyDTO dto);
}
