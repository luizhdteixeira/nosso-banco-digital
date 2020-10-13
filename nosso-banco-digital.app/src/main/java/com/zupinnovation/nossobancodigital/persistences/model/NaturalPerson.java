package com.zupinnovation.nossobancodigital.persistences.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class NaturalPerson implements Serializable {

    private static final long serialVersionUID = - 414880627309498302L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate dateBirth;
    @CPF
    @Column(nullable = false, unique = true)
    private String document;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public NaturalPerson() {
    }

    public NaturalPerson(String firstName, String lastName, String email, LocalDate dateBirth, @CPF String document) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateBirth = dateBirth;
        this.document = document;
    }

    public NaturalPerson(String firstName, String lastName, String email, LocalDate dateBirth, @CPF String document, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateBirth = dateBirth;
        this.document = document;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalPerson that = (NaturalPerson) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
