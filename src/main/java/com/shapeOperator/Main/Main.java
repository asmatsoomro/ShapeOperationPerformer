package com.shapeOperator.Main;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.shapeOperator.core.ShapeService;
import com.shapeOperator.core.ShapeStatistics;
import com.shapeOperator.entity.Operation;
import com.shapeOperator.entity.Shape;

public class Main {

    public static void main(String[] args){

        String shapesFileName = System.getProperty("shapes");

        ShapeService shapeService = new ShapeService();
        List<Shape> shapes = shapeService.getAllShapes(shapesFileName);

        shapes.forEach(System.out::println);

        ShapeStatistics shapeStatistics = new ShapeStatistics();
        shapeStatistics.updateShapeStatistics(shapes);

        System.out.println("------------------------Statistics----------------------------");
        System.out.println("TriangleCount ::" + shapeStatistics.getTriangleCount());
        System.out.println("SquareCount ::" + shapeStatistics.getSquareCount());
        System.out.println("PentagonCount ::" + shapeStatistics.getPentagonCount());
        System.out.println("HexagonCount ::" + shapeStatistics.getHexagonCount());
        System.out.println("HeptagonCount ::" + shapeStatistics.getHeptaonCount());

        String operationsFileName = System.getProperty("operations");

        List<Operation> operations = shapeService.getAllOperations(operationsFileName);

        CopyOnWriteArrayList<Shape> shapes1 = new CopyOnWriteArrayList<>(shapes);

        List<Shape> updatedShapesList = shapeService.performOperationsOnShapes(shapes1, operations);

        System.out.println("----------------------------------------------------------");

        updatedShapesList.forEach(System.out::println);

        shapeStatistics = new ShapeStatistics();

        shapeStatistics.updateShapeStatistics(updatedShapesList);
        System.out.println("------------------------Statistics----------------------------");
        System.out.println("TriangleCount ::" + shapeStatistics.getTriangleCount());
        System.out.println("SquareCount ::" + shapeStatistics.getSquareCount());
        System.out.println("PentagonCount ::" + shapeStatistics.getPentagonCount());
        System.out.println("HexagonCount ::" + shapeStatistics.getHexagonCount());
        System.out.println("HeptagonCount ::" + shapeStatistics.getHeptaonCount());


        String updatedDbfileName = System.getProperty("updated");
        shapeService.updateShapes(updatedShapesList, updatedDbfileName);

    }


}
