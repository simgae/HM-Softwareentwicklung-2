package edu.hm.gaertner.simon.lab23.a32;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task 3.2.
 */
public class Roman {

    /**
     * Map for values. Map numbers to roman chars.
     */
    @SuppressWarnings("magicnumber")
    static final Map<Integer, String> VALUES = new TreeMap<>(Collections.reverseOrder())
    {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    /**
     * roman string format of number.
     */
    private final String numberInStringFormat;

    /**
     * int format of number.
     */
    private final int numberInIntFormat;


    /**
     * ctor- only transmitted string format.
     *
     * @param numberInStringFormat string format of number.
     */
    public Roman(String numberInStringFormat) {


        this.numberInStringFormat = numberInStringFormat;
        this.numberInIntFormat = calculateStringToInt(numberInStringFormat);
    }

    /**
     * ctor - only transmitted int format.
     *
     * @param numberInIntFormat number in int format.
     */
    public Roman(int numberInIntFormat) {
        this.numberInIntFormat = numberInIntFormat;
        this.numberInStringFormat = calculateIntToString(numberInIntFormat);
    }

    /**
     * Ctor - when both number formats are available.
     *
     * @param numberInIntFormat    - number in int format
     * @param numberInStringFormat - number in string format
     */
    public Roman(int numberInIntFormat, String numberInStringFormat) {
        this.numberInIntFormat = numberInIntFormat;
        this.numberInStringFormat = numberInStringFormat;

    }

    /**
     * Calculate roman number string into int value.
     *
     * @param numberInStringFormat number in string format.
     * @return number in int format.
     */
    private static int calculateStringToInt(String numberInStringFormat) {

        final char[] chars = numberInStringFormat.toCharArray();


        int result = 0;


        for (int index = 0; index < chars.length; index++) {

            final String twoLetters = chars[index] + String.valueOf(chars[index + 1]);

            if (VALUES.containsValue(twoLetters)) {
                result += findKeyInMap(twoLetters);
                index++;
            } else {
                final String oneLetter = String.valueOf(chars[index]);
                result += findKeyInMap(oneLetter);
            }

        }

        return result;
    }

    /**
     * Calculate number in int format to roman string format.
     *
     * @param numberInIntFormat int value.
     * @return number in roman string format.
     */
    private static String calculateIntToString(int numberInIntFormat) {

        int number = numberInIntFormat;
        final StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> value : VALUES.entrySet()) {
            final int rest = number / value.getKey();

            result.append(String.valueOf(value.getValue()).repeat(Math.max(0, rest)));

            number %= value.getKey();

        }

        return String.valueOf(result);

    }

    /**
     * getter for roman number in string format.
     *
     * @return string format of number.
     */
    public String text() {
        return this.numberInStringFormat;
    }

    /**
     * getter for number in int format.
     *
     * @return int format of number.
     */
    public int number() {
        return this.numberInIntFormat;
    }

    /**
     * Find key by value in map.
     *
     * @param value value of map.
     * @return key of value.
     */
    private static int findKeyInMap(String value) {

        int result = 0;

        for (Map.Entry<Integer, String> entry : VALUES.entrySet()) {
            if (entry.getValue().equals(value)) {
                result += entry.getKey();
            }
        }
        return result;
    }

}
