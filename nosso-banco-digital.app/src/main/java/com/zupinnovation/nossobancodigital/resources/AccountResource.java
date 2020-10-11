package com.zupinnovation.nossobancodigital.resources;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.services.NaturalPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "/account")
public class AccountResource {

    private final NaturalPersonService naturalPersonService;

    public AccountResource(NaturalPersonService naturalPersonService) {
        this.naturalPersonService = naturalPersonService;
    }

    @PostMapping(path = "/proposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> saveNaturalPerson(@RequestBody @Valid NaturalPersonDTO body) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.documentAndEmailEqual(body);
        if (verifyExist.isPresent()) {
            NaturalPerson naturalPerson = naturalPersonService.saveNaturalPerson(body);
            if (isNull(naturalPerson)) {
                return ResponseEntity.badRequest().build();
            }
            return new ResponseEntity<>(naturalPerson.getUuid(), HttpStatus.CREATED);

        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/proposal/{document}/address", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UUID> saveAddressNaturalPerson(@PathVariable String document, @RequestBody @Valid AddressDTO body) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.findByDocument(document);
        if (verifyExist.isPresent()) {
            UUID uuid = verifyExist.get().getUuid();
            NaturalPerson naturalPerson = naturalPersonService.saveAddressNaturalPerson(uuid, body);
            if (isNull(naturalPerson)) {
                return ResponseEntity.badRequest().build();
            }
            return new ResponseEntity<>(naturalPerson.getAddressNaturalPerson().getUuid(), HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(path = "/proposal/{document}/address/{uuid}/photography", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Boolean> savePhotographyNaturalPerson(@PathVariable String document, @PathVariable UUID uuid, @RequestParam MultipartFile img) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.findByDocument(document);
        if (verifyExist.isPresent()) {
            return new ResponseEntity<>(false, HttpStatus.CREATED);
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
