package edu.hm.cs.rs.se.ss23.a04;

/** Interface fuer Felder mit int-Elementen.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
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
