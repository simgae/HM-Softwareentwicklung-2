package edu.hm.gaertner.simon.lab23.a63;

/**
 * @version 2023-05-30
 */
record ImmutableComplex(double real, double imag) implements Complex {
    @Override public double distance() {
        return real*real + imag*imag;
    }

    @Override public Complex add(Complex that) {
        return new ImmutableComplex(real + that.real(), imag + that.imag());
    }

    @Override public Complex mult(Complex that) {
        return new ImmutableComplex(real*that.real() - imag*that.imag(), real*that.imag() + imag*that.real());
    }
}
