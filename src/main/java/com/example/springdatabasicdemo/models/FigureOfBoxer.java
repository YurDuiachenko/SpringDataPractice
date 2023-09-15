package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "FigureOfBoxer")
public class FigureOfBoxer  extends BaseEntity {

    @Column(name = "boxer_id")
    private Long boxer_id;
    @Column(name = "figure_id")
    private Long figure_id;

    @ManyToOne(optional = true)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @JoinColumn(
            name = "boxer_id",
            insertable = false, updatable = false)
    private Boxer boxer;
    @ManyToOne(optional = true)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @JoinColumn(
            name = "figure_id",
            insertable = false, updatable = false)
    private Figure figure;

    public FigureOfBoxer(
            Boxer boxer,
            Figure figure) {
        this.boxer_id = boxer.getd();
        this.figure_id = figure.getd();
        boxer.addFigureOfBoxer(this);
        figure.addFigureOfBoxer(this);
        setBoxer(boxer);
        this.figure = figure;
    }

    public FigureOfBoxer() {
    }

    public Long getBoxer_id() {
        return boxer_id;
    }

    public void setBoxer_id(Long boxer_id) {
        this.boxer_id = boxer_id;
    }

    public Long getFigure_id() {
        return figure_id;
    }

    public void setFigure_id(Long figure_id) {
        this.figure_id = figure_id;
    }

    public Boxer getBoxer() {
        return boxer;
    }

    public void setBoxer(Boxer boxer) {
        this.boxer = boxer;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "FigureOfBoxer{" +
                "boxer_id=" + boxer_id +
                ", figure_id=" + figure_id +
                ", boxer=" + boxer.toString() +
                ", figure=" + figure.toString() +
                '}';
    }
}
