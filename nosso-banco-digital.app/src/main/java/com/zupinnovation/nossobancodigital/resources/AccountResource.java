package com.zupinnovation.nossobancodigital.resources;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.services.NaturalPersonService;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/account")
public class AccountResource {

    private final NaturalPersonService naturalPersonService;

    public AccountResource(NaturalPersonService naturalPersonService) {
        this.naturalPersonService = naturalPersonService;
    }

    @PostMapping(path = "/proposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> saveNaturalPerson(@RequestBody @Valid NaturalPersonDTO body) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.documentAndEmailEqual(body);
        if (!verifyExist.isPresent()) {
            Optional<NaturalPerson> naturalPerson = naturalPersonService.saveNaturalPerson(body);
            if (naturalPerson.isPresent()) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/proposal/{document}/address")
                        .buildAndExpand(naturalPerson.get().getDocument())
                        .toUri();
                return ResponseEntity.created(location).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(path = "/proposal/{document}/address", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> saveAddressNaturalPerson(@PathVariable String document, @RequestBody @Valid AddressDTO body) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.findByDocument(document);
        if (verifyExist.isPresent()) {
            UUID uuid = verifyExist.get().getUuid();
            Optional<NaturalPerson> naturalPerson = naturalPersonService.saveAddressNaturalPerson(uuid, body);
            if (naturalPerson.isPresent()) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/proposal/{document}/address/{uuid}/photography")
                        .buildAndExpand(naturalPerson.get().getDocument(), naturalPerson.get().getAddressNaturalPerson().getUuid())
                        .toUri();
                return ResponseEntity.created(location).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @SneakyThrows
    @PostMapping(path = "/proposal/{document}/address/{uuid}/photography", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Void> savePhotographyNaturalPerson(@PathVariable String document, @PathVariable UUID uuid, @RequestParam MultipartFile img) {
        Optional<NaturalPerson> verifyExist = naturalPersonService.findByDocument(document);
        if (verifyExist.isPresent()) {
            Optional<NaturalPersonDTO> naturalPerson = naturalPersonService.savePhotographyNaturalPerson(uuid, img);
            if (naturalPerson.isPresent()) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/receive")
                        .buildAndExpand(naturalPerson.get())
                        .toUri();
                return ResponseEntity.created(location).build();
            }
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
