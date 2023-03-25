package edu.hm.cs.rs.se.ss23.a13;

/** Vorbereiteter Dialog.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 */
public class CannedIO implements IO {
    /** Vorbereitete Eingaben. */
    private final String[] preparedInputs;

    /** Anzahl bisher abgerufener Eingaben
     * Nicht negativ und hoechstens die Gesamtzahl der vorbereiteten Eingaben.
     */
    private int inputsRead;

    /** Letzt Ausgabe oder null vor der ersten. */
    private String recordedOutput;

    /** Neuer Dialog.
     * @param preparedInputs Vorbereitete Eingaben.
     *                       Nicht null.
     */
    public CannedIO(String... preparedInputs) {
        this.preparedInputs = preparedInputs.clone();
    }

    @Override public String read(String prompt) {
        return preparedInputs[inputsRead++];
    }

    @Override public void write(String text) {
        recordedOutput = text;
    }

    public String recordedOutput() {
        return recordedOutput;
    }
}
