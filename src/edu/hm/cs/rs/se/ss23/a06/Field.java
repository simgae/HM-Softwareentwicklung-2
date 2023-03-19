package edu.hm.cs.rs.se.ss23.a06;

/** Praktikum SE2, SS2023 (R. Schiedermeier).
 * Vorgabe zur Aufgabe 06.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-17
 * @param <T> Elementtyp.
 */
public interface Field<T> {
    /** {@return Anzahl Elemente.}
     * Nicht negativ.
     */
    int length();

    /** {@return Wert am gegebenen Index.}
     * @param index Index.
     * @throws IndexOutOfBoundsException wenn der Index unzulaessig ist.
     */
    T at(int index);
}
