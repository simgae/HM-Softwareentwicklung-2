package edu.hm.gaertner.simon.lab23.a31;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MonoSetTests {

    @Test
    public void sizeZero() {

        final MonoSet<Integer> set = new MonoSet<>();

        final int want = 0;

        assertEquals(set.size(), want);
    }

    @Test
    public void sizeOne() {

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(1);

        final int want = 1;

        assertEquals(set.size(), want);
    }

    @Test
    public void addOnes() {

        final MonoSet<Integer> set = new MonoSet<>();

        assertTrue(set.add(1));
    }

    @Test
    public void addTwo() {

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(2);

        assertFalse(set.add(1));
    }

    @Test
    public void removeFalse(){

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(2);

        assertFalse(set.remove(1));
    }

    @Test
    public void removeTrue(){

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(2);

        assertTrue(set.remove(2));
    }

    @Test
    public void removeEmpty(){

        final MonoSet<Integer> set = new MonoSet<>();


        assertFalse(set.remove(2));
    }

    @Test
    public void removeAndRead(){

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(2);
        set.remove(2);

        Integer content = null;

        for (Integer value : set) {
            content = value;
        }

        assertNull(content);
    }

    @Test
    public void iterate(){

        final MonoSet<Integer> set = new MonoSet<>();

        set.add(2);

        int content = 0;

        for (Integer value : set) {
            content = value;
        }

        assertEquals(content, 2);
    }

    ////////////////////////// TESTS - FREDERIC KAYSER //////////////////////////

    @Test()
    public void testSizeEmptySet() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        final int want = 0;
        final int have = monoSet.size();

        assertEquals(want, have);
    }

    @Test()
    public void testAddElement() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        final boolean have = monoSet.add(1);

        assertTrue(have);
    }

    @Test()
    public void testAddTwoElements() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        monoSet.add(2);
        final boolean have = monoSet.add(1);

        assertFalse(have);
    }

    @Test()
    public void testSizeNotEmpty() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        monoSet.add(1);

        final int want = 1;
        final int have = monoSet.size();

        assertEquals(want, have);
    }

    @Test()
    public void testIteratorEmptySet() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        Iterator<Integer> iterator = monoSet.iterator();

        assertNull(iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test()
    public void testIteratorFilledSet() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        monoSet.add(1);

        Iterator<Integer> iterator = monoSet.iterator();

        final int want = 1;
        final int have = iterator.next();

        assertEquals(want, have);
        assertFalse(iterator.hasNext());
    }

    @Test()
    public void testRemoveElement() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        monoSet.add(1);
        monoSet.remove(1);
        monoSet.add(2);

        final int want = 2;
        final int have = monoSet.iterator().next();

        assertEquals(want, have);
    }

    @Test()
    public void testHasNext() {
        final MonoSet<Integer> monoSet = new MonoSet<>();

        assertFalse(monoSet.iterator().hasNext());
    }


}
