package edu.hm.gaertner.simon.lab23.a43;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Define different logic functions.
 * @see <a href="https://se.pages.gitlab.lrz.de/2023s/etc/lab/slide0034.html">...</a>
 * CHANGE: XOR ONLY TRUE
 * WHEN T - F -> TRUE
 * AND F - T -> TRUE
 * WHEN T - T -> FALSE
 * AND F - F -> FALSE
 * OTHERWISE MAYBE
 *
 * I THINK HERE IS A MISTAKE IN THE TABLE!
 */
public enum Troolean {

    /**
     * All different logic possibilities.
     */
    FALSE, MAYBE, TRUE;

    /**
     * logic and function.
     */
    public static final BinaryOperator<Troolean> AND = (fst, snd) -> {
        Troolean result;

        final int ordinalSum = fst.ordinal() + snd.ordinal();

        if (ordinalSum == 4)
            result = TRUE;
        else if (fst.ordinal() == 0 || snd.ordinal() == 0)
            result = FALSE;
        else
            result = MAYBE;

        return result;
    };

    /**
     * logic or function.
     */
    public static final BinaryOperator<Troolean> OR = (fst, snd) -> {
        Troolean result;

        if (fst.ordinal() == 2 || snd.ordinal() == 2)
            result = TRUE;
        else if (fst.ordinal() == 1 || snd.ordinal() == 1)
            result = MAYBE;
        else
            result = FALSE;

        return result;
    };

    /**
     * logic xor function.
     */
    public static final BinaryOperator<Troolean> XOR = (fst, snd) -> {
        Troolean result;

        final int ordinalSum = fst.ordinal() + snd.ordinal();

        if (fst.ordinal() == 1 || snd.ordinal() == 1)
            result = MAYBE;
        else if (ordinalSum == 2)
            result = TRUE;
        else
            result = FALSE;

        return result;
    };


    /**
     * logic not function.
     */
    public static final UnaryOperator<Troolean> NOT = (fst) -> {
        Troolean result;
        if (fst.ordinal() == 1)
            result = MAYBE;
        else if (fst.ordinal() == 0)
            result = TRUE;
        else
            result = FALSE;
        return result;
    };
}
