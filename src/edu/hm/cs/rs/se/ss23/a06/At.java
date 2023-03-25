package edu.hm.cs.rs.se.ss23.a06;

/** Berechnet den Wert eines Feldelementes auf dem Index.=
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 * @param <T> Elementtyp.
 */
@FunctionalInterface public interface At<T> {
    /** {@return Wert des Elementes am gegebenen Index.}
     * @param index Index. Nicht negativ.
     */
    T value(int index);
}
