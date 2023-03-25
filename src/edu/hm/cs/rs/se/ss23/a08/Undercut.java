package edu.hm.cs.rs.se.ss23.a08;

import edu.hm.cs.rs.se.ss23.a07.Booker;

/** Moderator des Spieles Undercut.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 */
public class Undercut {
    /** Wie viele Augen ein Spieler braucht, damit das Spiel endet. */
    public static final int WIN_SCORE = 100;

    /** Nach wie vielen Runden das Spiel in jedem Fall endet. */
    public static final int KILL_ROUNDS = 25;

    /** Wie viele Seiten der Wuerfel hat. */
    public static final int MAX_ROLL = 6;

    /** Ein Buchhalter. */
    private final Booker booker;

    public Undercut(Booker booker) {this.booker = booker;}

    /** Wickelt ein Spiel ab.
     * @param she Ein Spieler.
     * @param he Der Gegner.
     * @return Gewinner (she oder he) oder null bei einem Unentschieden.
     */
    public Player run(Player she, Player he) {
        booker.reset();
        int rounds = 0;
        while(booker.her() < WIN_SCORE && booker.his() < WIN_SCORE && rounds++ < KILL_ROUNDS) {
            final int herChoice = she.choose();
            final int hisChoice = he.choose();
            booker.record(herChoice, hisChoice);
            she.tell(herChoice, hisChoice);
            he.tell(hisChoice, herChoice);
        }
        return booker.her() > booker.his()? she:
                booker.his() > booker.her()? he:
                        null;
    }
}
