package com.example.NetzplanFinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConvertKnotInputFormToKnotList {

    @Test
    void test1() {
    List<KnotInputForm> knotInputFormList = new ArrayList<>();

    KnotInputForm knotInputForm1 = new KnotInputForm(1, "Wasser kochen", 5, null, null, null);
    KnotInputForm knotInputForm2 = new KnotInputForm(2, "Nudeln kochen", 9, 0, null, null);
    KnotInputForm knotInputForm3 = new KnotInputForm(3, "Nudeln abkochen", 1, 1, null, null);
    KnotInputForm knotInputForm4 = new KnotInputForm(4, "Zwiebel schneiden", 1, null, null, null);
    KnotInputForm knotInputForm5 = new KnotInputForm(5, "Zwiebel anbraten", 2, 3, null, null);
    KnotInputForm knotInputForm6 = new KnotInputForm(6, "Tomaten schneiden", 4, 3, null, null);
    KnotInputForm knotInputForm7 = new KnotInputForm(7, "Tomaten und Zwiebel vereinen", 1, 4, 5, null);
    KnotInputForm knotInputForm8 = new KnotInputForm(8, "Soße einkochen", 15, 6, null, null);
    KnotInputForm knotInputForm9 = new KnotInputForm(9, "Gewürze hinzugeben", 1, 6, null, null);
    KnotInputForm knotInputForm10 = new KnotInputForm(10, "Essen anrichten", 2, 2, 7, 8);



    knotInputFormList.add(0,knotInputForm1); //index0
    knotInputFormList.add(1,knotInputForm2); //index1
    knotInputFormList.add(2,knotInputForm3); //index2
    knotInputFormList.add(3,knotInputForm4); //index3
    knotInputFormList.add(4,knotInputForm5); //index4
    knotInputFormList.add(5,knotInputForm6);
    knotInputFormList.add(6,knotInputForm7);
    knotInputFormList.add(7,knotInputForm8);
    knotInputFormList.add(8,knotInputForm9);
    knotInputFormList.add(9,knotInputForm10);

    NetPlanController netzPlanController = new NetPlanController();
    List<Knot> listToKnotList = netzPlanController.convertKnotInputFormListToKnotList(knotInputFormList);

        Assertions.assertEquals(10, listToKnotList.size());
        Assertions.assertEquals("Zwiebel schneiden", listToKnotList.get(3).getOperationDescription());
        Assertions.assertEquals(15, listToKnotList.get(7).getDurationInMinutes());
        Assertions.assertEquals(1, listToKnotList.get(1).getPredecessor().size());
        // Vorgänger prüfen
        Assertions.assertEquals(listToKnotList.get(0), listToKnotList.get(1).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(1), listToKnotList.get(2).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(3), listToKnotList.get(4).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(3), listToKnotList.get(5).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(5), listToKnotList.get(6).getPredecessor().get(1));
        Assertions.assertEquals(listToKnotList.get(4), listToKnotList.get(6).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(6), listToKnotList.get(7).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(6), listToKnotList.get(8).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(2), listToKnotList.get(9).getPredecessor().get(0));
        Assertions.assertEquals(listToKnotList.get(7), listToKnotList.get(9).getPredecessor().get(1));
        Assertions.assertEquals(listToKnotList.get(8), listToKnotList.get(9).getPredecessor().get(2));

        Assertions.assertEquals(listToKnotList.get(1), listToKnotList.get(0).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(2), listToKnotList.get(1).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(9), listToKnotList.get(2).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(4), listToKnotList.get(3).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(4), listToKnotList.get(3).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(6), listToKnotList.get(4).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(6), listToKnotList.get(5).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(7), listToKnotList.get(6).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(8), listToKnotList.get(6).getSuccessor().get(1));
        Assertions.assertEquals(listToKnotList.get(9), listToKnotList.get(7).getSuccessor().get(0));
        Assertions.assertEquals(listToKnotList.get(9), listToKnotList.get(8).getSuccessor().get(0));
    }
}
