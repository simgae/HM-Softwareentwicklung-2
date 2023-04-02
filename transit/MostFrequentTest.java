import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Tests.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 */
public class MostFrequentTest {
    @Rule public Timeout globalTimeout = Timeout.millis(1_000);

    @Test public void only1Element() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 1);
        final int[] array = {1};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void distinctElements() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 1);
        final int[] array = {1, 2, 3};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void firstWins() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {1, 1, 2, 2};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerAtFront() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {1, 1, 2};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerAtEnd() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {2, 1, 1};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void winnerInside() {
        // arrange
        final MostFrequent want = new MostFrequent(1, 2);
        final int[] array = {2, 1, 1, 3};

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Test public void array1k() {
        // arrange
        final int zeroes = 1_000;
        final MostFrequent want = new MostFrequent(0, zeroes);
        final int[] array = new int[zeroes];

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Ignore @Test public void tooSlow() {
        // arrange
        final int zeroes = 1_000_000;
        final MostFrequent want = new MostFrequent(0, zeroes);
        final int[] array = new int[zeroes];

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

    @Ignore @Test public void interleaved() {
        // arrange
        final int zeroes = 1_000_000;
        final MostFrequent want = new MostFrequent(0, zeroes);
        final int[] array = Stream.generate(() -> IntStream.of(0, 1))
                .limit(zeroes)
                .flatMapToInt(Function.identity())
                .toArray();

        // act
        final MostFrequent have = MostFrequent.scan(array);

        // assert
        assertEquals(want, have);
    }

}
