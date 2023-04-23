package edu.hm.gaertner.simon.lab23.a32;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanTests {

    @Test
    public void testIntToString() {

        final Roman roman = new Roman(9);

        final String want = "IX";

        assertEquals(want, roman.text());
    }

    @Test
    public void test2023() {

        final Roman roman = new Roman(2023);

        final String want = "MMXXIII";

        assertEquals(want, roman.text());
    }


    @Test
    public void testStringToInt() {

        final Roman roman = new Roman("XIX");

        final int want = 19;

        assertEquals(want, roman.number());
    }

    @Test
    public void testStringToIntCashed() {

        final Roman roman = CachedRoman.make("IX");

        final int want = 9;

        assertEquals(want, roman.number());
    }


    @Test
    public void testStringToIntCashedNoCalculation() {

        final Roman roman = CachedRoman.make("XCIX");
        final Roman snd = CachedRoman.make("XCIX");

        final int want = 99;

        assertEquals(want, roman.number());
        assertEquals(want, snd.number());
    }

    @Test
    public void testIntToStringCashed() {

        final Roman roman = CachedRoman.make(9);

        final String want = "IX";

        assertEquals(want, roman.text());
    }

    @Test
    public void testIntToStringCashedNoCalculation() {

        final Roman roman = CachedRoman.make(9);
        final Roman snd = CachedRoman.make(9);

        final String want = "IX";

        assertEquals(want, roman.text());
        assertEquals(want, snd.text());
    }
    @Test
    public void testIntToStringCashedNoCalculationThreeTimes() {

        final Roman roman = CachedRoman.make(9);
        final Roman romanTrd = CachedRoman.make(19);
        final Roman snd = CachedRoman.make(9);

        assertEquals("IX", roman.text());
        assertEquals("IX", snd.text());
        assertEquals("XIX", romanTrd.text());
    }


}
