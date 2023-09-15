package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BoxingOrganization")
public class BoxingOrganization extends BaseEntity {

    @Column(name = "org_name", nullable = false)
    String org_name;
    @Column(name = "found_year", nullable = false)
    int found_year;

    @OneToMany(mappedBy = "org")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Set<Belt> belts = new HashSet<>();

    void addBelt(Belt belt){
        belts.add(belt);
    }

    public BoxingOrganization(String org_name, int found_year) {
        this.org_name = org_name;
        this.found_year = found_year;
    }

    public BoxingOrganization() {
    }

    @Override
    public Long getId() {
        return super.getId();
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

    public Set<Belt> getBelts() {
        return belts;
    }

    public void setBelts(Set<Belt> belts) {
        this.belts = belts;
    }

    @Override
    public String toString() {
        return "BoxingOrganization{" +
                "org_name='" + org_name + '\'' +
                ", found_year=" + found_year +
                ", belts=" + belts +
                '}';
    }
}
