import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/** Filter, der beim Lesen entschluesselt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class DecryptReader extends FilterReader {
    /** Entschluessler. */
    private final Decrypter decrypter;

    public DecryptReader(Reader out, Decrypter decrypter) {
    }

    // read()
    // read(char[] buffer, int startAt, int numChars)
}
