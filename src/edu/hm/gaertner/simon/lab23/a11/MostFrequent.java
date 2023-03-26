package edu.hm.gaertner.simon.lab23.a11;

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
}
