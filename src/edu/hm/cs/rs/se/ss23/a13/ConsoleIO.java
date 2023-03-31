package edu.hm.cs.rs.se.ss23.a13;

import java.io.Console;
import java.util.Scanner;

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

    /**
     * Changed because origin version leads to NullPointerException.
     * Changed to a Scanner object.
     * Changed by Simon Gaertner.
     * @param prompt Prompt, das anzeigt, dass die Methode eine Eingabe erwartet.
     * @return input string from console
     */
    @Override public String read(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Input > ");
        return myScanner.nextLine();
    }

    @Override public void write(String text) {
        System.out.println(text);
    }
}
