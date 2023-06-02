package edu.hm.gaertner.simon.lab23.a511;

import edu.hm.gaertner.simon.lab23.a50.a511.MostFrequent;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/** Tests.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 */
public class MostFrequentTest {

    @Test public void only1Element() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 1);
        final int[] array = {1};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void distinctElements() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 1);
        final int[] array = {1, 2, 3};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void firstWins() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {1, 1, 2, 2};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerAtFront() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {1, 1, 2};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerAtEnd() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {2, 1, 1};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerInside() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {2, 1, 1, 3};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void array1k() {
        // arrange
        final int zeroes = 1_000;
        final MostFrequent want = new MostFrequent(0, zeroes);
        final int[] array = new int[zeroes];

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test(expected = IllegalArgumentException.class) public void newObjectWithOccurrenceLessThan1(){
        final MostFrequent have = new MostFrequent(0, 0);
    }

    @Test(expected = NullPointerException.class) public void scanWithNullArray(){
        final MostFrequent have = MostFrequent.scan(null);
    }

    @Test(expected = NoSuchElementException.class) public void scanWithArrayLength0(){
        final int[] array = new int[0];
        final MostFrequent have = MostFrequent.scan(array);
    }

    /*
    Tests works - you have to change access parameter of method from private to public
    Commented out because, ToolRunner can not activate asserts! -> This also leads to
    survived PIT mutation in the method postConditionsForScanMethod()!

    @Test(expected = AssertionError.class) public void checkPostConditionsWrongValue(){
        final int[] array = {1};
        final MostFrequent mostFrequentSoFar = new MostFrequent(0, 1);
        MostFrequent.postConditionsForScanMethod(mostFrequentSoFar, array);
    }

    @Test(expected = AssertionError.class) public void checkPostConditionsWrongOccurrence(){
        final int[] array = {0};
        final MostFrequent mostFrequentSoFar = new MostFrequent(0, 2);
        MostFrequent.postConditionsForScanMethod(mostFrequentSoFar, array);
    }
    */
}
