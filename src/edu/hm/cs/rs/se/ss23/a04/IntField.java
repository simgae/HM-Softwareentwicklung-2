package edu.hm.cs.rs.se.ss23.a04;

/** Praktikum SE2, SS2023 (R. Schiedermeier).
 * Vorgabe zur Aufgabe 04.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-17
 */
public interface IntField {
    /** {@return Anzahl Elemente}
     * Nicht negativ.
     */
    int length();

    /** {@return Wert am gegebenen Index.}
     * @param index Index.
     * @throws IndexOutOfBoundsException wenn der Index unzulaessig ist.
     */
    int at(int index);
}
