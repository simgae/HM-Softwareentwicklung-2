package edu.hm.gaertner.simon.lab23.a32;

import edu.hm.cs.rs.se.ss23.a32.Roman;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class RomanTests {

    @Test (timeout = 4000)
    public void testStringToIntCashedNoCalculation() {

        final Roman roman = CachedRoman.make("XCIX");
        final Roman snd = CachedRoman.make("XCIX");

        final int want = 99;

        assertEquals(want, roman.number());
        assertEquals(want, snd.number());
    }

    @Test (timeout = 4000)
    public void testIntToStringCashedNoCalculation() {

        final Roman roman = CachedRoman.make(9);
        final Roman snd = CachedRoman.make(9);

        final String want = "IX";

        assertEquals(want, roman.text());
        assertEquals(want, snd.text());
    }
    @Test (timeout = 7000)
    public void testIntToStringCashedCalculation() {

        final Roman roman = CachedRoman.make(12);
        final Roman snd = CachedRoman.make(13);

        assertEquals("XII", roman.text());
        assertEquals("XIII", snd.text());
    }

    @Test (timeout = 7000)
    public void testStringToIntCashedCalculation() {

        final Roman roman = CachedRoman.make("XI");
        final Roman snd = CachedRoman.make("X");


        assertEquals(11, roman.number());
        assertEquals(10, snd.number());
    }


}
