/** Caesaer-Verschluesselung.
 * Verarbeitet nur Buchstaben und Ziffern, laesst alles andere unveraendert.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-15
 * @param distance Anzahl Buchstaben Verschiebung.
 *
 */
public record CaesarCoder(int distance) implements Encrypter, Decrypter {
    /** Anzahl Buchstaben im Alphabet. */
    static final int NUM_LETTERS = 26;

    /** Anzahl Ziffern. */
    static final int NUM_DIGITS = 10;

    //static final String WHITESPACE = " \n\t_";
    //static final int NUM_WHITESPACE = WHITESPACE.length();

    @Override public int decrypt(int chr) {
        return shiftChar(chr, -distance);
    }

    @Override public int encrypt(int chr) {
        return shiftChar(chr, distance);
    }

    /** Verschiebt ein Zeichen.
     * @param chr Zeichen.
     * @param by Anzahl Positionen.
     * @return Verschobenes Zeichen oder Original, wenn chr kein Buchstabe und keine Ziffer ist.
     */
    private int shiftChar(int chr, int by) {
        final int result;
        if(Character.isUpperCase(chr))
            result = rest(chr - 'A' + by, NUM_LETTERS) + 'A';
        else if(Character.isLowerCase(chr))
            result = rest(chr - 'a' + by, NUM_LETTERS) + 'a';
        else if(Character.isDigit(chr))
            result = rest(chr - '0' + by, NUM_DIGITS) + '0';
            //else if(WHITESPACE.indexOf(chr) >= 0)
            //    result = WHITESPACE.charAt(mathMod(WHITESPACE.indexOf(chr) + by, NUM_WHITESPACE));
        else
            result = chr;
        return result;
    }

    /** Mathematischer Modulus.
     * @param number Zahl.
     * @param modulus Modulus.
     * @return Rest, immer im Bereich 0...(modulus - 1).
     */
    private static int rest(int number, int modulus) {
        return (number%modulus + modulus)%modulus;
    }
}
