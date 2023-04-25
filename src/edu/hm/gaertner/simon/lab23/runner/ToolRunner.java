package edu.hm.gaertner.simon.lab23.runner;
import edu.hm.cs.rs.se.ss23.tool.BaseToolRunner;

import java.io.IOException;

/** Beispielprogramm zum Start der Werkzeugkette.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-19
 */
public class ToolRunner extends BaseToolRunner {
    @Override public String projectDir() {
        return "C:\\Users\\simon\\OneDrive\\Desktop\\SE2\\sgaertne";
        //return "C:\\Users\\User\\Desktop\\SE2\\sgaertne";
    }

    @Override public String toolBundleDir() {
        return "C:\\Users\\simon\\OneDrive\\Desktop\\SE2\\tool";
        //return "C:\\Users\\User\\Desktop\\SE2\\tool";
    }

    /** Hauptprogramm.
     * Startet nacheinander die Werkzeuge und sichert die Ergebnisse im Filesystem.
     * @param args Kommandozeilenargument: Name eines Subpackage einer Aufgabe.
     *             Beispiel "a00" fuer die Probeaufgabe.
     * @throws IOException wenn der Zugriff aufs Filesystem scheitert.
     */
    public static void main(String... args) throws IOException {
        new ToolRunner().runAll(args[0]);
    }
}
