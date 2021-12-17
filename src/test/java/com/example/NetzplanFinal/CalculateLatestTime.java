package com.example.NetzplanFinal;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculateLatestTime {

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

        Assertions.assertEquals(21,knot10.getLatestStart());
        Assertions.assertEquals(23,knot10.getLatestEnd());

        Assertions.assertEquals(21,knot9.getLatestEnd());
        Assertions.assertEquals(20,knot9.getLatestStart());

        Assertions.assertEquals(6,knot8.getLatestStart());
        Assertions.assertEquals(21,knot8.getLatestEnd());

        Assertions.assertEquals(5,knot7.getLatestStart());
        Assertions.assertEquals(6,knot7.getLatestEnd());

        Assertions.assertEquals(1,knot6.getLatestStart());
        Assertions.assertEquals(5,knot6.getLatestEnd());

        Assertions.assertEquals(3,knot5.getLatestStart());
        Assertions.assertEquals(5,knot5.getLatestEnd());

        Assertions.assertEquals(0,knot4.getLatestStart());
        Assertions.assertEquals(1,knot4.getLatestEnd());

        Assertions.assertEquals(20,knot3.getLatestStart());
        Assertions.assertEquals(21,knot3.getLatestEnd());

        Assertions.assertEquals(11,knot2.getLatestStart());
        Assertions.assertEquals(20,knot2.getLatestEnd());

        Assertions.assertEquals(6,knot1.getLatestStart());
        Assertions.assertEquals(11,knot1.getLatestEnd());
    }
}