package edu.hm.gaertner.simon.lab23.a02;

import edu.hm.cs.rs.se.ss23.Xmark;

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
    public static void main(String string) {

        Objects.requireNonNull(string);
        if(string.isEmpty())
            throw new IllegalArgumentException("Empty string is forbidden!");

        // copy string for calculation
        String text = string;

        // pointer to last line break
        int lastLineBreak = text.length()-1;

        while (text.lastIndexOf('\n') != -1) {

            // get line string
            String line = text.substring(text.lastIndexOf('\n'), lastLineBreak);

            // check if line is not empty
            if(!line.isEmpty())

                // remove line breaks
                System.out.println(line.replace("\n", ""));

            // set pointer
            lastLineBreak = text.lastIndexOf('\n');

            // override text
            text = text.substring(0, lastLineBreak);
        }

        // print last line
        System.out.print(text);
    }
}
