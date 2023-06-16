package edu.hm.gaertner.simon.lab23.a80;

/** Ein Entschluessler.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public interface Decrypter {
    /** {@return Klartextzeichen.}
     * @param chr Verschluesseltes Zeichen.
     */
    int decrypt(int chr);
}
