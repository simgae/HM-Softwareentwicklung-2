import java.util.stream.Stream;

/** Pipeline transportiert 1 Datum, das sie transformiert.
 * Es gibt keinen Zugriff auf "upstream" Data.
 */
public class String1stA {
    public static void main(String... args) {
        args = args.length == 0? new String[] {"Abra", "ka", "dabra", "Sim", "sala", "bim"}: args;
        // (0) Ausgabe mit 'a' = 1, 'm' = 2, 'k' = 0, 'x' = -1
        final char needle = 'a';

        int firstIndex = Stream.of(args)
                .map(string -> string.indexOf(needle))
                .filter(at -> at >= 0)
                .min((x, y) -> x - y)
                .orElse(-1);

        System.out.println(firstIndex);
    }
}
