package edu.hm.gaertner.simon.lab23.a33;

import edu.hm.cs.rs.se.ss23.a32.Factors;
import edu.hm.cs.rs.se.ss23.a32.Roman;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;



/**
 * Sorts romans by factors.
 */
public class RomanByFactors implements Comparator<Roman>, Serializable {

    /**
     * Version ID.
     */
    @Serial
    private static final long serialVersionUID = 1;

    @Override
    public int compare(Roman fstRoman, Roman sndRoman) {

        final List<Integer> factorsOfFstRoman = new ArrayList<>(Factors.of(fstRoman.number()));
        final List<Integer> factorsOfSndRoman = new ArrayList<>(Factors.of(sndRoman.number()));

        int value = 0;

        if (factorsOfFstRoman.size() == factorsOfSndRoman.size()) {
            Collections.sort(factorsOfFstRoman);
            Collections.sort(factorsOfSndRoman);

            boolean difference = false;
            for (int index = 0; index < factorsOfFstRoman.size() && !difference; index++) {
                if (factorsOfFstRoman.get(index) < factorsOfSndRoman.get(index)){
                    value = -1;
                    difference = true;
                }
                else if (factorsOfFstRoman.get(index) > factorsOfSndRoman.get(index)){
                    value = 1;
                    difference = true;
                }
            }


        } else if (factorsOfFstRoman.size() < factorsOfSndRoman.size())
            value = -1;
        else
            value = 1;

        return value;
    }
}