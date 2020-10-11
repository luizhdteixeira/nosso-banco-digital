package com.zupinnovation.nossobancodigital.persistences.dto;

import javax.validation.constraints.NotBlank;

public class PhotographyDTO {

    @NotBlank
    private String name;
    @NotBlank
    private byte[] img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
