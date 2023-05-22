import java.util.stream.Stream;

/** Stream darf keine externen Daten aendern.
 */
public class Mutable {
    public static void main(String... args) {
        int seen = 0;
        long numFound = Stream.iterate(0, n -> n + 1)
                .limit(10_000_000)
                .filter(n -> n%2 == 0)
                // .peek(__ -> seen++)
                .count();
        System.out.println(numFound);
        System.out.println(seen);
    }
}
