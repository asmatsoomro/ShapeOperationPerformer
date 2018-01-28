package com.shapeOperator.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.shapeOperator.entity.Coordinates;
import com.shapeOperator.entity.Operation;
import com.shapeOperator.entity.Shape;

public class ShapePersistanceStore {

    public List<Shape> getAllShapes(String fileName) {

        List<Shape> shapeList = new ArrayList<>();

        try (Stream<String> shapes = Files.lines(Paths.get(fileName))) {

            shapes.forEach(shape -> {
                String[] shapeTokens = shape.split("\\|");
                List<Coordinates> coordinatesList = getAllShapeCoordinates(shapeTokens[1]);
                shapeList.add(new Shape(shapeTokens[0], coordinatesList));
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
        return shapeList;
    }

    private List<Coordinates> getAllShapeCoordinates(String coordinatesToken) {
        List<Coordinates> coordinatesList = new ArrayList<>();
        String[] coordinates = coordinatesToken.split(";");

        for (int i = 0; i < coordinates.length; i++) {
            String[] coordinate = coordinates[i].split(",");
            coordinatesList.add(new Coordinates(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])));
        }
        return coordinatesList;
    }


    List<Operation> getAllOperations(String fileName) {
        List<Operation> operationList = new ArrayList<>();

        try (Stream<String> shapes = Files.lines(Paths.get(fileName))) {

            shapes.forEach(shape -> {
                String[] operationTokens = shape.split("\\|");

                if (operationTokens[0].equals("delete-point")) {
                    operationList.add(new Operation(operationTokens[0], operationTokens[1], Integer
                            .parseInt(operationTokens[2])));
                } else if (operationTokens[0].equals("delete-shape")) {
                    operationList.add(new Operation(operationTokens[0], operationTokens[1]));
                } else {
                    List<Coordinates> coordinatesList = getAllShapeCoordinates(operationTokens[2]);
                    operationList.add(new Operation(operationTokens[0], operationTokens[1], coordinatesList));
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        return operationList;

    }

    void insertUpdatedShapesInFile(List<Shape> updatedShapesList, String fileName) {


        File file = new File(fileName);

        if (!file.getAbsoluteFile().exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            updatedShapesList.forEach(shape -> {
                try {
                    StringBuilder coordinates = new StringBuilder();

                    for (int i = 0; i < shape.getCoordinates().size(); i++) {
                        if (i == shape.getCoordinates().size()) {
                            coordinates.append(shape.getCoordinates().get(i).getX());
                            coordinates.append(",");
                            coordinates.append(shape.getCoordinates().get(i).getY());
                        } else {
                            coordinates.append(shape.getCoordinates().get(i).getX());
                            coordinates.append(",");
                            coordinates.append(shape.getCoordinates().get(i).getY());
                            coordinates.append(";");
                        }

                    }

                    bw.write(shape.getId() + "|" + coordinates.toString());
                    bw.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
