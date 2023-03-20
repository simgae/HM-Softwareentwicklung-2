package edu.hm.cs.rs.se.ss23.a04;

/** Praktikum SE2, SS2023 (R. Schiedermeier).
 * Vorgabe zur Aufgabe 04.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-17
 */
@FunctionalInterface public interface IntAt {
    /** {@return Rechnet aus einem Index einen neuen Wert aus.}
     * @param index Operand.
     */
    int value(int index);
}
