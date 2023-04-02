package edu.hm.cs.rs.se.ss23.a13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/** Dialog ueber das Terminal.
 * Liest Eingaben von der Tastatur und zeigt Ausgaben auf dem Bildschirm.
 * Funktioniert im Run-Environment von IntelliJ/Idea.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-04-02
 * @param bufferedReader Zeilenpuffer fuer System.in.
 */
public record SystemIO(BufferedReader bufferedReader) implements IO {
    public SystemIO() {
        this(new BufferedReader((new InputStreamReader(System.in))));
        System.setOut(new PrintStream(System.out, true));
    }

    @Override public String read(String prompt) {
        System.out.print(prompt);
        try {
            return bufferedReader.readLine();
        } catch(IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    @Override public void write(String text) {
        System.out.println(text);
    }
}
