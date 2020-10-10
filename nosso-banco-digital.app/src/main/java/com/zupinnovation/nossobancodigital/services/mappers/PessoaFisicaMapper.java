package com.zupinnovation.nossobancodigital.services.mappers;

import com.zupinnovation.nossobancodigital.persistences.model.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.dto.PessoaFisicaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaFisicaMapper {

    PessoaFisica dtoToEntityPessoaFisica(PessoaFisicaDTO dto);
    PessoaFisicaDTO entityToDtoPessoaFisica(PessoaFisica entity);
}
