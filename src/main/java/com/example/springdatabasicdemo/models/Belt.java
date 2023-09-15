package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Belt")
public class Belt extends BaseEntity {

    @Column(name = "boxer_ID")
    private Long boxer_ID;
    @Column(name = "org_ID")
    private Long org_ID;
    @Column(name = "year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(
            name = "boxer_ID",
            insertable = false, updatable = false)
    private Boxer boxer;
    @ManyToOne
    @JoinColumn(
            name = "org_ID",
            insertable = false, updatable = false)
    private BoxingOrganization org;

    public Belt(
            int year,
            Boxer boxer,
            BoxingOrganization org) {
        this.year = year;
        this.boxer = boxer;
        this.org = org;
        this.boxer_ID = boxer.getId();
        this.org_ID = org.getId();
        boxer.addBelt(this);
        org.addBelt(this);
    }

    public Belt() {
    }

    public Long getBoxer_ID() {
        return boxer_ID;
    }

    public void setBoxer_ID(Long boxer_ID) {
        this.boxer_ID = boxer_ID;
    }

    public Long getOrg_ID() {
        return org_ID;
    }

    public void setOrg_ID(Long org_ID) {
        this.org_ID = org_ID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //    @Column(name = "boxer_ID", nullable = false)
//    Long boxer_ID;
//
//    @Column(name = "org_ID", nullable = false)
//    Long org_ID;
//
//    int year;


    @Override
    public String toString() {
        return "Belt{" +
                "id=" + id +
                ", year=" + year +
                ", boxer=" + boxer +
                ", org=" + org +
                '}';
    }
}
