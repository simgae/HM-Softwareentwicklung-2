package edu.hm.gaertner.simon.lab23.a06;

import java.util.ArrayList;

/**
 * List with a specific length and constant value in each int item.
 * @param length -> specific length for list
 * @param constant -> value of each int item
 * @param intChain -> underlying list
 */
public record ConstantField<T>(int length, T constant, ArrayList<T> intChain) implements Field<T> {

    /**
     * Ctor - with 2 parameters
     * @param length of chain
     * @param constant value of elements
     */
    public ConstantField(int length, T constant){
        this(length, constant, new ArrayList<>());
    }

    /**
     * Ctor - create list and fill with values
     * @param length of chain
     * @param constant value of elements
     * @param intChain -> filled by this ctor
     * @throws IllegalArgumentException when length is negative
     */
    public ConstantField(int length, T constant, ArrayList<T> intChain){

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
    public T at(int index) {
        return intChain.get(index);
    }
}
