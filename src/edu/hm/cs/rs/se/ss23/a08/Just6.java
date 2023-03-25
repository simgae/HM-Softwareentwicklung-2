package edu.hm.cs.rs.se.ss23.a08;

/** Ein Undercut-Spieler, der immer die 6 nimmt.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 */
public class Just6 implements Player {
    @Override public int choose() {
        return 6;
    }
}
