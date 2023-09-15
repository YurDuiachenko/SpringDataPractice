package com.example.springdatabasicdemo.dtos;

public class BeltBoxerCollectionDto {
    String nickname;
    String name;
    String surname;
    int price;
    String size;

    public BeltBoxerCollectionDto() {
    }

    public BeltBoxerCollectionDto(String nickname, int price, String size) {
        this.nickname = nickname;
        this.price = price;
        this.size = size;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "BeltBoxerCollectionDto{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
