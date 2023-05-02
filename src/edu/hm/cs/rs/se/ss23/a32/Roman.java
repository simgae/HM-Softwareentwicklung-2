package edu.hm.cs.rs.se.ss23.a32;

import java.util.List;

/** Eine roemische Zahl.
 * Der Ctor ist kuenstlich gebremst.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-04-08
 */
public class Roman {
    /** Ein roemisches Zahlenzeichen.
     * @param written Textschreibweise.
     * @param value Rechenwert.
     */
    private record Literal(String written, int value) {
        /** {@return Test ob dieses Zahlenzeichen nur einmal vorkommen darf.}
         */
        boolean subtractive() {
            return written.length() > 1;
        }
    }

    /** Liste der Zahlenzeichen und ihrer Werte nach fallenden Werten. */
    private static final List<Literal> literals = List.of(new Literal("M", 1_000),
                                                          new Literal("CM", 900),
                                                          new Literal("D", 500),
                                                          new Literal("CD", 400),
                                                          new Literal("C", 100),
                                                          new Literal("XC", 90),
                                                          new Literal("L", 50),
                                                          new Literal("XL", 40),
                                                          new Literal("X", 10),
                                                          new Literal("IX", 9),
                                                          new Literal("V", 5),
                                                          new Literal("IV", 4),
                                                          new Literal("I", 1));

    /** Rechenwert dieser roemischen Zahl. Wenigstens 1. */
    private int number;

    /** Textschreibweise dieser roemischen Zahl. Nicht null und syntaktisch korrekt. */
    private String text;

    /** Verzoegerung beim Erzeugen neuer Objekte. */ {
        final int delayMillis = Integer.parseInt(System.getProperty("delay", "0"));
        try {
            Thread.sleep(delayMillis);
        } catch(InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }

    /** Roemische Zahl mit dem gegebenen Wert.
     * @param number Zahlenwert. Wenigstens 1.
     */
    public Roman(int number) {
        if(number < 1)
            throw new IllegalArgumentException("at least 1 required, got " + number);
        this.number = number;
        text = "";
        int rest = number;
        for(Literal literal : literals)
            while(rest >= literal.value()) {
                rest -= literal.value();
                text += literal.written();
            }
        assert !text.isEmpty();
    }

    /** Roemische Zahl mit dem gegebenen Schreibweise..
     * @param number Textdarstellung. Nicht null und synatktisch korrekt.
     * @throws IllegalArgumentException wenn ein Substring kein Zahlenzeichen ist..
     * @throws IllegalArgumentException wenn ein subtraktives Zahlenzeichen mehrmals vorkommt.
     * @throws IllegalArgumentException wenn die Werte der Zahlenzeichen nicht monoton fallen.
     */
    public Roman(String text) {
        this.text = text;
        String rest = text;
        number = 0;
        for(Literal literal : literals) {
            int repeats = 0;
            while(rest.startsWith(literal.written())) {
                repeats++;
                if(repeats > 3)
                    throw new IllegalArgumentException("too many repeats: " + rest);
                else if(repeats > 1 && literal.subtractive())
                    throw new IllegalArgumentException("subtractive literal must not repeat: " + rest);
                number += literal.value();
                rest = rest.substring(literal.written().length());
            }
        }
        if(!rest.isEmpty())
            throw new IllegalArgumentException("not a valid roman literal: " + rest);
        assert number > 1;
    }

    public final int number() {
        return number;
    }

    public final String text() {
        return text;
    }

}
