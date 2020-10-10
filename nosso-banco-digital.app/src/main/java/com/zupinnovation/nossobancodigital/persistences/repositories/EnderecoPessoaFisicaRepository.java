package com.zupinnovation.nossobancodigital.persistences.repositories;

import com.zupinnovation.nossobancodigital.persistences.model.EnderecoPessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoPessoaFisicaRepository extends JpaRepository<EnderecoPessoaFisica, UUID> {

}
