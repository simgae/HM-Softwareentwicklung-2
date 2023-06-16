package edu.hm.gaertner.simon.lab23.a80;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/** Filter, der beim Schreiben verschluesselt.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class EncryptWriter extends FilterWriter {
    /** Verschluessler. */

    private final Encrypter encrypter;

    public EncryptWriter(Writer out, Encrypter encrypter) {
        super(out);
        this.encrypter = encrypter;

    }

    @Override
    public void write(int chr) throws IOException {
        super.write(encrypter.encrypt(chr));
    }

    @Override
    public void write(char[] buffer, int startAt, int numChars) throws IOException {

        for (int cursor = startAt; cursor < startAt + numChars; cursor++) {
            write(buffer[cursor]);
        }
    }


}
