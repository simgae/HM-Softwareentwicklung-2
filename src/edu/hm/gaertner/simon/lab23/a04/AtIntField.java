package edu.hm.gaertner.simon.lab23.a04;

import edu.hm.cs.rs.se.ss23.a04.IntField;

import java.util.ArrayList;

/**
 * Copy backing but remove when value at the given index is equal to number that element at that index.
 * @param backing -> old IntField
 * @param index -> index of element
 * @param number -> number at that index
 * @param intChain -> underlying list
 */
public record AtIntField(IntField backing, int index, int number, ArrayList<Integer> intChain) implements IntField {

    /**
     * Ctor for user -> giving input.
     * @param backing -> old list
     * @param index -> index of the element which should be deleted
     * @param number -> value at that index
     */
    public AtIntField(IntField backing, int index, int number){
        this(backing, index, number, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param backing -> old list
     * @param index -> index of the element which should be deleted
     * @param number -> value at that index
     * @param intChain -> underlying list -> index removed
     */
    public AtIntField(IntField backing, int index, int number, ArrayList<Integer> intChain){
        this.index = index;
        this.number = number;
        this.intChain = intChain;
        this.backing = backing;

        for (int currentElement = 0; currentElement < backing.length(); currentElement++) {
            final int value = backing.at(currentElement);
            this.intChain.add(value);
        }

        this.intChain.set(index, number);
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
