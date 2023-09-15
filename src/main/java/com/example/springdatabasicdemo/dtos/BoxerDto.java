package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.BaseEntity;
import com.example.springdatabasicdemo.models.Belt;
import com.example.springdatabasicdemo.models.FigureOfBoxer;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


public class BoxerDto {
    private Long id;
    String nickname;
    String name;
    String surname;
    int height;
    int weight;
    String style;

//    private Set<Belt> belts = new HashSet<>();
//
//    void addBelt(Belt belt){
//        belts.add(belt);
//    }
//
//    private Set<FigureOfBoxer> figureOfBoxers = new HashSet<>();
//
//    public Set<Belt> getBelts() {
//        return belts;
//    }
//
//    public void setBelts(Set<Belt> belts) {
//        this.belts = belts;
//    }
//
//    public Set<FigureOfBoxer> getFigureOfBoxers() {
//        return figureOfBoxers;
//    }
//
//    public void setFigureOfBoxers(Set<FigureOfBoxer> figureOfBoxers) {
//        this.figureOfBoxers = figureOfBoxers;
//    }

    public BoxerDto() {
    }

    public BoxerDto(String nickname, String name, String surname, int height, int weight, String style) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "BoxerDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", style='" + style + '\'' +
                '}';
    }
}
