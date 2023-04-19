package edu.hm.cs.rs.se.ss23.a13;

/** Eine Dialogschnittstelle, die Eingaben liefert und Ausgaben annimmt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-25
 */
public interface IO {
    /** {@return Eine weitere Eingabezeile.}
     * @param prompt Prompt, das anzeigt, dass die Methode eine Eingabe erwartet.
     */
    String read(String prompt);

    /** Ausgabe eines Textes.
     * @param text Auszugebener Text.
     */
    void write(String text);
}
