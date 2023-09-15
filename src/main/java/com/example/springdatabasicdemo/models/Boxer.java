package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Boxer")
public class Boxer extends BaseEntity {
    @Column(name = "nickname", length = 255, nullable = false)
    private String nickname;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "surname", length = 255, nullable = false)
    private String surname;
    @Column(name = "height", nullable = false)
    private int height;
    @Column(name = "weight", nullable = false)
    private int weight;
    @Column(name = "style", length = 255, nullable = false)
    private String style;
    @OneToMany(mappedBy = "boxer")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Set<Belt> belts = new HashSet<>();
    @OneToMany(mappedBy = "boxer")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Set<FigureOfBoxer> figureOfBoxers = new HashSet<>();
    //getters, setters and constructors
    //...
    void addFigureOfBoxer(FigureOfBoxer figureOfBoxer){
        figureOfBoxers.add(figureOfBoxer);
    }
    void addBelt(Belt belt){
        belts.add(belt);
    }

    public Boxer() {
    }

    public Boxer(String nickname, String name, String surname, int height, int weight, String style) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.style = style;
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

    public Long getd() {
        return Long.parseLong(String.valueOf(getId()));
    }

    @Override
    public String toString() {
        return "Boxer{" +
                "id='" + getId() + '\'' +
                ",nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", style='" + style + '\'' +
                '}';
    }
}
