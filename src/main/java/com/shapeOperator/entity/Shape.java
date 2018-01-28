package com.shapeOperator.entity;

import java.util.List;

public class Shape {


    private String id;
    private List<Coordinates> coordinates;

    public Shape(String id, List<Coordinates> coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id='" + id + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

}
