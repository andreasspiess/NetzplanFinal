package com.example.NetzplanFinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CalculateEarliestTime {

    @Test
    void test1() {
        List<Knot> knotList = new ArrayList<>();

        Knot knot1 = new Knot (1, "Wasser kochen", 5, Collections.emptyList());
        Knot knot2 = new Knot (2, "Nudeln kochen", 9, List.of(knot1));             //Vorgänger
        Knot knot3 = new Knot (3, "Nudeln abgießen", 1, List.of(knot2));
        Knot knot4 = new Knot (4, "Zwiebel schneiden", 1, Collections.emptyList());
        Knot knot5 = new Knot (5, "Zwiebel anbraten", 2, List.of(knot4));
        Knot knot6 = new Knot (6, "Tomaten schneiden", 4, List.of(knot4));
        Knot knot7 = new Knot (7, "Tomaten und Zwiebeln vereinen", 1, List.of(knot5, knot6));
        Knot knot8 = new Knot (8, "Soße einkochen", 15, List.of(knot7));
        Knot knot9 = new Knot (9, "Gewürze einkochen", 1, List.of(knot7));
        Knot knot10 = new Knot (10, "Essen anrichten", 2, List.of(knot3, knot8, knot9));

        //
        // NACHFOLGER setzen
        knot1.getSuccessor().add(knot2);
        knot2.getSuccessor().add(knot3);
        knot3.getSuccessor().add(knot10);
        knot4.getSuccessor().add(knot5);
        knot4.getSuccessor().add(knot6);
        knot5.getSuccessor().add(knot7);
        knot6.getSuccessor().add(knot7);
        knot7.getSuccessor().add(knot8);
        knot7.getSuccessor().add(knot9);
        knot8.getSuccessor().add(knot10);
        knot9.getSuccessor().add(knot10);

        // FAZ und FEZ setzen
        Assertions.assertEquals(0, knot1.getEarliestStart());
        Assertions.assertEquals(5, knot1.getEarliestEnd());

        Assertions.assertEquals(5, knot2.getEarliestStart());
        Assertions.assertEquals(14, knot2.getEarliestEnd());

        Assertions.assertEquals(14, knot3.getEarliestStart());
        Assertions.assertEquals(15, knot3.getEarliestEnd());

        Assertions.assertEquals(0, knot4.getEarliestStart());
        Assertions.assertEquals(1, knot4.getEarliestEnd());

        Assertions.assertEquals(1, knot5.getEarliestStart());
        Assertions.assertEquals(3, knot5.getEarliestEnd());

        Assertions.assertEquals(1, knot6.getEarliestStart());
        Assertions.assertEquals(5, knot6.getEarliestEnd());

        Assertions.assertEquals(5, knot7.getEarliestStart());
        Assertions.assertEquals(6, knot7.getEarliestEnd());

        Assertions.assertEquals(6, knot8.getEarliestStart());
        Assertions.assertEquals(21, knot8.getEarliestEnd());

        Assertions.assertEquals(6, knot9.getEarliestStart());
        Assertions.assertEquals(7, knot9.getEarliestEnd());

        Assertions.assertEquals(21, knot10.getEarliestStart());
        Assertions.assertEquals(23, knot10.getEarliestEnd());
    }
}





