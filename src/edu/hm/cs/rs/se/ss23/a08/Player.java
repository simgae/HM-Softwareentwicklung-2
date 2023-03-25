package edu.hm.cs.rs.se.ss23.a08;

/** Ein Undercut-Spieler.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 */
public interface Player {
    /** Welche Augenzahl der Spieler in diesem Zug nach oben dreht.
     * Zwischen 1 und der Anzahl Seiten des Wuerfels.
     */
    int choose();

    /** Informiert den Spieler ueber den letzten Zug.
     * @param you Die eigene Augenzahl, wie zuletzt mit choose geliefert.
     * @param opponent Die Wahl des Gegners.
     */
    default void tell(int you, int opponent) {}
}
