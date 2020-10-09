package com.zupinnovation.nossobancodigital.persistences.repositories;

import com.zupinnovation.nossobancodigital.persistences.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {

    Optional<PessoaFisica> findByDocumentAndEmail(String document, String email);
}
