package edu.hm.cs.rs.se.ss23.a32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Faktoren einer Zahl.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-04-23
 */
public interface Factors {
    /**
     * {@return Liste der Primfaktoren, aufsteigend sortiert.}
     * Wenigstens 1 Faktor.
     * @param number Zahl, die die Methode faktorisiert. Wenigstens 2.
     */
    static List<Integer> of(int number) {
        if(number < 2)
            throw new IllegalArgumentException("at least 2 required, got: " + number);
        List<Integer> factors = new ArrayList<>();
        int factor = 2;
        
        while(number > 1)
            if(number%factor == 0) {
                factors.add(number);
                number /= factor;
            }
            else
                factor++;

         
        assert !factors.isEmpty(): "at least 1 factor";
        assert factors.get(0) > 1: "min factor is 2";
        assert factors.stream().reduce(1, (x, y) -> x*y) == number: "factors product equals number";
        return Collections.unmodifiableList(factors);
    }
}
