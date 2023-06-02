import java.util.stream.IntStream;

/**
 * @version 2023-06-01
 */
public record ColorMap(int[] argb) {
    public ColorMap(int numColors) {
        this(buildMap(numColors));
    }

    private static int[] buildMap(int numColors) {
        final int stop1 = 16;
        final int stop2 = numColors/10;
        final int stop3 = numColors/4;
        Slopes red = new Slopes(0, 0, stop2, 0, stop3, 255, numColors, 255);
        Slopes green = new Slopes(0, 0, stop1, 0, stop2, 255, stop3, 255, numColors, 0);
        Slopes blue = new Slopes(0, 0, stop1, 255, stop2, 0, numColors, 0);
        final int black = 0xFF00_0000;
        int[] argb = IntStream.rangeClosed(0, numColors)
                .map(index -> black
                        | (red.apply(index) << 16)
                        | (green.apply(index) << 8)
                        | blue.apply(index))
                .toArray();
        argb[numColors] = black;
        return argb;
    }

    int map(int index) {
        return argb[index];
    }
}
