package com.example.NetzplanFinal;

import java.util.ArrayList;
import java.util.List;

public class Knot {
    private int operationNumber;
    private String operationDescription;
    private int durationInMinutes;
    private int totalBuffer;
    private int freeBuffer;

    public List<Knot> successor = new ArrayList<>();
    public List<Knot> predecessor = new ArrayList<>();

    //frühester Startzeitpunkt
    // Predecessor = Vorgänger
    // Den größten Wert (Frühester Endzeitpunkt) von allen Vorgängern nehmen
    public int getEarliestStart() {
        int result = 0;
        // für jeden Vorgänger in der Liste
        for (Knot knot : this.getPredecessor()) {
            // jede Einheit wird mit dem result verglichen, der größte Wert wird genommen.
            int fez = knot.getEarliestEnd();
            if (result < fez) {
                result = fez;
            }
        }
        return result;

    }
    // (frühester Endzeitpunkt)
    public int getEarliestEnd() {
        return this.getEarliestStart() + this.durationInMinutes;
    }


    // spätester Startzeitpunkt
    public int getLatestStart() {
        return getLatestEnd() - durationInMinutes;
    }


    // spätester Endzeitpunkt
    public int getLatestEnd() {
        //Fall 1
        int result = Integer.MAX_VALUE;
        if (this.successor.size() == 0) {
            int sezFinish = this.getEarliestEnd();
            return sezFinish;
        } else {
            for (int i=0; i < getSuccessor().size(); i++) {
                Knot successor = getSuccessor().get(i);

                int successorSAZ = successor.getLatestStart();

                if (successorSAZ < result) {
                    result = successorSAZ;
                }
            }
        }
        return result;
    }
    //  Berechnen Gesammt Puffer
    public int caclulateTotalBuffer() {
        int totalBuffer = this.getLatestStart() - this.getEarliestStart();

        return totalBuffer;
    }

    public int calculateFreeBuffer() {
        int freeBuffer = 0;
        if (this.successor.size() != 0) {
            int successorEarliestStart = successor.get(0).getEarliestStart();
            freeBuffer = successorEarliestStart - this.getEarliestEnd();
        } else {
            return 0;
        }
        return freeBuffer;
    }

    public List<Knot> calculateCriticalPath() {
        List<Knot> criticalPath = new ArrayList<>();
        Knot criticalKnot = this;
        // Start ist der Knoten, der kein Nachfolger hat. -> 10
        if (successor.isEmpty()) {
            criticalPath.add(criticalKnot);

            while (!criticalKnot.getPredecessor().isEmpty())
                // alle Vorgänger prüfen (max. 3), ob der Wert total- und freier Puffer 0 beträgt.
                for (int i = 0; i < criticalKnot.getPredecessor().size(); i++) {
                    if (criticalKnot.getPredecessor().get(i).caclulateTotalBuffer() == 0 && criticalKnot.getPredecessor().get(i).calculateFreeBuffer() == 0) {
                        // Knoten wird der Liste hinzugefügt.
                        criticalKnot = criticalKnot.getPredecessor().get(i);
                        criticalPath.add(criticalKnot);
                    }
                }
            }
        return criticalPath;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, int totalBuffer, int freeBuffer) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;
        this.totalBuffer = totalBuffer;
        this.freeBuffer = freeBuffer;
    }

    public Knot(int operationNumber, String operationDescription, int durationInMinutes, int earliestStart, int earliestEnd, int latestStart, int latestEnd, int totalBuffer, int freeBuffer, List<Knot> successorList, List<Knot> predecessorList) {
        this.operationNumber = operationNumber;
        this.operationDescription = operationDescription;
        this.durationInMinutes = durationInMinutes;

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

    @Override
    public String toString() {
        return "Knot{" +
                "operationNumber=" + operationNumber +
                ", operationDescription='" + operationDescription + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", totalBuffer=" + totalBuffer +
                ", freeBuffer=" + freeBuffer +
//                ", successor=" + successor +
//                ", predecessor=" + predecessor +
                '}';
    }

    public void setPredecessor(List<Knot> predecessor) {
        this.predecessor = predecessor;
    }
}
