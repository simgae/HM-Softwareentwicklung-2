import java.util.stream.Stream;

/** Parallele Pipelines nur sinnvoll, wenn Stages kurz.
 */
public class BadParallel {
    static int hard(int n) {
        int delay = 16;
        final long startMillis = System.currentTimeMillis();
        while(System.currentTimeMillis() - startMillis < delay)
            n += (int)(10*Math.random());
        return n;
    }

    public static void main(String... args) {
        int sum = Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .map(BadParallel::hard)
                .reduce(0, (s, n) -> s + n);
        System.out.println(sum);
    }
}
