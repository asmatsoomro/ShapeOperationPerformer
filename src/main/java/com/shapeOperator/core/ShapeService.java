package com.shapeOperator.core;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.shapeOperator.entity.Coordinates;
import com.shapeOperator.entity.Operation;
import com.shapeOperator.entity.Shape;

public class ShapeService {

    ShapePersistanceStore shapePersistanceStore = new ShapePersistanceStore();

    public List<Shape> getAllShapes(String fileName) {
        return shapePersistanceStore.getAllShapes(fileName);
    }


    public List<Operation> getAllOperations(String fileName) {
        return shapePersistanceStore.getAllOperations(fileName);
    }

    public List<Shape> performOperationsOnShapes(CopyOnWriteArrayList<Shape> shapes, List<Operation> operations) {

        for (int i =0; i<operations.size(); i++){
            for (int j= 0; j < shapes.size(); j++) {

                if (operations.get(i).getOperationType().equals("create-shape")) {
                    shapes.add(new Shape(operations.get(i).getOperationId(), operations.get(i).getCoordinates()));
                    break;
                } else if (shapes.get(j).getId().equals(operations.get(i).getOperationId())){
                    if (operations.get(i).getOperationType().equals("delete-shape")){
                        shapes.remove(shapes.get(j));
                        break;
                    }
                    else if (operations.get(i).getOperationType().equals("delete-point")){
                        shapes.get(j).getCoordinates().remove(operations.get(i).getDeleteIndex());
                        break;
                    }
                    else if (operations.get(i).getOperationType().equals("add-point")){
                        List<Coordinates> coordinates = shapes.get(j).getCoordinates();
                       for (int k=0; k< operations.get(i).getCoordinates().size(); k++){
                            coordinates.add(operations.get(i).getCoordinates().get(k));
                           }
                        break;
                    }
                }

            }
        }

        return shapes;
    }

    public void updateShapes(List<Shape> updatedShapesList, String fileName) {
            shapePersistanceStore.insertUpdatedShapesInFile(updatedShapesList, fileName);

    }
}
