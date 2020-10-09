package com.zupinnovation.nossobancodigital.services;

import com.zupinnovation.nossobancodigital.persistences.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.repositories.dto.PessoaFisicaDTO;

public interface PessoaFisicaService {

    Boolean documentAndEmailEqual(PessoaFisicaDTO dto);
    PessoaFisica save(PessoaFisicaDTO dto);

}
