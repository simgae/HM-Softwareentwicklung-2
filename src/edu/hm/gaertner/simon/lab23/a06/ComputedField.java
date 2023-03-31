package edu.hm.gaertner.simon.lab23.a06;

import java.util.ArrayList;

/**
 * IntField with calculated values by computer.
 * @param computer -> calculates the different values
 * @param length -> length of list
 * @param intChain -> underlying chain
 */
public record ComputedField<T>(At<T> computer, int length, ArrayList<T> intChain) implements Field<T> {

    /**
     * Ctor - for user.
     * @param computer -> calculate the values
     * @param length -> length of list
     */
    public ComputedField(At<T> computer, int length){
        this(computer, length, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param computer -> calculate the values of the list
     * @param length -> length of the list
     * @param intChain -> underlying chain
     */
    public ComputedField(At<T> computer, int length, ArrayList<T> intChain){
        this.computer = computer;
        this.length = length;
        this.intChain = intChain;

        for (int index = 0; index < length; index++) {
            this.intChain.add(computer.value(index));
        }
    }

    @Override
    public int length() {
        return intChain().size();
    }

    @Override
    public T at(int index) {
        return intChain().get(index);
    }
}
