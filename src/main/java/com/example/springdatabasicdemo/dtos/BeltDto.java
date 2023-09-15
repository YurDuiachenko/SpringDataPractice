package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.BoxingOrganization;
import jakarta.persistence.*;

import java.io.Serializable;

public class BeltDto {
    private Long id;
    private Long boxer_id;
    private Long org_id;
    private int year;
    private BoxerDto boxer;
    private BoxingOrganizationDto org;

    public BeltDto(int year) {
        this.year = year;
    }

    public BeltDto(Long boxer_ID, Long org_ID, int year) {
        this.boxer_id = boxer_ID;
        this.org_id = org_ID;
        this.year = year;
    }

    public BeltDto(Long id, Long boxer_id, Long org_id, int year) {
        this.id = id;
        this.boxer_id = boxer_id;
        this.org_id = org_id;
        this.year = year;
    }

    public Long getBoxer_id() {
        return boxer_id;
    }

    public void setBoxer_id(Long boxer_id) {
        this.boxer_id = boxer_id;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public BeltDto() {
    }

    public BeltDto(BoxerDto boxer, BoxingOrganizationDto org, int year) {
        this.boxer = boxer;
        this.org = org;
        this.boxer_id = boxer.getId();
        this.org_id = org.getId();
        this.year = year;
    }

    public BoxerDto getBoxer() {
        return boxer;
    }

    public void setBoxer(BoxerDto boxer) {
        this.boxer = boxer;
    }

    public BoxingOrganizationDto getOrg() {
        return org;
    }

    public void setOrg(BoxingOrganizationDto org) {
        this.org = org;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BeltDto{" +
                "id=" + id +
                ", boxer_id=" + boxer_id +
                ", org_id=" + org_id +
                ", year=" + year +
                ", boxer=" + boxer.toString() +
                ", org=" + org.toString() +
                '}';
    }
}
