package edu.hm.gaertner.simon.lab23.a06;

import java.util.ArrayList;

/**
 * Reverse IntField chain.
 * @param backing -> old IntField
 * @param intChain -> underlying chain
 */
public record ReverseField<T>(Field<T> backing, ArrayList<T> intChain) implements Field<T> {

    /**
     * Ctor - for user.
     * @param backing -> old IntField which should be reversed
     */
    public ReverseField(Field<T> backing){
        this(backing, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param backing -> old IntField which should be reversed
     * @param intChain -> underlying chain
     */
    public ReverseField(Field<T> backing, ArrayList<T> intChain){
        this.backing = backing;
        this.intChain = intChain;

        for (int index = 0; index < backing.length(); index++) {
            this.intChain.add(0, backing.at(index));
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
