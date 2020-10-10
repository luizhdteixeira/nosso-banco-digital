package com.zupinnovation.nossobancodigital.resources;

import com.zupinnovation.nossobancodigital.persistences.dto.EnderecoPessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.persistences.model.EnderecoPessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.model.PessoaFisica;
import com.zupinnovation.nossobancodigital.persistences.dto.PessoaFisicaDTO;
import com.zupinnovation.nossobancodigital.services.EnderecoPessoaFisicaService;
import com.zupinnovation.nossobancodigital.services.PessoaFisicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping(path = "/pessoafisica")
public class PessoaFisicaRestController {

    private final PessoaFisicaService pessoaFisicaService;
    private final EnderecoPessoaFisicaService enderecoPessoaFisicaService;

    public PessoaFisicaRestController(PessoaFisicaService pessoaFisicaService, EnderecoPessoaFisicaService enderecoPessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
        this.enderecoPessoaFisicaService = enderecoPessoaFisicaService;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaFisica> savePessoaFisica(@RequestBody @Valid PessoaFisicaDTO body) {
        Boolean verifyEqual = pessoaFisicaService.documentAndEmailEqual(body);
        if (verifyEqual.equals(true) || isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        PessoaFisica pessoaFisica = pessoaFisicaService.save(body);
        if (isNull(pessoaFisica)) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(pessoaFisica, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{document}/enderecopessofisica", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EnderecoPessoaFisica> saveEnderecoPessoaFisica(@PathVariable String document, @RequestBody @Valid EnderecoPessoaFisicaDTO body) {
        Boolean verifyEqual = pessoaFisicaService.documentEqual(document);
        if (verifyEqual.equals(false) || isNull(body)) {
            return ResponseEntity.badRequest().build();
        }
        EnderecoPessoaFisica enderecoPessoaFisica = enderecoPessoaFisicaService.save(body);
        if (isNull(enderecoPessoaFisica)){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(enderecoPessoaFisica, HttpStatus.CREATED);
    }
}
