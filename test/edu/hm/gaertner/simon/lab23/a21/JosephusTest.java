package edu.hm.gaertner.simon.lab23.a21;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JosephusTest {
    @Test public void normalTestSet(){
        final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild", "Claudius", "Dieter", "Edda",
                "Friedrich", "Gudrun", "Hagen"));

        final List<String> want = new ArrayList<>();
        want.add("Alberich");


        assertEquals(want, josephus.hailTheKing(2,1));
    }

    @Test public void normalTestSetTwo(){
        final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild", "Claudius", "Dieter", "Edda",
                "Friedrich", "Gudrun", "Hagen"));

        final List<String> want = new ArrayList<>();
        want.add("Alberich");
        want.add("Edda");


        assertEquals(want, josephus.hailTheKing(2,2));
    }

    @Test public void normalTestSetThree(){
        final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild", "Claudius", "Dieter", "Edda",
                "Friedrich", "Gudrun", "Hagen"));

        final List<String> want = new ArrayList<>();
        want.add("Hagen");


        assertEquals(want, josephus.hailTheKing(1,1));
    }

    @Test public void normalTestSetFour(){
        final Josephus josephus = new Josephus(List.of("Alberich", "Brunhild", "Claudius", "Dieter", "Edda",
                "Friedrich", "Gudrun", "Hagen"));

        final List<String> want = new ArrayList<>();
        want.add("Gudrun");
        want.add("Hagen");


        assertEquals(want, josephus.hailTheKing(1,2));
    }

    @Test public void onlyOneElementInList(){
        final Josephus josephus = new Josephus(List.of("Alberich"));

        final List<String> want = new ArrayList<>();
        want.add("Alberich");


        assertEquals(want, josephus.hailTheKing(666,42));
    }

    @Test public void emptyList(){
        final Josephus josephus = new Josephus(List.of());

        final List<String> want = new ArrayList<>();


        assertEquals(want, josephus.hailTheKing(10,10));
    }

    @Test public void aliasing(){

        List<String> names = new ArrayList<>();
        names.add("Alberich");
        names.add("Brunhild");
        Josephus josephus = new Josephus(names);
        names.clear();

        final List<String> want = new ArrayList<>();
        want.add("Brunhild");


        assertEquals(want, josephus.hailTheKing(3, 1));
    }

    @Test(expected = NullPointerException.class )public void NPE (){
        final Josephus josephus = new Josephus(null);
    }

    @Test(expected = IllegalArgumentException.class) public void negativeBad(){
        final Josephus josephus = new Josephus(List.of("Alberich"));

        final List<String> want = new ArrayList<>();
        want.add("Alberich");


        assertEquals(want, josephus.hailTheKing(-1,42));
    }

    @Test(expected = IllegalArgumentException.class) public void negativeHappy(){
        final Josephus josephus = new Josephus(List.of("Alberich"));

        final List<String> want = new ArrayList<>();
        want.add("Alberich");


        assertEquals(want, josephus.hailTheKing(666,-1));
    }




}