/* {
        List<Knot> knotList = new ArrayList<>();
        knotList.add(new Knot(1, "Entscheidung GE" ,2, null, null));
        knotList.add(new Knot(2, "Angebote einholen", 14, null, List.of(knotList.get(0))));
        knotList.add(new Knot(3, "Mitarbeiterinformationen", 1, null, List.of(knotList.get(0))));
        knotList.add(new Knot(4, "Testen G1", 1, null, List.of(knotList.get(1))));
        knotList.add(new Knot(5, "Testen G2", 2, null, List.of(knotList.get(1))));
        knotList.add(new Knot(6, "Testen G3", 1, null, List.of(knotList.get(1))));
        knotList.add(new Knot(7, "Auswahl Lieferanten", 1, null, List.of(knotList.get(3), knotList.get(4), knotList.get(5))));
        knotList.add(new Knot(8, "Lieferung", 5, null, List.of(knotList.get(6))));
        knotList.add(new Knot(9, "Raumauswahl", 2, null, List.of(knotList.get(6))));
        knotList.add(new Knot(10, "Elektroinstallation", 2, null, List.of(knotList.get(8))));
        knotList.add(new Knot(11, "Computeraufstellung", 1, null, List.of(knotList.get(7), knotList.get(9))));
        knotList.add(new Knot(12, "Mitarbeiterschulung", 7, null, List.of(knotList.get(2), knotList.get(10))));
        knotList.add(new Knot(13, "Arbeitsaufnahme", 1, null, List.of(knotList.get(11))));

        knotList.get(0).setSuccessor(List.of(knotList.get(1), knotList.get(2)));
        knotList.get(1).setSuccessor(List.of(knotList.get(3), knotList.get(4), knotList.get(5)));
        knotList.get(2).setSuccessor(List.of(knotList.get(11)));
        knotList.get(3).setSuccessor(List.of(knotList.get(6)));
        knotList.get(4).setSuccessor(List.of(knotList.get(6)));
        knotList.get(5).setSuccessor(List.of(knotList.get(6)));
        knotList.get(6).setSuccessor(List.of(knotList.get(7), knotList.get(8)));
        knotList.get(7).setSuccessor(List.of(knotList.get(10)));
        knotList.get(8).setSuccessor(List.of(knotList.get(9)));
        knotList.get(9).setSuccessor(List.of(knotList.get(10)));
        knotList.get(10).setSuccessor(List.of(knotList.get(11)));
        knotList.get(11).setSuccessor(List.of(knotList.get(12)));
        return knotList;
    }

    private List<Knot> resultList() {
        List<Knot> resultList = new ArrayList<>();
        resultList.add(new Knot(1, "Entscheidung GE",2, null, null, 0, 2 ));
        resultList.add(new Knot(2, "Angebote einholen", 14, null, List.of(resultList.get(0)), 2, 16));
        resultList.add(new Knot(3,"Mitarbeiterinformationen", 1, null, List.of(resultList.get(0)),2, 3));
        resultList.add(new Knot(4,"Testen G1", 1, null, List.of(resultList.get(1)),16, 17));
        resultList.add(new Knot(5,"Testen G2", 2, null, List.of(resultList.get(1)),16, 18));
        resultList.add(new Knot(6,"Testen G3", 1, null, List.of(resultList.get(1)),16, 17));
        resultList.add(new Knot(7,"Auswahl Lieferanten", 1, null, List.of(resultList.get(3), resultList.get(4), resultList.get(5)), 18, 19));
        resultList.add(new Knot(8,"Lieferung", 5, null, List.of(resultList.get(6)),19, 24));
        resultList.add(new Knot(9,"Raumauswahl", 2, null, List.of(resultList.get(6)),19, 21));
        resultList.add(new Knot(10,"Elektroinstallation", 2, null, List.of(resultList.get(8)),21, 23));
        resultList.add(new Knot(11,"Computeraufstellung", 1, null, List.of(resultList.get(7), resultList.get(9)), 24,25));
        resultList.add(new Knot(12,"Mitarbeiterschulung", 7, null, List.of(resultList.get(2), resultList.get(10)), 25, 32));
        resultList.add(new Knot(13,"Arbeitsaufnahme", 1, null, List.of(resultList.get(11)),32, 33));

        resultList.get(0).setSuccessor(List.of(resultList.get(1),resultList.get(2)));
        resultList.get(1).setSuccessor(List.of(resultList.get(3),resultList.get(4), resultList.get(5)));
        resultList.get(2).setSuccessor(List.of(resultList.get(11)));
        resultList.get(3).setSuccessor(List.of(resultList.get(6)));
        resultList.get(4).setSuccessor(List.of(resultList.get(6)));
        resultList.get(5).setSuccessor(List.of(resultList.get(6)));
        resultList.get(6).setSuccessor(List.of(resultList.get(7), resultList.get(8)));
        resultList.get(7).setSuccessor(List.of(resultList.get(10)));
        resultList.get(8).setSuccessor(List.of(resultList.get(9)));
        resultList.get(9).setSuccessor(List.of(resultList.get(10)));
        resultList.get(10).setSuccessor(List.of(resultList.get(11)));
        resultList.get(11).setSuccessor(List.of(resultList.get(12)));
        return resultList;
    }

    @Test
    void Test1() {
        List<Knot> knotList = knotList();
        List<Knot> resultList = resultList();

        for (Knot knot : knotList) {
            List<Knot> predecessor = knot.getPredecessor();
            if (predecessor == null) {
                knot.calculateEarliestTime(0);
            }
        }
        Assertions.assertEquals(16, knotList.get(1).getEarliestEnd());
        Assertions.assertEquals(17, knotList.get(5).getEarliestEnd());
        Assertions.assertEquals(19, knotList.get(6).getEarliestEnd());
        Assertions.assertEquals(23, knotList.get(9).getEarliestEnd());
        Assertions.assertEquals(25, knotList.get(10).getEarliestEnd());
        Assertions.assertEquals(3, knotList.get(2).getEarliestEnd());
        Assertions.assertEquals(32, knotList.get(11).getEarliestEnd());
        Assertions.assertEquals(33, knotList.get(12).getEarliestEnd());
    }
}*/
