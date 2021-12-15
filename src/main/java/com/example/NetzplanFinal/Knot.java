package com.example.NetzplanFinal;

import java.util.ArrayList;
import java.util.List;

public class Knot {
    private int operationNumber;
    private String operationDescription;
    private int durationInMinutes;
    private int earliestStart;
    private int earliestEnd;
    private int latestStart;
    private int latestEnd;
    private int totalBuffer;
    private int freeBuffer;

    private List<Knot> successor = new ArrayList<>();
    private List<Knot> predecessor = new ArrayList<>();

    public void calculateEarliestTime(int earliestTime) {
        if (this.predecessor.size() > 0) {
            Knot result = this.predecessor.get(0);
            for (Knot predecessor : this.predecessor) {
                if (result.getEarliestEnd() < predecessor.getEarliestEnd()) {
                    result = predecessor;
                }
            }
            this.setEarliestStart(result.getEarliestEnd());
            this.setEarliestEnd(result.earliestStart + this.durationInMinutes);
        }else {
            this.setEarliestEnd(this.durationInMinutes);
        }
        if (this.successor.size() > 0) {
            for (Knot successor : this.successor) {
                successor.calculateEarliestTime(this.getEarliestEnd());
            }
        }
    }


    public static List<Knot> calculateCriticalPath() {



        return null;
    }

    public static List<Knot> calculateLatestTime() {

        return null;
    }

    public static List<Knot> calculateBuffer() {

        return null;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, int earliestStart, int earliestEnd, int latestStart, int latestEnd, int totalBuffer, int freeBuffer, List<Knot> successorList, List<Knot> predecessorList) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
        this.earliestStart = earliestStart;
        this.earliestEnd = earliestEnd;
        this.latestStart = latestStart;
        this.latestEnd = latestEnd;
        this.totalBuffer = totalBuffer;
        this.freeBuffer = freeBuffer;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, Object o, Object o1) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, List<Knot> successor, List<Knot> predecessor) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, List<Knot> successor, List<Knot> predecessor, int earliestStart, int earliestEnd) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
        this.successor = successor;
        this.predecessor = predecessor;
        this.earliestStart = earliestStart;
        this.earliestEnd = earliestEnd;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes) {
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getEarliestEnd() {
        return earliestEnd;
    }

    public void setEarliestEnd(int earliestEnd) {
        this.earliestEnd = earliestEnd;
    }

    public int getLatestStart() {
        return latestStart;
    }

    public void setLatestStart(int latestStart) {
        this.latestStart = latestStart;
    }

    public int getLatestEnd() {
        return latestEnd;
    }

    public void setLatestEnd(int latestEnd) {
        this.latestEnd = latestEnd;
    }

    public int getTotalBuffer() {
        return totalBuffer;
    }

    public void setTotalBuffer(int totalBuffer) {
        this.totalBuffer = totalBuffer;
    }

    public int getFreeBuffer() {
        return freeBuffer;
    }

    public void setFreeBuffer(int freeBuffer) {
        this.freeBuffer = freeBuffer;
    }

    public List<Knot> getSuccessor() {
        return successor;
    }

    public void setSuccessor(List<Knot> successor) {
    }

    public List<Knot> getPredecessor() {
        return predecessor;
    }

    public void setPredecessorList(List<Knot> predecessor) {
    }
}
