package edu.hm.cs.rs.se.ss23.a06;

/** Feld mit Werten eines Referenztyps.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
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
