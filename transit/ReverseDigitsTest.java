import edu.hm.cs.rs.se.ss23.common.CaptureSystemOut;
import org.junit.Test;

/** Praktikum SE2, SS2023 (Schiedermeier).
 * Tests zur Probeaufgabe.
 * @version 2023-03-17
 */
// @Xmark("a00")
public class ReverseDigitsTest {
    private final String sutFQCN = getClass().toString()
            .replace("class ", "")
            .replace("Test", "");

    @Test(timeout = 1_000) public void callmain_0() throws ReflectiveOperationException {
        // arrange
        final String given = "0";
        final String want = "0";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_1() throws ReflectiveOperationException {
        // arrange
        final String given = "1";
        final String want = "1";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_111() throws ReflectiveOperationException {
        // arrange
        final String given = "111";
        final String want = "111";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_12() throws ReflectiveOperationException {
        // arrange
        final String given = "12";
        final String want = "21";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_112() throws ReflectiveOperationException {
        // arrange
        final String given = "112";
        final String want = "211";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_123456789() throws ReflectiveOperationException {
        // arrange
        final String given = "123456789";
        final String want = "987654321";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_100() throws ReflectiveOperationException {
        // arrange
        final String given = "100";
        final String want = "1";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_1001() throws ReflectiveOperationException {
        // arrange
        final String given = "1001";
        final String want = "1001";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void callmain_11223344() throws ReflectiveOperationException {
        // arrange
        final String given = "11223344";
        final String want = "44332211";
        // act
        final String have = CaptureSystemOut.capture(sutFQCN, given).trim();
        // assert
        org.junit.Assert.assertEquals(want, have);
    }

}

