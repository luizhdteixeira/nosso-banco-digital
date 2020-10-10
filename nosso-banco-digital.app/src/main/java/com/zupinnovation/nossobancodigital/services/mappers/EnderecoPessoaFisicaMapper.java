package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.dto.EnderecoPessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.persistences.model.EnderecoPessoaFisica;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoPessoaFisicaMapper {

    EnderecoPessoaFisicaDTO entityToDto(EnderecoPessoaFisica enderecoPessoaFisica);
    EnderecoPessoaFisica dtoToEntity(EnderecoPessoaFisicaDTO enderecoPessoaFisicaDTO);
}
