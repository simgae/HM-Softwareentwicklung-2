package edu.hm.gaertner.simon.lab23.a63;

import java.util.stream.IntStream;

public class JuliaStreams extends Julia{

    @Override int[][] render(int pixelX, int pixelY, Complex center, double width, Complex constant) {
        double height = width*pixelY/pixelX;
        final Scaler toReal = new Scaler(0, center.real() - width/2, pixelX, center.real() + width/2);
        final Scaler toImag = new Scaler(0, center.imag() - height/2, pixelY, center.imag() + height/2);

        final int[][] iterations = new int[pixelX][pixelY];


        IntStream.range(0, pixelY)
                .parallel()
                .forEach(y -> IntStream.range(0, pixelX)
                        .forEach(x -> {

                            int passes = 0;
                            Complex d = Complex.make(toReal.map(x), toImag.map(y));
                            while (passes < CUTOFF && d.distance() < ESCAPE) {
                                d = d.mult(d).add(constant);
                                passes++;
                            }
                            iterations[x][y] = passes;

                        }));

        return iterations;
    }

}
