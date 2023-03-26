package edu.hm.gaertner.simon.lab23.a11;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/** Element in einem int-Array und Anzahl der Vorkommen.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 * @param value Wert des Elementes.
 * @param occurrences Anzahl Vorkommen. Wenigstens 1.
 */
public record MostFrequent(int value, int occurrences) {

    /** Ctor with precondition - check occurrences.
     * @param value of the element
     * @param occurrences of the element
     * @throws IllegalArgumentException when occurrences is less than 1
     */
    public MostFrequent {
        if (occurrences < 1)
            throw new IllegalArgumentException("Occurrences of the new object is less then 1.");
    }

    /** Sucht in einem int-Array nach dem Element, das am oeftesten vorkommt.
     * Wenn es mehrere Kandidaten gibt, gilt der erste.
     * @param array Ein Array.
     * @return Haeufigstes Element. Nicht null.
     * @throws NullPointerException wenn das Array nicht existiert (null ist).
     * @throws NoSuchElementException wenn das Array leer ist.
     */
    public static MostFrequent scan(int... array) {

        // Precondition - check that array is not null
        Objects.requireNonNull(array);

        // Precondition - check that length of array is not 0
        if(array.length == 0)
            throw new NoSuchElementException("Length of transferred Array is 0!");

        MostFrequent mostFrequentSoFar = null;
        for(int currentValue : array) {
            int currentFound = 0;
            for(int comparedValue : array)
                if(comparedValue == currentValue)
                    currentFound++;
            if(mostFrequentSoFar == null || currentFound > mostFrequentSoFar.occurrences())
                mostFrequentSoFar = new MostFrequent(currentValue, currentFound);
        }

        // factored out because of cyclomatic complexity
        postConditionsForScanMethod(mostFrequentSoFar, array.clone());

        return mostFrequentSoFar;
    }

    /**
     * Check the result of scan method.
     * @param mostFrequentSoFar object which should be checked
     * @param array underlying array
     */
    private static void postConditionsForScanMethod(MostFrequent mostFrequentSoFar, int... array){
        // Post-Condition - check that value is part of the array
        boolean isPart = false;
        for (int currentElement : array) {
            if(currentElement == mostFrequentSoFar.value())
                isPart = true;
        }

        assert isPart : "Value of return object is not part of the array!";

        // Post-Conditions - check that occurrence of value is right
        int amount = 0;

        for (int currentElement : array) {
            if(currentElement == mostFrequentSoFar.value())
                amount++;
        }

        assert amount == mostFrequentSoFar.occurrences() : "Calculation of occurrences is wrong!";
    }


    /*
    -------------------------------------------------
                    REWORK TASK
           ** SOLVE SPACE-TIME-TRADEOFF **
    -------------------------------------------------
     */

    /** Sucht in einem int-Array nach dem Element, das am oeftesten vorkommt.
     * Wenn es mehrere Kandidaten gibt, gilt der erste.
     * @param array Ein Array.
     * @return Haeufigstes Element. Nicht null.
     * @throws NullPointerException wenn das Array nicht existiert (null ist).
     * @throws NoSuchElementException wenn das Array leer ist.
     * -----------------------------------
     * Data: [3,2,2,1,1]
     * -----------------------------------
     *         Algorithm:
     *             1. Create a new Array with the following pattern:
     *                 [[3,1]],[[2,2]],[[1,2]]
     *                 2 Dimensions:
     *                     First length of different Elements
     *                     Second [0] = value
     *                     Second [1] = occurrence
     *              2. Go through the new Array and take the value with the highest occurrence
     * -----------------------------------
     */
    public static MostFrequent reworkScan(int... array) {

        // Precondition - check that array is not null
        Objects.requireNonNull(array);

        // Precondition - check that length of array is not 0
        if(array.length == 0)
            throw new NoSuchElementException("Length of transferred Array is 0!");

        // create array for analytics
        final int[][] arrayAnalytics = new int[uniqueLength(array)][2];

        // fill analytics array with -1 to initialization with 0
        // can crash when dataset contains -1 as a value
        for (int index = 0; index < arrayAnalytics.length; index++) {
            arrayAnalytics[index][0] = -1;
        }

        // insert the different values and amounts
        int indexCounter = 0;
        for (int currentValue: array) {
                    if(!isInAnalytics(currentValue, arrayAnalytics)){
                        arrayAnalytics[indexCounter][0] = currentValue;
                        arrayAnalytics[indexCounter][1] = countValue(currentValue, array);
                        indexCounter++;
                    }
        }

        // find the highest amount
        int resultIndex = 0;
        int highestAmount = 0;

        for (int index = 0; index < arrayAnalytics.length; index++) {
            if(arrayAnalytics[index][1] > highestAmount){
                highestAmount = arrayAnalytics[index][1];
                resultIndex = index;
            }
        }

        final MostFrequent mostFrequentSoFar = new MostFrequent(arrayAnalytics[resultIndex][0], arrayAnalytics[resultIndex][1]);

        // factored out because of cyclomatic complexity
        postConditionsForScanMethod(mostFrequentSoFar, array.clone());

        return mostFrequentSoFar;
    }

    /**
     * Count the amount of different elements in the array.
     * @param array data set
     * @return amount of unique values
     */
    private static int uniqueLength(int... array){

        // sort array -> easier to count the unique length
        Arrays.sort(array);

        // counter
        int uniqueLength = 1;

        // length -1 because we compare the current element and the next one
        for (int pointer = 0; pointer < array.length-1; pointer++) {
            if(array[pointer] != array[pointer+1])
                uniqueLength++;
        }

        return uniqueLength;
    }

    /**
     * Check if value is already in the analytics array.
     * @param value which need to be checked
     * @param analytics array
     * @return true -> inside : false -> not inside
     */
    private static boolean isInAnalytics (int value, int[]... analytics){
        boolean result = false;

        for (int index = 0; index < analytics.length && !result; index++) {
            if(value == analytics[index][0])
                result = true;
        }

        return result;
    }

    /**
     * Count the occurrence of the transferred value in the transferred array.
     * @param value which should be count
     * @param array underlying dataset
     * @return amount
     */
    private static int countValue(int value, int... array){
        int amount = 0;

        for (int currentValue : array) {
            if (currentValue == value)
                amount++;
        }

        return amount;
    }

}
