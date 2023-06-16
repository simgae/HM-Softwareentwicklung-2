import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/** Ver- oder entschluesselt ein Textfile mit Caesar-Verschluesselung in ein zweites Textfile.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class CaesarMain {
    /** Hauptprogramm. Kommandozeilenargumente:
     * 1. Eingabefile (Klartext beim Verschluesseln, Geheimtext beim Entschluesseln).
     * 2. Ausgabefile {Vorsicht, schreibt dieses Programm neu!)
     * 3. "+" zum Verschluesseln oder "-" zum Entschlesseln.
     * 4. Anzahl Positionen Verschiebung (0 = ohne Wirkung).
     */
    public static void main(String... args) throws IOException {
        final String inputFilename = args[0];
        final String outputFilename = args[1];
        final boolean doEncode = args[2].equals("+");
        final int distance = Integer.parseInt(args[3]);
        final CaesarCoder coder = new CaesarCoder(distance);

        if(doEncode)
            ;
        else
            ;
    }
}
