package edu.hm.cs.rs.se.ss23.a22;

/** Container mit indexierten Elementen, von denen die meisten einen Defaultwert haben.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-23
 * @param <T> Elementtyp
 */
public interface ThinLine<T> {
    /** Gibt einem bestimmten Element einen neuen Wert.
     * Ersetzt den alten Wert.
     * @param index Index.
     * @param value Neuer Wert.
     */
    void replace(int index, T value);

    /** Schiebt am Index ein neues Element ein.
     * Die vorhandenen Elemente ab dem Index machen Platz und ruecken nach hinten.
     * @param index Index.
     * @param value Neuer Wert im Index.
     */
    void insert(int index, T value);

    /** {@return Der Wert des Elementes am Index.}
     * @param index Index.
     */
    T read(int index);

    /** Entfernt das Element am Index.
     * Die nachfolgenden ruecken nach vorne und schliessen die Luecke.
     * @param index Index.
     */
    T delete(int index);

    /** Index des letzten Elementes mit einem anderen als dem Defaultwert.
     * -1, wenn alle Elemente den Defaultwert haben.
     */
    int lastAt();
}
