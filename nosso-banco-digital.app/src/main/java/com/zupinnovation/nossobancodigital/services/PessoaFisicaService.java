package com.zupinnovation.nossobancodigital.services;

import com.zupinnovation.nossobancodigital.persistences.model.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.dto.PessoaFisicaDTO;

public interface PessoaFisicaService {

    Boolean documentAndEmailEqual(PessoaFisicaDTO dto);
    Boolean documentEqual(String document);
    PessoaFisica save(PessoaFisicaDTO dto);

}
