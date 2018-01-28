package com.shapeOperator.core;

import java.util.List;

import com.shapeOperator.entity.Shape;

public class ShapeStatistics {

    private int triangleCount = 0;
    private int squareCount = 0;
    private int pentagonCount = 0;
    private int hexagonCount= 0;
    private int heptaonCount = 0;


    public int getTriangleCount() {
        return triangleCount;
    }

    public void updateShapeStatistics(List<Shape> shapes){
        shapes.forEach( shape -> updateShapeStatistics(shape.getCoordinates().size()));
    }

    private void updateShapeStatistics(int coordinatesCount){

        if (coordinatesCount == 3){
            incrementTriangleCount();
        }
        else if (coordinatesCount == 4){
            incrementSquareCount();
        }
        else if (coordinatesCount == 5){
            incrementPentagonCount();
        }
        else if (coordinatesCount == 6){
            incrementHexagonCount();
        }
        else if (coordinatesCount == 7){
            incrementHeptaonCount();
        }


    }


    public void incrementTriangleCount() {
        triangleCount++;
    }

    public int getSquareCount() {
        return squareCount;
    }

    public void incrementSquareCount() {
        squareCount++;
    }

    public int getPentagonCount() {
        return pentagonCount;
    }

    public void incrementPentagonCount() {
        pentagonCount++;
    }

    public int getHexagonCount() {
        return hexagonCount;
    }

    public void incrementHexagonCount() {
        hexagonCount++;
    }

    public int getHeptaonCount() {
        return heptaonCount;
    }

    public void incrementHeptaonCount() {
        heptaonCount++;
    }

}
