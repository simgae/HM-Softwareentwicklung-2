package edu.hm.gaertner.simon.lab23.a01;

/** Vorgabe zur Aufgabe.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 */
public class SubDigits {
    /** Hauptprogramm.
     * Sucht die Dezimaldarstellung einer Zahl in einer anderen.
     * Gibt aus true (gefunden) oder false (nicht gefunden).
     * @param args Kommandozeilenargumente:
     *             1. Durchsuchte Dezimaldarstellung.
     *             2. Gesuchte Dezimaldarstellung.
     */
    public static void main(String... args) {

        if(args.length < 2)
            throw new IllegalArgumentException("Not enough values!");

        final int haystack = Integer.parseInt(args[0]);
        final int needle = Integer.parseInt(args[1]);
        boolean found = false;

        if(haystack < 0 || needle < 0)
            throw new IllegalArgumentException("At least one value is negative!");


        // calculate the length of both numbers
        int lengthHaystack = calculateLengthOfNumber(haystack);
        int lengthNeedle = calculateLengthOfNumber(needle);

        // create int array with each digit of haystack and fill it with digits
        final int[] haystackArray = fillArrayWithNumberDigits(haystack, lengthHaystack);
        final int[] needleArray = fillArrayWithNumberDigits(needle, lengthNeedle);

        // check if haystackArray contains needleArray
        for (int indexHaystack = 0; indexHaystack < haystackArray.length-needleArray.length+1 && !found; indexHaystack++) {
                found = needleArray[0] == haystackArray[indexHaystack];
            for (int indexNeedle = 1; indexNeedle < needleArray.length && found; indexNeedle++) {
                found = needleArray[indexNeedle] == haystackArray[indexHaystack + indexNeedle];

            }
        }

        System.out.println(found);
    }

    /**
     * Calculate the length of a transferred number.
     * @param number which should be analysis
     * @return length of number
     */
    private static int calculateLengthOfNumber(int number){
        int length = 1;

        while (number > 10){
            length++;
            number /= 10;
        }

        return length;
    }

    /**
     * Fill an array with digits of a number.
     * @param number which delivers the different digits
     * @param lengthNumber length of this number
     * @return array with digits of the number
     */
    private static int[] fillArrayWithNumberDigits(int number, int lengthNumber){

        final int[] result = new int[lengthNumber];

        int pointer = lengthNumber - 1;

        while (number != 0){
            result[pointer] = number % 10;
            number /= 10;
            pointer--;
        }

        return result;
    }
}
