package edu.hm.gaertner.simon.lab23.a33;


import edu.hm.cs.rs.se.ss23.Xmark;
import edu.hm.cs.rs.se.ss23.a32.Roman;

import java.util.Objects;

/**
 * Task 3.3.
 */
@Xmark("a33")
public class OrderedRoman extends Roman implements Comparable<Roman> {

    /**
     * Ctor - create roman object.
     *
     * @param numberInIntFormat number in int format.
     */
    public OrderedRoman(int numberInIntFormat) {
        super(numberInIntFormat);
    }

    @Override
    public int hashCode() {
        return this.number();
    }

    @Override
    public boolean equals(Object roman) {

        boolean result = false;

        if (!Objects.isNull(roman) && roman instanceof Roman castRoman) {
            if (this.hashCode() == roman.hashCode() && this.number() == castRoman.number() && this.text().equals(castRoman.text()))
                result = true;
        }

        return result;
    }

    @Override
    public int compareTo(Roman roman) {

        int value = 0;

        if (this.number() < roman.number())
            value = -1;
        else if (this.number() > roman.number())
            value = 1;

        return value;
    }
}






