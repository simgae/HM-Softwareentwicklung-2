package edu.hm.cs.rs.se.ss23.a13;

/** Ein gekuerzter Bruch.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-22
 * @param num Zaehler.
 * @param denom Nenner. Wenigstens 1.
 */
public record Rational(int num, int denom) {
    /** Neuer Bruch.
     */
    public Rational {
        if(denom == 0)
            throw new ArithmeticException("zero denominator");
        if(num == 0)
            denom = 1;
        else {
            if(denom < 0) {
                denom = -denom;
                num = -num;
            }
            final int gcd = gcd(Math.abs(num), denom);
            num /= gcd;
            denom /= gcd;
        }
        assert denom > 0;
    }

    /** {@return Textdarstellung.} */
    public String asText() {
        return denom == 1?
                Integer.toString(num):
                num() + ":" + denom;
    }

    /** {@return Neuer Bruch mit dem Kehrwert.} */
    public Rational invert() {
        return new Rational(denom(), num());
    }

    /** {@return Neuer Bruch mit der Summe beider Brueche.}
     * @param that Zweiter Summand.
     */
    public Rational add(Rational that) {
        return new Rational(num()*that.denom() + denom()*that.num(), denom()*that.denom());
    }

    /** {@return Neuer Bruch mit der Differenz beider Brueche.}
     * @param that Subtrahend.
     */
    public Rational sub(Rational that) {
        return new Rational(num()*that.denom() - denom()*that.num(), denom()*that.denom());
    }

    /** {@return Neuer Bruch mit dem Produkt beider Brueche.}
     * @param that Zweiter Faktor.
     */
    public Rational mult(Rational that) {
        return new Rational(num()*that.num(), denom()*that.denom());
    }

    /** {@return Neuer Bruch mit dem Quotienten beider Brueche.}
     * @param that Divisor.
     */
    public Rational div(Rational that) {
        return mult(that.invert());
    }

    /** {@return GgT von zwei echt positiven Zahlen..}
     * @param fst Eine Zahl.
     * @param snd Noch eine Zahl.
     */
    private static int gcd(int fst, int snd) {
        assert fst > 0;
        assert snd > 0;
        int reducedA = fst;
        int reducedB = snd;
        int rest = reducedA%reducedB;
        while(rest > 0) {
            reducedA = reducedB;
            reducedB = rest;
            rest = reducedA%reducedB;
        }
        assert reducedB > 0;
        assert fst%reducedB == 0;
        assert snd%reducedB == 0;
        return reducedB;
    }
}
