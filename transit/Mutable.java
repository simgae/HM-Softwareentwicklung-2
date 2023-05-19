import java.util.stream.Stream;

public class Mutable {

    public static void main(String... args) {
        int seen = 0;
        long numFound = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .filter(n -> n%2 == 0)
                // .peek(n -> seen++)
                .count();
        System.out.println(numFound);
        System.out.println(seen);
    }
}
