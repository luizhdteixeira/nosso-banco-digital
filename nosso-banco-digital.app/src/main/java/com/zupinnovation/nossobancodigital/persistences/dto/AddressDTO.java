package com.zupinnovation.nossobancodigital.persistences.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AddressDTO {

    @Pattern(regexp = ("^\\d{5}[-]\\d{3}$"))
    private String zipCode;
    @NotBlank
    private String street;
    @NotBlank
    private String neighborhoods;
    @NotBlank
    private String addressComplement;
    @NotBlank
    private String city;
    @NotBlank
    private String district;

    private PhotographyDTO photography;

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

    public PhotographyDTO getPhotography() {
        return photography;
    }

    public void setPhotography(PhotographyDTO photography) {
        this.photography = photography;
    }
}
