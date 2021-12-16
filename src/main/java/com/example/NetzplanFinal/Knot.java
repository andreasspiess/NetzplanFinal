package com.example.NetzplanFinal;

import java.util.ArrayList;
import java.util.List;

public class Knot {
    private int operationNumber;
    private String operationDescription;
    private int durationInMinutes;
    private int latestStart;
    private int latestEnd;
    private int totalBuffer;
    private int freeBuffer;

    public List<Knot> successor = new ArrayList<>();
    public List<Knot> predecessor = new ArrayList<>();

    //Predecessor = VORGÄNGER!!

    public void calculateEarliestTime(int earliestTime) {



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

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, List<Knot> predecessor) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
        this.predecessor = predecessor;
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

    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;

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
    // Predecessor = Vorgänger
    // Den größten Wert (Frühester Endzeitpunkt) von allen Vorgängern nehmen
    public int getEarliestStart() {
        int result = 0;
        // für jeden Vorgänger in der Liste
        for (Knot knot : this.getPredecessor()) {
            int fez = knot.getEarliestEnd();
            if (result < fez) {
                result = fez;
            }
        }
        return result;

    }
    // (spätester Endzeitpunkt)
    public int getEarliestEnd() {
        return this.getEarliestStart() + this.durationInMinutes;
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
