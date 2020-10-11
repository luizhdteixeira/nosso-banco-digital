package com.zupinnovation.nossobancodigital.persistences.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = - 596220630704722552L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private UUID uuid;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String neighborhoods;
    @Column(nullable = false)
    private String addressComplement;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String district;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Photography photography;

    public Address() {
    }

    public Address(String zipCode, String street, String neighborhoods, String addressComplement, String city, String district) {
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhoods = neighborhoods;
        this.addressComplement = addressComplement;
        this.city = city;
        this.district = district;
    }

    public Address(String zipCode, String street, String neighborhoods, String addressComplement, String city, String district, Photography photography) {
        this.zipCode = zipCode;
        this.street = street;
        this.neighborhoods = neighborhoods;
        this.addressComplement = addressComplement;
        this.city = city;
        this.district = district;
        this.photography = photography;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(String neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Photography getPhotography() {
        return photography;
    }

    public void setPhotography(Photography photography) {
        this.photography = photography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
