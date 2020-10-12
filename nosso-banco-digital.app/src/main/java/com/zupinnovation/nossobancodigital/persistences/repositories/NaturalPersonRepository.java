package com.zupinnovation.nossobancodigital.persistences.repositories;

import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, UUID> {

    Optional<NaturalPerson> findByDocumentAndEmail(String document, String email);
    Optional<NaturalPerson> findByDocument(String document);
    Optional<NaturalPerson> findByAddress_Uuid(UUID uuid);
}
