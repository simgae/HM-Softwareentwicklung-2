import java.util.stream.Stream;

public class String1stA {
    public static void main(String... args) {
        args = args.length == 0? new String[] {"Abra", "ka", "dabra", "Sim", "sala", "bim"}: args;
        final char needle = 'a';

        int firstIndex = Stream.of(args)
                .map(string -> string.indexOf(needle))
                .filter(at -> at >= 0)
                .min((x, y) -> x - y)
                .orElse(-1);

        System.out.println(firstIndex);
    }
}
