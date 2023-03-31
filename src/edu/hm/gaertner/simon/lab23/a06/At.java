package edu.hm.gaertner.simon.lab23.a06;

/** Interface fuer Funktionen, die den Wert an einem Index berechnen.
 */
@FunctionalInterface public interface At<T> {
    /** {@return Wert des Elementes am gegebenen Index.}
     * @param index Index. Nicht negativ.
     */
    T value(int index);
}
