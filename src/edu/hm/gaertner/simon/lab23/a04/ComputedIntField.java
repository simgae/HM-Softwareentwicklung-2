package edu.hm.gaertner.simon.lab23.a04;

import edu.hm.cs.rs.se.ss23.a04.IntAt;
import edu.hm.cs.rs.se.ss23.a04.IntField;

import java.util.ArrayList;

/**
 * IntField with calculated values by computer.
 * @param computer -> calculates the different values
 * @param length -> length of list
 * @param intChain -> underlying chain
 */
public record ComputedIntField(IntAt computer, int length, ArrayList<Integer> intChain) implements IntField {

    /**
     * Ctor - for user.
     * @param computer -> calculate the values
     * @param length -> length of list
     */
    public ComputedIntField(IntAt computer, int length){
        this(computer, length, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param computer -> calculate the values of the list
     * @param length -> length of the list
     * @param intChain -> underlying chain
     */
    public ComputedIntField(IntAt computer, int length, ArrayList<Integer> intChain){
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
    public int at(int index) {
        return intChain().get(index);
    }
}
