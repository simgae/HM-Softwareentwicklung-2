import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/** Filter, der beim Schreiben verschluesselt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class EncryptWriter extends FilterWriter {
    /** Verschluessler. */
    private final Encrypter encrypter;

    public EncryptWriter(Writer out, Encrypter encrypter) {
    }

    // write(int chr)
    // write(char[] buffer, int startAt, int numChars)
}
