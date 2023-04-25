package edu.hm.gaertner.simon.lab23.a33;

import edu.hm.cs.rs.se.ss23.a32.Roman;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;


/**
 * Sort romans by lexical order.
 */
public class RomanLexicalOrder implements Comparator<Roman>, Serializable {

    /**
     * Version ID.
     */
    @Serial
    private static final long serialVersionUID = 1;
    @Override
    public int compare(Roman fstRoman, Roman sndRoman) {
        
        final Set<String> sorter = new TreeSet<>();
        
        sorter.add(fstRoman.text());
        sorter.add(sndRoman.text());
        
        int value = 0;

        final Iterator<String> iterator = sorter.iterator();

        final String fstString = iterator.next();

        if(fstString.equals(fstRoman.text()))
            value = -1;
        else if(fstString.equals(sndRoman.text()))
            value = 1;
        
        return value;
    }
}