package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

public class BoxingOrganizationDto {
    private Long id;
    String org_name;
    int found_year;

    public BoxingOrganizationDto(String org_name, int found_year) {
        this.org_name = org_name;
        this.found_year = found_year;
    }

    public BoxingOrganizationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public int getFound_year() {
        return found_year;
    }

    public void setFound_year(int found_year) {
        this.found_year = found_year;
    }

    @Override
    public String toString() {
        return "BoxingOrganizationDto{" +
                "id=" + id +
                ", org_name='" + org_name + '\'' +
                ", found_year=" + found_year +
                '}';
    }
}
