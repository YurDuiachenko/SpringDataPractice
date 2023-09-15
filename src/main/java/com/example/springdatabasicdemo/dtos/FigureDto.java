package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.BaseEntity;
import com.example.springdatabasicdemo.models.Boxer;
import com.example.springdatabasicdemo.models.Figure;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;


public class FigureDto {
    private Long id;
    Double price;
    String size;

    public FigureDto(Double price, String size) {
        this.price = price;
        this.size = size;
    }

    public FigureDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "FigureDto{" +
                "id=" + id +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
