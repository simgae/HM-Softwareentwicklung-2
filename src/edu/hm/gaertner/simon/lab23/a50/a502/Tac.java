package edu.hm.gaertner.simon.lab23.a50.a502;

import java.util.Objects;


/**
 * Tac class.
 * Main method gets a string with multiple lines and print it reversed.
 * Start
 * Middle
 * End
 * ----
 * End
 * Middle
 * Start
 */

public class Tac {

    public static void main(String args) {

        Objects.requireNonNull(args);
        if(args.isEmpty())
            throw new IllegalArgumentException("Empty string is forbidden!");

        args.lines()
                .sorted((s1, s2) -> -1)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        Tac.main("""
                 Anfang
                 Mitte
                 Ende
                 """);
    }
}
