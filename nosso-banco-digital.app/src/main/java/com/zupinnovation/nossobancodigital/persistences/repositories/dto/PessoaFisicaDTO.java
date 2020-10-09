package com.zupinnovation.nossobancodigital.persistences.repositories.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class PessoaFisicaDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @Temporal(TemporalType.DATE)
    @NotBlank
    private LocalDate dateBirth;
    @NotBlank
    private String document;
}
