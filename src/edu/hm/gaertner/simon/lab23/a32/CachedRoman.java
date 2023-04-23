package edu.hm.gaertner.simon.lab23.a32;

import java.util.Map;
import java.util.TreeMap;

/**
 * Task 3.2.
 */
public class CachedRoman {
// This mutation can not be killed because
// factory class have no ctor - no object is initialized

    /**
     * Map used to chace vaules.
     */
    private static final Map<Integer, String> CACHE = new TreeMap<>();

    /**
     * Facotry method - create string value out of int format.
     *
     * @param number int format
     * @return new roman object with both formats.
     */
    public static Roman make(int number) {

        final Roman result;

        // This mutation can not be killed because if statement has
        // only performance reasons and no functionality
        if (CACHE.containsKey(number))
            result = new Roman(number, CACHE.get(number));
        else {
            result = new Roman(number);
            CACHE.put(number, result.text());
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

        // This mutation can not be killed because if statement has
        // only performance reasons and no functionality
        if (CACHE.containsValue(number))
            result = new Roman(findKeyInMap(number), number);
        else {
            result = new Roman(number);
            CACHE.put(result.number(), number);
        }

        return result;
    }


    /**
     * Find key by value in map.
     *
     * @param value value of map.
     * @return key of value.
     */
    private static int findKeyInMap(String value) {

        int result = 0;

        for (Map.Entry<Integer, String> entry : CACHE.entrySet()) {
            if (entry.getValue().equals(value)) {
                result += entry.getKey();
            }
        }
        return result;
    }
}
