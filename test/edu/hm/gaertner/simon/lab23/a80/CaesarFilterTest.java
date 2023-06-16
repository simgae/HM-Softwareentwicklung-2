package edu.hm.gaertner.simon.lab23.a80;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
@RunWith(Parameterized.class) public class CaesarFilterTest {
    @Rule public Timeout globalTimeout = Timeout.millis(1_000);

    @Parameters public static Iterable<Object[]> testcases() {
        return Arrays.asList(new Object[][] {
                // clear, secret
                {"", ""},
                {"A", "B"},
                {"Abc01", "Bcd12"},
                {"Zz9", "Aa0"},
        });
    }

    @Parameter public String clear;
    @Parameter(1) public String secret;

    @Test public void testEncrypt() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader(clear);
            writer;
            Writer encrypt = new EncryptWriter(writer, new CaesarCoder(1))) {
            reader.transferTo(encrypt);
        }
        assertEquals(secret, writer.toString());
    }

    @Test public void testDecrypt() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader(secret);
            Reader decrypt = new DecryptReader(reader, new CaesarCoder(1));
            writer) {
            decrypt.transferTo(writer);
        }
        assertEquals(clear, writer.toString());
    }
}
