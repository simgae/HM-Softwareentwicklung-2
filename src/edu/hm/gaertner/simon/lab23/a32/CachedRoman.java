package edu.hm.gaertner.simon.lab23.a32;

import edu.hm.cs.rs.se.ss23.Xmark;
import edu.hm.cs.rs.se.ss23.a32.Roman;

import java.util.Map;
import java.util.TreeMap;

/**
 * Task 3.2.
 */
@Xmark("a32")
public class CachedRoman {
// This mutation can not be killed because
// factory class have no ctor - no object is initialized

    /**
     * Map used to cache values.
     */
    private static final Map<Integer, Roman> CACHE_INT = new TreeMap<>();

    /**
     * Map used to cache values.
     */
    private static final Map<String, Roman> CACHE_STRING = new TreeMap<>();

    /**
     * Facotry method - create string value out of int format.
     *
     * @param number int format
     * @return new roman object with both formats.
     */
    public static Roman make(int number) {

        final Roman result;

        // This mutation can not be killed because the tool runner
        // run in one program instance -> multiple tools run the tests
        // and already collect the objects in the maps
        // PiTest run at the end and do not have to create new objects.
        // When you run PiTest isolated the mutations are gone.
        if (CACHE_INT.containsKey(number))
            result = CACHE_INT.get(number);
        else {
            result = new Roman(number);
            CACHE_INT.put(number, result);
        }

        return result;

    }

    /**
     * Factory method - create int value out of roman string value.
     * Uses cache map.
     *
     * @param number in roman string format.
     * @return romen object with both values.
     */
    public static Roman make(String number) {

        final Roman result;

        // This mutation can not be killed because the tool runner
        // run in one program instance -> multiple tools run the tests
        // and already collect the objects in the maps
        // PiTest run at the end and do not have to create new objects.
        // When you run PiTest isolated the mutations are gone.
        if (CACHE_STRING.containsKey(number))
            result = CACHE_STRING.get(number);
        else {
            result = new Roman(number);
            CACHE_STRING.put(number, result);
        }

        return result;
    }
}
