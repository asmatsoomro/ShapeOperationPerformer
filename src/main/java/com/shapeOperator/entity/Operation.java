package com.shapeOperator.entity;

import java.util.List;

public class Operation {


    private String operationType;
    private String operationId;
    private List<Coordinates> coordinates;
    private int deleteIndex;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public int getDeleteIndex() {
        return deleteIndex;
    }

    public void setDeleteIndex(int deleteIndex) {
        this.deleteIndex = deleteIndex;
    }


    public Operation(String operationType, String operationId, List<Coordinates> coordinates) {
        this.operationType = operationType;
        this.operationId = operationId;
        this.coordinates = coordinates;
    }

    public Operation(String operationType, String operationId, int deleteIndex) {
        this.operationType = operationType;
        this.operationId = operationId;
        this.deleteIndex = deleteIndex;
    }

    public Operation(String operationType, String operationId) {
        this.operationType = operationType;
        this.operationId = operationId;
    }


}
