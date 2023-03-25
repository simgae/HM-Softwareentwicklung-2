package edu.hm.cs.rs.se.ss23.a13;

import java.io.Console;

/** Dialog ueber das Terminal.
 * Liest Eingaben von der Tastatur und zeigt Ausgaben auf dem Bildschirm.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 * @param console Vermittelt zwischen Terminal und Programm.
 */
public record ConsoleIO(Console console) implements IO {
    public ConsoleIO() {
        this(System.console());
    }

    @Override public String read(String prompt) {
        return console().readLine(prompt);
    }

    @Override public void write(String text) {
        System.out.println(text);
    }
}
