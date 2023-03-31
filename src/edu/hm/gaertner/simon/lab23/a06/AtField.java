package edu.hm.gaertner.simon.lab23.a06;

import java.util.ArrayList;

/**
 * Copy backing but remove when value at the given index is equal to values that element at that index.
 * @param backing -> old IntField
 * @param index -> index of element
 * @param value -> values at that index
 * @param intChain -> underlying list
 */
public record AtField<T>(Field<T> backing, int index, T value, ArrayList<T> intChain) implements Field<T> {

    /**
     * Ctor for user -> giving input.
     * @param backing -> old list
     * @param index -> index of the element which should be deleted
     * @param value -> value at that index
     */
    public AtField(Field<T> backing, int index, T value){
        this(backing, index, value, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param backing -> old list
     * @param index -> index of the element which should be deleted
     * @param value -> value at that index
     * @param intChain -> underlying list -> index removed
     */
    public AtField(Field<T> backing, int index, T value, ArrayList<T> intChain){
        this.index = index;
        this.value = value;
        this.intChain = intChain;
        this.backing = backing;

        for (int currentElement = 0; currentElement < backing.length(); currentElement++) {
            final T currentValue = backing.at(currentElement);
            this.intChain.add(currentValue);
        }

        this.intChain.set(index, value);
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
