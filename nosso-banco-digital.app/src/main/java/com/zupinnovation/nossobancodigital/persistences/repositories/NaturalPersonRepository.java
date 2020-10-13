package com.zupinnovation.nossobancodigital.persistences.repositories;

import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {

    Optional<NaturalPerson> findByDocumentAndEmail(String document, String email);
    Optional<NaturalPerson> findByDocument(String document);
    @Query(value = "SELECT A FROM NaturalPerson AS NP INNER JOIN Address AS A ON A.id = :id WHERE NP.address.id = :id")
    Optional<NaturalPerson> findByAddressUUID(Long id);
}
