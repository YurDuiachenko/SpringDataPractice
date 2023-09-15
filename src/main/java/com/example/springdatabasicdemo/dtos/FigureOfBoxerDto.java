package com.example.springdatabasicdemo.dtos;

import jakarta.persistence.Column;

public class FigureOfBoxerDto {
    Long id;
    Long boxer_id;
    Long figure_id;
    private BoxerDto boxer;
    private FigureDto figure;


    public FigureOfBoxerDto(Long boxer_id, Long figure_id) {
        this.boxer_id = boxer_id;
        this.figure_id = figure_id;
    }

    public FigureOfBoxerDto() {
    }

    public FigureOfBoxerDto(BoxerDto boxer, FigureDto figure) {
        this.boxer_id = boxer.getId();
        this.figure_id = figure.getId();
        this.boxer = boxer;
        this.figure = figure;
    }

    public FigureOfBoxerDto(Long id, Long boxer_id, Long figure_id, BoxerDto boxer, FigureDto figure) {
        this.id = id;
        this.boxer_id = boxer_id;
        this.figure_id = figure_id;
        this.boxer = boxer;
        this.figure = figure;
    }

    public FigureOfBoxerDto(Long id, Long boxer_id, Long figure_id) {
        this.id = id;
        this.boxer_id = boxer_id;
        this.figure_id = figure_id;
    }

    public BoxerDto getBoxer() {
        return boxer;
    }

    public void setBoxer(BoxerDto boxer) {
        this.boxer = boxer;
    }

    public FigureDto getFigure() {
        return figure;
    }

    public void setFigure(FigureDto figure) {
        this.figure = figure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "FigureOfBoxerDto{" +
                "id=" + id +
                ", boxer_id=" + boxer_id +
                ", figure_id=" + figure_id +
                ", boxer=" + boxer.toString() +
                ", figure=" + figure.toString() +
                '}';
    }
}
