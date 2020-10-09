package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.repositories.dto.PessoaFisicaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaFisicaMapper {

    PessoaFisica dtoToEntityPessoaFisica(PessoaFisicaDTO dto);
    PessoaFisicaDTO entityToDtoPessoaFisica(PessoaFisica entity);
}
