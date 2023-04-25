package edu.hm.gaertner.simon.lab23.a33;


import edu.hm.cs.rs.se.ss23.a32.Roman;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class OrderedRomanTest {

    @Test
    public void testEqual(){
        OrderedRoman one = new OrderedRoman(1);
        OrderedRoman onceMore = new OrderedRoman(1);

        assertEquals(one, onceMore);
    }

    @Test
    public void testSizeAndEquals(){
        OrderedRoman one = new OrderedRoman(1);

        Set<OrderedRoman> tsor = new TreeSet<>();
        for (int n = 10; n > 1; n--)
            tsor.add(new OrderedRoman(n / 2));

        final int want = 5;

        assertEquals(want, tsor.size());
        assertEquals(tsor.iterator().next(), one);
    }

    @Test
    public void testNormalSorting(){
        Set<OrderedRoman> tsr = new TreeSet<>();
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        tsr.add(new OrderedRoman(1));

        final Iterator<OrderedRoman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals("I", have.text());
    }

    @Test
    public void testNormalsSortingWithList(){
        List<OrderedRoman> tsr = new ArrayList<>();
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        tsr.add(new OrderedRoman(1));

        tsr.sort(OrderedRoman::compareTo);

        final Iterator<OrderedRoman> iterator = tsr.iterator();

        Roman have = iterator.next();

        assertEquals("I", have.text());


        have = iterator.next();

        assertEquals("I", have.text());
    }

    @Test
    public void testNormalSortingSecond(){
        Set<OrderedRoman> tsr = new TreeSet<>();
        for (int n = 1; n <= 10; n++)
            tsr.add(new OrderedRoman(n));

        final Iterator<OrderedRoman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals("I", have.text());
    }

    @Test
    public void testSortLexical(){
        Set<Roman> tsr = new TreeSet<>(new RomanLexicalOrder());
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        final Iterator<Roman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals(have.text(), "I");
    }

    @Test
    public void testSortLexicalSndElement(){
        Set<Roman> tsr = new TreeSet<>(new RomanLexicalOrder());
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        final Iterator<Roman> iterator = tsr.iterator();

        Roman have = iterator.next();
        have = iterator.next();

        assertEquals(have.text(), "II");
    }

    @Test
    public void testSortLexicalBackwards(){
        Set<Roman> tsr = new TreeSet<>(new RomanLexicalOrder());
        for (int n = 1; n <= 10; n++)
            tsr.add(new OrderedRoman(n));

        final Iterator<Roman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals(have.text(), "I");
    }


    @Test
    public void testSortLength(){
        Set<Roman> tsr = new TreeSet<>(new RomanTextLengthOrder());
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        final Iterator<Roman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals(have.text(), "X");
    }

    @Test
    public void testSortFactors(){
        Set<Roman> tsr = new TreeSet<>(new RomanByFactors());
        for (int n = 10; n > 1; n--)
            tsr.add(new OrderedRoman(n));

        final Iterator<Roman> iterator = tsr.iterator();

        final Roman have = iterator.next();

        assertEquals(have.text(), "II");
    }

    @Test
    public void testLexicalSortingWithList(){
        List<OrderedRoman> tsr = new ArrayList<>();
        for (int n = 1; n <= 10; n++)
            tsr.add(new OrderedRoman(n));

        tsr.add(new OrderedRoman(1));

        Comparator<? super OrderedRoman> RomanLexicalOrder = new RomanLexicalOrder();
        tsr.sort(RomanLexicalOrder);

        final Iterator<OrderedRoman> iterator = tsr.iterator();

        Roman have = iterator.next();

        assertEquals("I", have.text());


        have = iterator.next();

        assertEquals("I", have.text());

        have = iterator.next();

        assertEquals("II", have.text());
    }

    @Test
    public void testLengthSortingWithList(){
        List<OrderedRoman> tsr = new ArrayList<>();
        for (int n = 10; n >= 1; n--)
            tsr.add(new OrderedRoman(n));

        tsr.add(new OrderedRoman(1));

        Comparator<? super OrderedRoman> RomanTextLengthOrder = new RomanTextLengthOrder();
        tsr.sort(RomanTextLengthOrder);

        final Iterator<OrderedRoman> iterator = tsr.iterator();

        Roman have = iterator.next();

        assertEquals("X", have.text());
        assertEquals(11, tsr.size());
    }

}
