package edu.hm.gaertner.simon.lab23.a50.a500;

import java.util.Collections;

/** Praktikum SE2, SS2023 (Schiedermeier).
 * Loesung zur Probeaufgabe.
 * @version 2023-03-18
 */
public class ReverseDigits {
    /** Hauptprogramm.
     * Gibt eine Zahl in umgedrehter Dezimalschreibweise aus.
     * @param args Kommandozeilenargument: Nicht negative ganze Zahl.
     */
    public static void main(String... args) {
        final int theNumber = Integer.parseInt(args[0]);


        String.valueOf(theNumber).chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(n -> (char) (n + '0' - '0'))
                .forEach(System.out::print);

    }
}
