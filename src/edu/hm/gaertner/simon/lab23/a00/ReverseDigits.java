package edu.hm.gaertner.simon.lab23.a00;

import edu.hm.cs.rs.se.ss23.Xmark;

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
        int theNumber = Integer.parseInt(args[0]);
        int reversed = 0;
        while(theNumber > 0) {
            reversed = 10*reversed + theNumber%10;
            theNumber /= 10;
        }
        System.out.println(reversed);
    }
}
