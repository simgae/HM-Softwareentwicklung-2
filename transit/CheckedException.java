import java.util.stream.Stream;

/** Streams vertragen sich nicht gut mit Checked Exceptions.
 * Das Problem sind die Parametertypen der Streammethoden, die Funktionsinterfaces sind.
 * Deren abstrakte Methoden haben leere Exceptionsignaturen.
 */
public class CheckedException {
    public static void main(String... args) throws InterruptedException {
        Stream.iterate(0, n -> n + 1)
                .limit(100)
                // .peek(n -> Thread.sleep(n))
                .forEach(System.out::println);
    }

}

