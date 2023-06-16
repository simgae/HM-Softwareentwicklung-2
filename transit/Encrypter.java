/** Ein Verschluessler.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public interface Encrypter {
    /** {@return Verschluesseltes Zeichen.}
     * @param chr Klartextzeichen.
     */
    int encrypt(int chr);
}
