package edu.hm.gaertner.simon.lab23.a63;

public class MutableComplex implements Complex{

    private double real;
    private double imag;

    public MutableComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public double distance() {
        return real*real + imag*imag;
    }

    @Override
    public Complex add(Complex that) {
        real += that.real();
        imag += that.imag();
        return this;
    }

    @Override
    public Complex mult(Complex that) {
        real = real*that.real() - imag*that.imag();
        imag = real*that.imag() + imag*that.real();
        return this;
    }

    @Override
    public double real() {
        return real;
    }

    @Override
    public double imag() {
        return imag;
    }

    @Override
    public String toString() {
        return "MutableComplex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }
}
