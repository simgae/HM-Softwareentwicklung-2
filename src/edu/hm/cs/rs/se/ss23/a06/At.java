package edu.hm.cs.rs.se.ss23.a06;

/** Praktikum SE2, SS2023 (R. Schiedermeier).
 * Vorgabe zur Aufgabe 04.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-17
 * @param <T> Elementtyp.
 */
@FunctionalInterface public interface At<T> {
    /** {@return Wert des Elementes am gegebenen Index.}
     * @param index Index. Nicht negativ.
     */
    T value(int index);
}
