package edu.hm.gaertner.simon.lab23.a06;

/** Interface fuer Felder mit int-Elementen.
 */
public interface Field<T> {
    /** {@return Anzahl Elemente}
     * Nicht negativ.
     */
    int length();

    /** {@return Wert am gegebenen Index.}
     * @param index Index.
     * @throws IndexOutOfBoundsException wenn der Index unzulaessig ist.
     */
    T at(int index);
}
