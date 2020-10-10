package com.zupinnovation.nossobancodigital.services;

import com.zupinnovation.nossobancodigital.persistences.dto.EnderecoPessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.persistences.model.EnderecoPessoaFisica;

public interface EnderecoPessoaFisicaService {

    EnderecoPessoaFisica save(EnderecoPessoaFisicaDTO enderecoPessoaFisicaDTO);
}
