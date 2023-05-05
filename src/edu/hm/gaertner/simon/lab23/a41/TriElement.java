package edu.hm.gaertner.simon.lab23.a41;

import java.util.Objects;

/**
 * Check three parameters for a condition.
 * Demo-File:
 * @see edu/hm/gaertner/simon/lab23/demo/TriElementDemo.java
 */
public class TriElement {

    /*
    Make lambda expressions public and static to test them with junit.
     */

    /**
     * Check if all three Strings are equal.
     */
    public static final TriPredicate<String> ALL_EQUAL = (fst, snd, trd) -> Objects.isNull(fst) && Objects.isNull(snd) && Objects.isNull(trd) || !Objects.isNull(fst) && fst.equals(snd) && snd.equals(trd);

    /**
     * Check if the ints are in one row.
     */
    public static final TriPredicate<Integer> STRAIGHT_UP = (fst, snd, trd) -> fst < snd && snd < trd;

    /**
     * Check if exactly one boolean condition is true.
     */
    public static final TriPredicate<Boolean> EXACTLY_1 = (fst, snd, trd) -> fst && !snd && !trd || !fst && snd && !trd || !fst && !snd && trd;

    /**
     * Check if the string are in lexical order.
     */
    public static final TriPredicate<String> LEXICAL = (fst, snd, trd) -> fst.compareTo(snd) <= 0 && snd.compareTo(trd) <= 0;


}
