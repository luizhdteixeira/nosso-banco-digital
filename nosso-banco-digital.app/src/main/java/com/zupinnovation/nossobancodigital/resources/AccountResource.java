package com.zupinnovation.nossobancodigital.resources;

import com.zupinnovation.nossobancodigital.persistences.dto.AddressDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonDTO;
import com.zupinnovation.nossobancodigital.persistences.dto.NaturalPersonReceiveDTO;
import com.zupinnovation.nossobancodigital.persistences.model.NaturalPerson;
import com.zupinnovation.nossobancodigital.services.NaturalPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

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
            Optional<NaturalPerson> naturalPerson = naturalPersonService.saveAddressNaturalPerson(verifyExist.get().getId(), body);
            if (naturalPerson.isPresent()) {
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}/photography")
                        .buildAndExpand(naturalPerson.get().getAddress().getId())
                        .toUri();
                return ResponseEntity.created(location).build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(path = "/proposal/{document}/address/{id}/photography", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Void> savePhotographyNaturalPerson(@PathVariable String document, @PathVariable Long id, @RequestParam MultipartFile img) throws IOException {
        Optional<NaturalPerson> verifyExist = naturalPersonService.findByDocument(document);
        if (verifyExist.isPresent()) {
            Optional<NaturalPersonReceiveDTO> naturalPerson = naturalPersonService.savePhotographyNaturalPerson(id, img);
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
