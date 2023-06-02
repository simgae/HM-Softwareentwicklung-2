package edu.hm.gaertner.simon.lab23.a50.a501;

import java.util.stream.IntStream;

/**
 * Vorgabe zur Aufgabe.
 * Praktikum SE2, SS2023 (Schiedermeier).
 *
 * @version 2023-03-22
 */
public class SubDigits {
    /**
     * Hauptprogramm.
     * Sucht die Dezimaldarstellung einer Zahl in einer anderen.
     * Gibt aus true (gefunden) oder false (nicht gefunden).
     *
     * @param args Kommandozeilenargumente:
     *             1. Durchsuchte Dezimaldarstellung.
     *             2. Gesuchte Dezimaldarstellung.
     */
    public static void main(String... args) {

        if (args.length < 2)
            throw new IllegalArgumentException("Not enough values!");

        final int haystack = Integer.parseInt(args[0]);
        final int needle = Integer.parseInt(args[1]);

        if (haystack < 0 || needle < 0)
            throw new IllegalArgumentException("At least one value is negative!");

        final boolean found = IntStream.range(0, String.valueOf(haystack).length() - String.valueOf(needle).length() + 1)
                .anyMatch(i -> String.valueOf(haystack).startsWith(String.valueOf(needle), i));

        System.out.println(found);
    }
}