package edu.hm.gaertner.simon.lab23.a43;

import org.junit.Test;

import static org.junit.Assert.*;
import static edu.hm.gaertner.simon.lab23.a43.Troolean.*;

public class TrooleanTest {

    @Test
    public void checkNOT1(){
        assertEquals(NOT.apply(FALSE), TRUE);
    }

    @Test
    public void checkNOT2(){
        assertEquals(NOT.apply(MAYBE), MAYBE);
    }

    @Test
    public void checkNOT3(){
        assertEquals(NOT.apply(TRUE), FALSE);
    }


    @Test
    public void checkOR1(){
        assertEquals(OR.apply(FALSE, FALSE), FALSE);
    }

    @Test
    public void checkOR2(){
        assertEquals(OR.apply(FALSE, MAYBE), MAYBE);
    }

    @Test
    public void checkOR3(){
        assertEquals(OR.apply(FALSE, TRUE), TRUE);
    }

    @Test
    public void checkOR4(){
        assertEquals(OR.apply(MAYBE, FALSE), MAYBE);
    }

    @Test
    public void checkOR5(){
        assertEquals(OR.apply(MAYBE, MAYBE), MAYBE);
    }

    @Test
    public void checkOR6(){
        assertEquals(OR.apply(MAYBE, TRUE), TRUE);
    }

    @Test
    public void checkOR7(){
        assertEquals(OR.apply(TRUE, FALSE), TRUE);
    }

    @Test
    public void checkOR8(){
        assertEquals(OR.apply(TRUE, MAYBE), TRUE);
    }

    @Test
    public void checkOR9(){
        assertEquals(OR.apply(TRUE, TRUE), TRUE);
    }





    @Test
    public void checkAND1(){
        assertEquals(AND.apply(FALSE, FALSE), FALSE);
    }

    @Test
    public void checkAND2(){
        assertEquals(AND.apply(FALSE, MAYBE), FALSE);
    }

    @Test
    public void checkAND3(){
        assertEquals(AND.apply(FALSE, TRUE), FALSE);
    }

    @Test
    public void checkAND4(){
        assertEquals(AND.apply(MAYBE, FALSE), FALSE);
    }

    @Test
    public void checkAND5(){
        assertEquals(AND.apply(MAYBE, MAYBE), MAYBE);
    }

    @Test
    public void checkAND6(){
        assertEquals(AND.apply(MAYBE, TRUE), MAYBE);
    }

    @Test
    public void checkAND7(){
        assertEquals(AND.apply(TRUE, FALSE), FALSE);
    }

    @Test
    public void checkAND8(){
        assertEquals(AND.apply(TRUE, MAYBE), MAYBE);
    }

    @Test
    public void checkAND9(){
        assertEquals(AND.apply(TRUE, TRUE), TRUE);
    }



    @Test
    public void checkXOR1(){
        assertEquals(XOR.apply(FALSE, FALSE), FALSE);
    }

    @Test
    public void checkXOR2(){
        assertEquals(XOR.apply(FALSE, MAYBE), MAYBE);
    }

    @Test
    public void checkXOR3(){
        assertEquals(XOR.apply(FALSE, TRUE), TRUE);
    }

    @Test
    public void checkXOR4(){
        assertEquals(XOR.apply(MAYBE, FALSE), MAYBE);
    }

    @Test
    public void checkXOR5(){
        assertEquals(XOR.apply(MAYBE, MAYBE), MAYBE);
    }

    @Test
    public void checkXOR6(){
        assertEquals(XOR.apply(MAYBE, TRUE), MAYBE);
    }

    @Test
    public void checkXOR7(){
        assertEquals(XOR.apply(TRUE, FALSE), TRUE);
    }

    @Test
    public void checkXOR8(){
        assertEquals(XOR.apply(TRUE, MAYBE), MAYBE);
    }

    @Test
    public void checkXOR9(){
        assertEquals(XOR.apply(TRUE, TRUE), FALSE);
    }
}
