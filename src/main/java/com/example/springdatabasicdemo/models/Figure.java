package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Figure")
public class Figure extends BaseEntity {

    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "size", nullable = false)
    private String size;
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @OneToMany(mappedBy = "figure", fetch = FetchType.LAZY)
    private Set<FigureOfBoxer> figureOfBoxers = new HashSet<>();


    void addFigureOfBoxer(FigureOfBoxer figureOfBoxer){
        figureOfBoxers.add(figureOfBoxer);
    }
    public Figure(Double price, String size) {
        this.price = price;
        this.size = size;
    }

    public Figure() {
    }

    public Long getd() {
        return getId();
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "id='" + getId() + '\'' +
                ",price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
