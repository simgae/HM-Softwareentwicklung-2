package edu.hm.gaertner.simon.lab23.a41;

import static edu.hm.gaertner.simon.lab23.a41.TriElement.*;

public class TriElementDemo {


    /**
     * Main method.
     *
     * @param args - arguments.
     */
    public static void main(String[] args) {

        // Alle Strings gleich (auch null)?
        System.out.println(ALL_EQUAL.test("a", "a", "a")); // true
        System.out.println(ALL_EQUAL.test("a", "a", "X")); // false
        System.out.println(ALL_EQUAL.test("a", null, "a")); // false
        System.out.println(ALL_EQUAL.test(null, null, null)); // true
        System.out.println("-----------------------------------------------------");


        // Zahlen steigen streng monoton?
        System.out.println(STRAIGHT_UP.test(1, 2, 3)); // true
        System.out.println(STRAIGHT_UP.test(3, 2, 1)); // false
        System.out.println(STRAIGHT_UP.test(1, 2, 2)); // false
        System.out.println("-----------------------------------------------------");


        // Genau 1 der Wahrheitswerte true?
        System.out.println(EXACTLY_1.test(1 < 2, 2 < 2, 3 < 2)); // true
        System.out.println(EXACTLY_1.test(1 < 2, 2 == 2, 2 < 3)); // false
        System.out.println(EXACTLY_1.test(1 < 2, 2 < 3, 3 < 4)); // false
        System.out.println(EXACTLY_1.test(false, false, false)); // false
        System.out.println("-----------------------------------------------------");


        // Drei Strings (keiner null) alphabetisch geordnet?
        System.out.println(LEXICAL.test("a", "bbb", "zip")); // true
        System.out.println(LEXICAL.test("bbb", "a", "zip")); // false
        System.out.println(LEXICAL.test("a", "a", "zip")); // true

    }
}
