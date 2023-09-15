package com.example.springdatabasicdemo.dtos;

public class PriceForFigureDto {
    int price;

    public PriceForFigureDto(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public PriceForFigureDto() {
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceForFigureDto{" +
                "price=" + price +
                '}';
    }
}
