package edu.hm.gaertner.simon.lab23.a12;

import edu.hm.cs.rs.se.ss23.Xmark;

/** Vorgabe.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 */
@Xmark("a12")
public class Zeroes {
    /**
     * Zaehlt, wie viele Werte 0 unter den Zahlen sind.
     *
     * @param numbers Zahlen. Nicht null.
     * @return Wie oft die 0 vorkommt. Nicht negativ.
     */
    public static int count0(int... numbers) {

        int counter = 0;

        for (int value : numbers) {
            try {
                final int result = 1 / value;
            } catch (ArithmeticException exception) {
                counter++;
            }
        }
        return counter;
    }
}
