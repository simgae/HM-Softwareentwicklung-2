package edu.hm.gaertner.simon.lab23.a04;

import edu.hm.cs.rs.se.ss23.a04.IntField;
import java.util.ArrayList;

/**
 * List with a specific length and constant value in each int item.
 * @param length -> specific length for list
 * @param constant -> value of each int item
 * @param intChain -> underlying list
 */
public record ConstantIntField(int length, int constant, ArrayList<Integer> intChain) implements IntField {

    /**
     * Ctor - with 2 parameters
     * @param length of chain
     * @param constant value of elements
     */
    public ConstantIntField(int length, int constant){
        this(length, constant, new ArrayList<>());
    }

    /**
     * Ctor - create list and fill with values
     * @param length of chain
     * @param constant value of elements
     * @param intChain -> filled by this ctor
     * @throws IllegalArgumentException when length is negative
     */
    public ConstantIntField(int length, int constant, ArrayList<Integer> intChain){

        if(length < 0)
            throw new IllegalArgumentException("Length is negative!");

        this.intChain = intChain;
        this.length = length;
        this.constant = constant;

        for (int index = 0; index < length; index++) {
            this.intChain.add(constant);
        }

    }

    @Override
    public int length() {
        return intChain().size();
    }

    @Override
    public int at(int index) {
        return intChain.get(index);
    }
}
