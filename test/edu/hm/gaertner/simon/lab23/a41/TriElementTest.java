package edu.hm.gaertner.simon.lab23.a41;

import org.junit.Test;

import static edu.hm.gaertner.simon.lab23.a41.TriElement.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriElementTest {

    @Test
    public void checkEqual(){
        assertTrue(ALL_EQUAL.test("a", "a", "a"));
    }
    @Test
    public void checkEqualFalseThr(){
        assertFalse(ALL_EQUAL.test("X", "a", "a"));
    }
    @Test
    public void checkEqualFalseFst(){
        assertFalse(ALL_EQUAL.test("a", "X", "a"));
    }
    @Test
    public void checkEqualFalse(){
        assertFalse(ALL_EQUAL.test("a", "a", "X"));
    }
    @Test
    public void checkEqualFalseWithNullFst(){
        assertFalse(ALL_EQUAL.test(null, "a", "a"));
    }
    @Test
    public void checkEqualFalseWithNullSnd(){
        assertFalse(ALL_EQUAL.test("a", null, "a"));
    }
    @Test
    public void checkEqualFalseWithNullThr(){
        assertFalse(ALL_EQUAL.test("a", "a", null));
    }
    @Test
    public void checkEqualFalseWithNullFstSnd(){
        assertFalse(ALL_EQUAL.test(null, "X", "a"));
    }
    @Test
    public void checkEqualFalseWithNullFstTrd(){
        assertFalse(ALL_EQUAL.test(null, "a", "X"));
    }
    @Test
    public void checkEqualFalseWithNullSndSnd(){
        assertFalse(ALL_EQUAL.test("X", null, "a"));
    }
    @Test
    public void checkEqualFalseWithNullSndTrd(){
        assertFalse(ALL_EQUAL.test("a", null, "X"));
    }
    @Test
    public void checkEqualFalseWithNullThrSnd(){
        assertFalse(ALL_EQUAL.test("X", "a", null));
    }
    @Test
    public void checkEqualFalseWithNullThrTrd(){
        assertFalse(ALL_EQUAL.test("a", "X", null));
    }
    @Test
    public void checkEqualAllNull(){
        assertTrue(ALL_EQUAL.test(null, null, null));
    }
    @Test
    public void checkEqualAllNull1(){
        assertFalse(ALL_EQUAL.test(null, null, "a"));
    }
    @Test
    public void checkEqualAllNull2(){
        assertFalse(ALL_EQUAL.test(null, "a", null));
    }
    @Test
    public void checkEqualAllNull3(){
        assertFalse(ALL_EQUAL.test("a", null, null));
    }


    @Test
    public void checkStraightUp(){
        assertTrue(STRAIGHT_UP.test(1, 2, 3));
    }
    @Test
    public void checkStraightUpFalse(){
        assertFalse(STRAIGHT_UP.test(3, 2, 1));
    }
    @Test
    public void checkStraightUpEqual(){
        assertFalse(STRAIGHT_UP.test(1, 2, 2));
    }
    @Test
    public void checkStraightAllEqual(){
        assertFalse(STRAIGHT_UP.test(2, 2, 2));
    }
    @Test
    public void checkStraightFstEqual(){
        assertFalse(STRAIGHT_UP.test(2, 2, 3));
    }
    @Test
    public void checkStraightFalseSnd(){
        assertFalse(STRAIGHT_UP.test(1, 3, 2));
    }



    @Test
    public void checkExactly1(){
        assertFalse(EXACTLY_1.test(true, true, true));
    }
    @Test
    public void checkExactly2(){
        assertFalse(EXACTLY_1.test(false, true, true));
    }
    @Test
    public void checkExactly3(){
        assertFalse(EXACTLY_1.test(true, false, true));
    }
    @Test
    public void checkExactly4(){
        assertFalse(EXACTLY_1.test(true, true, false));
    }
    @Test
    public void checkExactly5(){
        assertTrue(EXACTLY_1.test(false, false, true));
    }
    @Test
    public void checkExactly6(){
        assertTrue(EXACTLY_1.test(true, false, false));
    }
    @Test
    public void checkExactly7(){
        assertTrue(EXACTLY_1.test(false, true, false));
    }
    @Test
    public void checkExactly8(){
        assertFalse(EXACTLY_1.test(false, false, false));
    }




    @Test
    public void checkLexical(){
        assertTrue(LEXICAL.test("a", "bbb", "zip"));
    }

    @Test
    public void checkLexicalFalse(){
        assertFalse(LEXICAL.test("bbb", "a", "zip"));
    }

    @Test
    public void checkLexicalSnd(){
        assertTrue(LEXICAL.test("a", "a", "zip"));
    }

    @Test
    public void checkLexicalFalseSnd(){
        assertFalse(LEXICAL.test("b", "b", "a"));
    }

    @Test
    public void checkLexicalTrueAllEqual(){
        assertTrue(LEXICAL.test("b", "b", "b"));
    }
}
