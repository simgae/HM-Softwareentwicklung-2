package edu.hm.gaertner.simon.lab23.a80;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class DecryptReaderTest {
    @Rule public Timeout globalTimeout = Timeout.millis(1_000);

    @Test public void testBlockRead() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader("0123456789");
            Reader decrypt = new DecryptReader(reader, new CaesarCoder(1));
            writer) {
            char[] buffer = new char[6];
            assertEquals(6, decrypt.read(buffer));
            assertArrayEquals("901234".toCharArray(), buffer);
            assertEquals(4, decrypt.read(buffer));
            assertEquals('5', buffer[0]);
            assertEquals('3', buffer[4]);
            assertEquals(-1, decrypt.read(buffer));
        }
    }

    @Test public void testBlockRead0() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader("0123456789");
            Reader decrypt = new DecryptReader(reader, new CaesarCoder(1));
            writer) {
            char[] buffer = new char[6];
            assertEquals(0, decrypt.read(buffer, 0, 0));
        }
    }

    @Test public void testBlockRead1() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader("0123456789");
            Reader decrypt = new DecryptReader(reader, new CaesarCoder(1));
            writer) {
            char[] buffer = new char[6];
            assertEquals(1, decrypt.read(buffer, 5, 1));
            assertEquals('9', buffer[5]);
            assertEquals(1, decrypt.read(buffer, 5, 1));
            assertEquals('0', buffer[5]);
        }
    }

    @Test public void testBlockReadPartial() throws IOException {
        Writer writer = new StringWriter();
        try(Reader reader = new StringReader("0123456789");
            Reader decrypt = new DecryptReader(reader, new CaesarCoder(1));
            writer) {
            char[] buffer = new char[11];
            assertEquals(10, decrypt.read(buffer));
            assertEquals(0, buffer[10]);
            assertEquals(-1, decrypt.read(buffer));
        }
    }
}
