package com.zupinnovation.nossobancodigital.persistences.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Photography implements Serializable {

    private static final long serialVersionUID = - 3127549898079011586L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private byte[] img;

    public Photography() {
    }

    public Photography(String name, byte[] img) {
        this.name = name;
        this.img = img;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

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
