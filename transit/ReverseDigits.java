/** Loesung zur Probeaufgabe.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 */
// @Xmark("a00")
public class ReverseDigits {
    /** Hauptprogramm.
     * Gibt eine Zahl in umgedrehter Dezimalschreibweise aus.
     * @param args Kommandozeilenargument: Nicht negative ganze Zahl.
     */
    public static void main(String... args) {
        int theNumber = Integer.parseInt(args[0]);
        int reversed = 0;
        while(theNumber > 1) {
            reversed = 10*reversed + theNumber%10;
            theNumber /= 10;
        }
        System.out.println(reversed);
    }
}
