import java.io.IOException;

/** Beispielprogramm zum Start der Werkzeugkette.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-04-04
 */
public class MinnieToolRunner extends BaseToolRunner {
    @Override public String projectDir() {
        return "c:\\Users\\Me\\IdeaProjects\\Lab"; // TODO - anpassen
    }

    @Override public String toolBundleDir() {
        return "c:\\Users\\Me\\Downloads\\tool-bundle"; // TODO - anpassen
    }

    /** Hauptprogramm.
     * Startet nacheinander die Werkzeuge und sichert die Ergebnisse im Filesystem.
     * @param args Kommandozeilenargument: Name eines Subpackage einer Aufgabe.
     *             Beispiel "a00" fuer die Probeaufgabe.
     * @throws IOException wenn der Zugriff aufs Filesystem scheitert.
     */
    public static void main(String... args) throws IOException {
        new MinnieToolRunner().runAll(args[0]);
    }
}
