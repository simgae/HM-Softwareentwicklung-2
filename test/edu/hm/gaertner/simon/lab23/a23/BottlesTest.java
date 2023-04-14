package edu.hm.gaertner.simon.lab23.a23;

import edu.hm.cs.rs.se.ss23.a23.Bottle;
import edu.hm.cs.rs.se.ss23.a23.fluid.*;
import org.junit.Test;

import java.util.List;

import static edu.hm.gaertner.simon.lab23.a23.Bottles.*;
import static org.junit.Assert.assertEquals;

public class BottlesTest {
    @Test
    public void tryFillAndTryConsume() {

        Bottle<Drink> bd = new Bottle<>();

        tryFill(bd, new Beer());

        final Beer want = new Beer();

        assertEquals(want, tryConsume(bd));
    }

    @Test
    public void tryFillIsFullAndTryConsume() {

        Bottle<Drink> bd = new Bottle<>();

        tryFill(bd, new Beer());
        tryFill(bd, new Milk());

        final Beer want = new Beer();

        assertEquals(want, tryConsume(bd));
    }

    @Test
    public void tryConsumeEmpty() {

        Bottle<Drink> bd = new Bottle<>();


        final Beer want = null;

        assertEquals(want, tryConsume(bd));
    }

    @Test
    public void peekInto() {

        Bottle<Drink> bd = new Bottle<>();

        tryFill(bd, new Beer());

        final Beer want = new Beer();

        assertEquals(want, Bottles.peekInto(bd));
    }

    @Test
    public void peekIntoEmpty() {

        Bottle<Drink> bd = new Bottle<>();

        final Beer want = null;

        assertEquals(want, Bottles.peekInto(bd));
    }

    @Test
    public void countWithZero() {

        Bottle<Drink> bd = new Bottle<>();
        tryFill(bd, new Beer());

        final int have = Bottles.countWith(new Nitro(), List.of(bd, bd, new Bottle<Fuel>()));
        final int want = 0;

        assertEquals(want, have);
    }

    @Test
    public void countWithSize() {

        Bottle<Drink> bd = new Bottle<>();
        tryFill(bd, new Beer());

        final int have = Bottles.countWith(new Beer(), List.of(bd, bd));
        final int want = 2;

        assertEquals(want, have);
    }

    @Test
    public void countWithTwo() {

        Bottle<Drink> bd = new Bottle<>();
        tryFill(bd, new Beer());

        final int have = Bottles.countWith(new Beer(), List.of(bd, bd, new Bottle<Milk>()));
        final int want = 2;

        assertEquals(want, have);
    }

    @Test
    public void fillOverTest() {

        Bottle<Drink> one = new Bottle<>();
        tryFill(one, new Beer());

        Bottle<Fluid> two = new Bottle<>();

        fillOver(one, two);

        final Beer want = new Beer();

        assertEquals(want, tryConsume(two));
    }

    @Test
    public void fillOverTestBothEmpty() {

        Bottle<Drink> one = new Bottle<>();

        Bottle<Fluid> two = new Bottle<>();

        fillOver(one, two);

        final Beer want = null;

        assertEquals(want, tryConsume(two));
    }

    @Test
    public void fillOverTestSecondFull() {

        Bottle<Drink> one = new Bottle<>();

        Bottle<Fluid> two = new Bottle<>();
        tryFill(two, new Beer());

        fillOver(one, two);

        final Beer want = new Beer();

        assertEquals(want, tryConsume(two));
    }


}
