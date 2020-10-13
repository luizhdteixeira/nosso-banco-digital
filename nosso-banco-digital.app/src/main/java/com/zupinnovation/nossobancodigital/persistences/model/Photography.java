package com.zupinnovation.nossobancodigital.persistences.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Photography implements Serializable {

    private static final long serialVersionUID = - 3127549898079011586L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photography that = (Photography) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
