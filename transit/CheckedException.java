import java.util.stream.Stream;

public class CheckedException {
    public static void main(String... args) throws InterruptedException {
        Stream.iterate(0, n -> n + 1)
                .limit(100)
                // .peek(n -> Thread.sleep(n))
                .forEach(System.out::println);
    }
}
