package edu.hm.gaertner.simon.lab23.a44;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ListOpsTest {

    @Test (expected = RuntimeException.class)
    public void checkGetter(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1,2,3,4));
        sut.elements();
    }

    @Test
    public void fold1(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1,2,3,4,5));

        assertEquals(Optional.of(15),Optional.of(sut.fold(0, (x, y) -> x + y)));
    }

    @Test
    public void fold2(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1,2,3,4,5));

        assertEquals(Optional.of(120),Optional.of(sut.fold(1, (x, y) -> x * y)));
    }

    @Test
    public void fold3(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1,2,3,4,5));

        assertEquals(Optional.of(5),Optional.of(sut.fold(4, (x, y) -> x * y)));
    }

    @Test
    public void fold4(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1,2,3,4,5));

        assertEquals(Optional.of(20),Optional.of(sut.fold(3, (x, y) -> x * y)));
    }


    @Test
    public void spread1(){
        final ListOps<String> sut = new ListOps<>(List.of("Abra", "ka", "dabra"));

        assertEquals(new ListOps<>(List.of("A", "bra", "k", "a", "d", "abra")) ,sut.spread(x -> List.of(x.substring(0, 1), x.substring(1))));
    }

    @Test
    public void moved1(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(new ListOps<>(List.of(6, 5, 4, 3, 2, 1)) ,sut.moved((length, index) -> length - 1 - index));
    }

    @Test
    public void are1(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertTrue(sut.are(Which.ALL, x -> x > 0));
    }

    @Test
    public void are2(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertFalse(sut.are(Which.NONE, x -> x == 5));
    }

    @Test
    public void are3(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertTrue(sut.are(Which.SOME, x -> x == 5));
    }

    @Test
    public void are4(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertTrue(sut.are(Which.NONE, x -> x == 11));
    }

    @Test
    public void are5(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertFalse(sut.are(Which.SOME, x -> x == 11));
    }

    @Test
    public void are6(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertFalse(sut.are(Which.ALL, x -> x < 0));
    }

    @Test
    public void are7(){
        final ListOps<Integer> sut = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertFalse(sut.are(Which.NONE, x -> x > 0));
    }
}
