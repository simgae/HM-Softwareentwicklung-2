package edu.hm.gaertner.simon.lab23.a511;


import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Element in einem int-Array und Anzahl der Vorkommen.
 * Praktikum SE2, SS2023 (Schiedermeier).
 *
 * @param value       Wert des Elementes.
 * @param occurrences Anzahl Vorkommen. Wenigstens 1.
 * @version 2023-03-22
 */
public record MostFrequent(int value, int occurrences) {

    /**
     * Ctor with precondition - check occurrences.
     *
     * @param value       of the element
     * @param occurrences of the element
     * @throws IllegalArgumentException when occurrences is less than 1
     */
    public MostFrequent {
        if (occurrences < 1)
            throw new IllegalArgumentException("Occurrences of the new object is less then 1.");
    }

    /**
     * Sucht in einem int-Array nach dem Element, das am oeftesten vorkommt.
     * Wenn es mehrere Kandidaten gibt, gilt der erste.
     *
     * @param array Ein Array.
     * @return Haeufigstes Element. Nicht null.
     * @throws NullPointerException   wenn das Array nicht existiert (null ist).
     * @throws NoSuchElementException wenn das Array leer ist.
     */
    public static MostFrequent scan(int... array) {

        // Precondition - check that array is not null
        Objects.requireNonNull(array);

        // Precondition - check that length of array is not 0
        if (array.length == 0)
            throw new NoSuchElementException("Length of transferred Array is 0!");

        Function<Integer, Integer> toKey = n -> IntStream.range(0, array.length).boxed().distinct().filter(n::equals).findFirst().get();
        Function<Integer, Integer> toValue = n -> Math.toIntExact(IntStream.range(0, array.length).boxed().filter(s -> array[s] == array[n]).count());


        Map.Entry<Integer, Integer> result = IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(toKey, toValue))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .get();

        return new MostFrequent(array[result.getKey()], result.getValue());
    }

    public static void main(String[] args) {
        System.out.println(scan(1,2,3,4,3,1,2));
    }
}