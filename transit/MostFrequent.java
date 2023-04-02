import java.util.NoSuchElementException;

/** Element in einem int-Array und Anzahl der Vorkommen.
 * Praktikum SE2, SS2023 (Schiedermeier).
 * @version 2023-03-22
 * @param value Wert des Elementes.
 * @param occurences Anzahl Vorkommen. Wenigstens 1.
 */
public record MostFrequent(int value, int occurences) {
    /** Sucht in einem int-Array nach dem Element, das am oeftesten vorkommt.
     * Wenn es mehrere Kandidaten gibt, gilt der erste.
     * @param array Ein Array.
     * @return Haeufigstes Element. Nicht null.
     * @throws NullPointerException wenn das Array nicht existiert (null ist).
     * @throws NoSuchElementException wenn das Array leer ist.
     */
    public static MostFrequent scan(int... array) {
        MostFrequent mostFrequentSoFar = null;
        for(int currentValue : array) {
            int currentFound = 0;
            for(int comparedValue : array)
                if(comparedValue == currentValue)
                    currentFound++;
            if(mostFrequentSoFar == null || currentFound > mostFrequentSoFar.occurences())
                mostFrequentSoFar = new MostFrequent(currentValue, currentFound);
        }
        return mostFrequentSoFar;
    }
}
