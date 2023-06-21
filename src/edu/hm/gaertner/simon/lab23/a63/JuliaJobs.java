package edu.hm.gaertner.simon.lab23.a63;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JuliaJobs extends Julia{

    @Override
    int[][] render(int pixelX, int pixelY, Complex center, double width, Complex constant) throws InterruptedException {
        double height = width * pixelY / pixelX;
        final Scaler toReal = new Scaler(0, center.real() - width / 2, pixelX, center.real() + width / 2);
        final Scaler toImag = new Scaler(0, center.imag() - height / 2, pixelY, center.imag() + height / 2);

        final int[][] iterations = new int[pixelX][pixelY];

        List<Integer> rows = new ArrayList<>();


        IntStream.range(0, pixelY)
                        .forEach(rows::add);


        IntStream.range(0, pixelY)
                .mapToObj(n -> new JuliaJobs.JuliaThread(pixelX, rows, constant, toImag, toReal, iterations))
                .parallel()
                .map(Thread::new)
                .forEach(Thread::start);

        return iterations;
    }

    public record JuliaThread (int pixelX, List<Integer> rows, Complex constant, Scaler toImag, Scaler toReal, int[][] iterations) implements Runnable{
        @Override
        public void run() {

            int row;

            synchronized ("Key"){
                    row = rows.get(0);
                    rows.remove(0);
            }

            IntStream.range(row, row+1)
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

        }
    }


}
