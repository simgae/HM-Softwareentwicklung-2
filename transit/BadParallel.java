import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BadParallel {
    static int hard(int n) {
        final int delay = 16;
        final long startMillis = System.currentTimeMillis();
        while(System.currentTimeMillis() - startMillis < delay)
            n += (int)(10*Math.random());
        return n;
    }

    public static void main(String... args) {
        final long startMillis = System.currentTimeMillis();
        System.out.println(Runtime.getRuntime().availableProcessors());
        int sum = Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .map(BadParallel::hard)
                .reduce(0, (s, n) -> s + n);
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - startMillis);
    }
}
