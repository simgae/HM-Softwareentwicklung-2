package edu.hm.cs.rs.se.ss23.a08;

/** Ein Undercut-Spieler, der immer 5 waehlt.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-25
 */
public class Only5 implements Player {
    @Override public int choose() {
        return 5;
    }

}
