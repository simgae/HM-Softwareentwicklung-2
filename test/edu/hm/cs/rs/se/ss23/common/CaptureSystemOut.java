package edu.hm.cs.rs.se.ss23.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

/** Startet ein Runnable und sammelt Ausgaben.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-18
 */
public class CaptureSystemOut {
    public interface BombingRunnable {
        void run() throws IOException, ReflectiveOperationException;
    }

    /** Startet ein Runnable und faengt Stdout auf.
     * Verwirft Stderr.
     * @param runnable Codeblock.
     * @return Standardausgabe des Codeblocks. Nicht null.
     */
    public static String capture(BombingRunnable runnable) {
        return capture(runnable, false);
    }

    /** Startet ein Runnable und faengt die Ausgaben auf.
     * @param runnable Codeblock.
     * @param mergeStderr true = Stderr und Stdout zusammenfassen;
     *                    false = Stderr verwerfen.
     * @return Ausgaben des Codeblocks. Nicht null.
     */
    public static String capture(BombingRunnable runnable, boolean mergeStderr) {
        return capture(runnable, "", true);
    }

    /** Startet ein Runnable und faengt die Ausgaben auf.
     * @return Ausgaben des Codeblocks. Nicht null.
     */
    public static String capture(String mainType, String... args) throws ReflectiveOperationException {
        Class<?> type = Class.forName(mainType);
        Method main = type.getDeclaredMethod("main", String[].class);
        BombingRunnable runnable = () -> main.invoke(null, (Object)args);
        return capture(runnable, "", false);
    }

    /** Startet ein Runnable und faengt die Ausgaben auf.
     * @param runnable Codeblock.
     * @param input String, den das Runnable als Stdin erhaelt.
     * @param mergeStderr true = Stderr und Stdout zusammenfassen;
     *                    false = Stderr verwerfen.
     * @return Ausgaben des Codeblocks. Nicht null.
     */
    public static String capture(BombingRunnable runnable, String input, boolean mergeStderr) {
        final InputStream systemIn = System.in;
        final PrintStream systemOut = System.out;
        final PrintStream systemErr = System.err;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ByteArrayInputStream fakeInput = new ByteArrayInputStream(input.getBytes());
            PrintStream fakeOutput = new PrintStream(byteArrayOutputStream, true);
            PrintStream fakeError = mergeStderr? fakeOutput: systemErr) {
            System.setIn(fakeInput);
            System.setOut(fakeOutput);
            System.setErr(fakeError);
            runnable.run();
        } catch(IOException ioException) {
            throw new AssertionError("can't happen");
        } catch(ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        } finally {
            System.setIn(systemIn);
            System.setOut(systemOut);
            System.setErr(systemErr);
        }
        return byteArrayOutputStream.toString().replace("\r", ""); // strip Windows' CRs
    }
}
