/**
 * @version 2023-06-01
 */
public interface Complex {
    static Complex make(double real, double imag) {
        return new MutableComplex(real, imag);
    }

    double distance();

    Complex add(Complex that);

    Complex mult(Complex that);

    double real();

    double imag();
}
