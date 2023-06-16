package edu.hm.gaertner.simon.lab23.a80;

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
        super(out);
        this.decrypter = decrypter;
    }

    @Override
    public int read() throws IOException {
        return decrypter.decrypt(super.read());
    }

    @Override
    public int read(char[] buffer, int startAt, int numChars) throws IOException {

        final int result = super.read(buffer, startAt, numChars);

        if (result > 0){
            for (int i = startAt; i < startAt + result; i++) {
                buffer[i] = (char)decrypter.decrypt(buffer[i]);
            }
        }

        return result;
    }

}
