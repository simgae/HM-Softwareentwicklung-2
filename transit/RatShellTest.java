import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @version 2023-03-25
 */
public class RatShellTest {
    @Rule public Timeout globalTimeout = Timeout.millis(1_000);

    @Test public void exit() {
        // arrange
        final CannedIO io = new CannedIO("x".split("\\s+"));
        final RatShell sut = new RatShell(io);

        // act
        sut.dialogLoop();

        // assert
        assertNull(io.recordedOutput());
    }

    @Test public void stack23() {
        // arrange
        final CannedIO io = new CannedIO("2:3 x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 2:3";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void stack0() {
        // arrange
        final CannedIO io = new CannedIO("0:-2 x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 0";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void stack2() {
        // arrange
        final CannedIO io = new CannedIO("2 x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 2";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void add() {
        // arrange
        final CannedIO io = new CannedIO("2:3 1:6 + x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 5:6";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void sub() {
        // arrange
        final CannedIO io = new CannedIO("2:3 1:6 - x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 1:2";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void mult() {
        // arrange
        final CannedIO io = new CannedIO("2:3 1:6 * x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 1:9";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void submore() {
        // arrange
        final CannedIO io = new CannedIO("2:3 7:5 - x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] -11:15";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void div() {
        // arrange
        final CannedIO io = new CannedIO("2:3 1:6 / x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 4";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void invert() {
        // arrange
        final CannedIO io = new CannedIO("2:4 \\ x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 2";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void negate() {
        // arrange
        final CannedIO io = new CannedIO("1:-3 # x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 1:3";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void memory() {
        // arrange
        final CannedIO io = new CannedIO("2:7 m x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 2:7";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void negative() {
        // arrange
        final CannedIO io = new CannedIO("-2:-2 x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 1";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void recall() {
        // arrange
        final CannedIO io = new CannedIO("2:7 m r x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[1] 2:7";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }

    @Test public void recallTwice() {
        // arrange
        final CannedIO io = new CannedIO("2:7 m r r + * x".split("\\s+"));
        final RatShell sut = new RatShell(io);
        final String want = "[0] 8:49";

        // act
        sut.dialogLoop();
        final String have = io.recordedOutput();

        // assert
        assertEquals(want, have);
    }
}
