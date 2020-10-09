package com.zupinnovation.nossobancodigital.resources;

import com.zupinnovation.nossobancodigital.persistences.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.repositories.dto.PessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.services.PessoaFisicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequestMapping(path = "/pessoafisica")
public class PessoaFisicaRestController {

    private final PessoaFisicaService service;

    public PessoaFisicaRestController(PessoaFisicaService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaFisica> save(@RequestBody PessoaFisicaDTO body) {
        Boolean verifyEqual = service.documentAndEmailEqual(body);
        if (verifyEqual.equals(true)) {
            return ResponseEntity.badRequest().build();
        }
        PessoaFisica pessoaFisica = service.save(body);
        if (isNull(pessoaFisica)) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(pessoaFisica, HttpStatus.CREATED);
    }
}
