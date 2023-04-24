package edu.hm.gaertner.simon.lab23.a34;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SymmetricMapTests {
    @Test
    public void testAddIdenticalValue(){
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        map.put("IIII", 4);
        assertEquals(1, map.size());
    }

    @Test
    public void testAddIdenticalKey(){
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        map.put("IV", 2);
        assertEquals(Optional.of(2), Optional.ofNullable(map.get("IV")));
    }

    @Test
    public void revert(){
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        map.put("IIII", 4);
        SymmetricMap<Integer, String> reverted = map.revert();
        reverted.put(-4, "IV");
        reverted.put(4, "IV");
        reverted.put(-4, "-IV");

        assertEquals("-IV", reverted.get(-4));
    }

    @Test
    public void revertTwoTimes(){
        SymmetricMap<Integer, Integer> original = new SymmetricMap<>();
        original.put(1, 2);
        original.put(2, 3);
        original.put(null, null);
        SymmetricMap<Integer, Integer> copy = original.revert().revert().revert().revert();

        assertEquals(copy, original);
    }

    @Test
    public void testAddUseReturn(){
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        Integer result = map.put("IV", 4);
        assertNotNull(result);
    }

    @Test
    public void testAddIdenticalValueBiggerMap(){
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        map.put("V", 2);
        map.put("VI", 1);
        map.put("I", 5);

        assertEquals("VI", SymmetricMap.findKeyInMap(1, map));
    }
}
