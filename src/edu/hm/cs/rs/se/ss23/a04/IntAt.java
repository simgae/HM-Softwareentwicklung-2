package edu.hm.cs.rs.se.ss23.a04;

/** Interface fuer Funktionen, die den Wert an einem Index berechnen.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 */
@FunctionalInterface public interface IntAt {
    /** {@return Wert des Elementes am gegebenen Index.}
     * @param index Index. Nicht negativ.
     */
    int value(int index);
}
