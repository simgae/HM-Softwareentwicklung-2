package edu.hm.gaertner.simon.lab23.a80;

import java.io.*;

/**
 * Ver- oder entschluesselt ein Textfile mit Caesar-Verschluesselung in ein zweites Textfile.
 *
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public class CaesarMain {
    /**
     * Hauptprogramm. Kommandozeilenargumente:
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

        if (doEncode)
            try (Reader reader = new FileReader(inputFilename);
                 Writer writer = new FileWriter(outputFilename);
                 Writer encryptWrite = new EncryptWriter(writer, coder)
            ) {
                reader.transferTo(encryptWrite);
            }
        else{
            try (Reader reader = new FileReader(inputFilename);
                 Writer writer = new FileWriter(outputFilename);
                 Reader decrypt = new DecryptReader(reader, coder)
            ) {
                decrypt.transferTo(writer);
            }
        }

    }
}
