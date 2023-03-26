package edu.hm.gaertner.simon.lab23.a12;

import org.junit.Test;

import static edu.hm.gaertner.simon.lab23.a12.Zeroes.count0;
import static org.junit.Assert.assertEquals;

public class ZeroesTest {
    @Test public void sevenZeroes(){
        final int[] array = {0, 0, 1, 0, 0, 0, 1, 0, 1, 0};

        final int have = count0(array);
        final int want = 7;

        assertEquals(want, have);
    }

    @Test public void noZeroes(){
        final int[] array = {1};

        final int have = count0(array);
        final int want = 0;

        assertEquals(want, have);
    }

}
