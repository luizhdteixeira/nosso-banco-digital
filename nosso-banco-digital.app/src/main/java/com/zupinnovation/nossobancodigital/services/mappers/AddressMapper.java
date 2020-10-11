package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO entityToDto(Address address);
    Address dtoToEntity(AddressDTO addressDTO);
}
