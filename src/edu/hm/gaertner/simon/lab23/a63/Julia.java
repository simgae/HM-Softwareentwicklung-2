package edu.hm.gaertner.simon.lab23.a63;

import java.io.IOException;
import java.util.List;

/** Basisklasse zum Berechnen von Juliamengen.
 * [Peitgen, J.-O.; Richter, P. H. - The Beauty of Fractals; Springer 1986; ISBN 3-540-15851-0]
 * @version 2023-05-30
 */
public abstract class Julia {
    /** Anzahl Iterationen, nach denen ein Attraktor als erreicht gilt. */
    public static final int CUTOFF = 1024;

    /** Entfernung (Quadrat), ab der ein Punkt entkommt. */
    public static final int ESCAPE = 100;

    public static final int CORES = Runtime.getRuntime().availableProcessors();

    static Julia make() {
        return new JuliaJobs();
    }

    public static void main(String... args) throws IOException, ReflectiveOperationException, InterruptedException {
        final int pixelX = 4096; // Bildbreite (Pixel)
        final int pixelY = 3072; // Bildhoehe (Pixel)
        final Complex center = Complex.make(0, 0);
        final double width = 4; // Breite des Ausschnitts

        ImageFiler filer = new ImageFiler("julia%02d.png", new ColorMap(CUTOFF));
        Julia julia = make();
        int numImages = 0;
        for(Complex constant : List.of(Complex.make(0.31, 0.04),
                                Complex.make(-0.11, 0.6557),
                                Complex.make(-0.12, 0.74),
                                Complex.make(0, 1),
                                Complex.make(-0.194, 0.6557),
                                Complex.make(-0.74543, 0.11301),
                                Complex.make(-1.25, 0.005),
                                Complex.make(-0.481762, -0.531657),
                                Complex.make(-0.39054, -0.58679),
                                Complex.make(-0.15652, -1.03225),
                                Complex.make(0.11031, -0.67037),
                                Complex.make(0.27334, 0.00742))) {
            System.out.println(constant);
            final long startMillis = System.currentTimeMillis();
            final int[][] iterations = julia.render(pixelX, pixelY, center, width, constant);
            System.out.println("\telapsed millis: " + (System.currentTimeMillis() - startMillis));
            filer.save(numImages++, iterations);
        }
    }

    abstract int[][] render(int width, int height, Complex center, double widthR, Complex constant) throws InterruptedException;
}
