package edu.hm.cs.rs.se.ss23.a07;

/** Ein Undercut-Buchhalter.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-17
 */
public interface Booker {
    /** Verbucht neue Augenzahlen.
     * @param her Was der erste Spieler gewaehlt hat.
     * @param his Wahl des anderen Spielers.
     */
    void record(int her, int his);

    /** {@return Bisher angesammelte Augen des einen Spielers.} */
    int her();

    /** {@return Bisher angesammelte Augen des anderen Spielers.} */
    int his();

    /** {@return Momentan gesparte Augen.} */
    int saved();

    /** Loescht alle Augen dieses Buchhalters. */
    void reset();
}
