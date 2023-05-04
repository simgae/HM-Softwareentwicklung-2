package edu.hm.gaertner.simon.lab23.a41;

import java.util.Objects;

/**
 *  Check three parameters for a condition.
 */
public class TriElementTester{

    /**
     * Main method.
     * @param args - arguments.
     */
    public static void main(String[] args) {

            // Alle Strings gleich (auch null)?
            final TriPredicate<String> allEqual = (fst, snd, trd) -> Objects.isNull(fst) && Objects.isNull(snd) && Objects.isNull(trd) || fst.equals(snd) && snd.equals(trd);
            System.out.println(allEqual.test("a", "a", "a")); // true
            System.out.println(allEqual.test("a", "a", "X")); // false
            System.out.println(allEqual.test("a", null, "a")); // false
            System.out.println(allEqual.test(null, null, null)); // true
            System.out.println("-----------------------------------------------------");


            // Zahlen steigen streng monoton?
            final TriPredicate<Integer> straightUp = (fst, snd, trd) -> fst < snd && snd < trd;
            System.out.println(straightUp.test(1, 2, 3)); // true
            System.out.println(straightUp.test(3, 2, 1)); // false
            System.out.println(straightUp.test(1, 2, 2)); // false
            System.out.println("-----------------------------------------------------");


            // Genau 1 der Wahrheitswerte true?
            final TriPredicate<Boolean> exactly1 = (fst, snd, trd) -> fst && !snd && !trd || !fst && snd && !trd || !fst && !snd && trd;
            System.out.println(exactly1.test(1 < 2, 2 < 2, 3 < 2)); // true
            System.out.println(exactly1.test(1 < 2, 2 == 2, 2 < 3)); // false
            System.out.println(exactly1.test(1 < 2, 2 < 3, 3 < 4)); // false
            System.out.println(exactly1.test(false, false, false)); // false
            System.out.println("-----------------------------------------------------");


            // Drei Strings (keiner null) alphabetisch geordnet?
            final TriPredicate<String> lexical = (fst, snd, trd) -> fst.compareTo(snd) <= 0 && snd.compareTo(trd) <= 0;
            System.out.println(lexical.test("a", "bbb", "zip")); // true
            System.out.println(lexical.test("bbb", "a", "zip")); // false
            System.out.println(lexical.test("a", "a", "zip")); // true

    }

}
