package edu.hm.gaertner.simon.lab23.a33;

import edu.hm.gaertner.simon.lab23.a32.Roman;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Sort romans by text length.
 */
public class RomanTextLengthOrder implements Comparator<Roman>, Serializable {

    /**
     * Version ID.
     */
    @Serial
    private static final long serialVersionUID = 1;

    @Override
    public int compare(Roman fstRoman, Roman sndRoman) {

        int value = 0;

        if (fstRoman.text().length() < sndRoman.text().length())
            value = -1;
        else if (fstRoman.text().length() > sndRoman.text().length())
            value = 1;

        return value;
    }
}