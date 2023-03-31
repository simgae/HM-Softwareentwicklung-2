package edu.hm.gaertner.simon.lab23.a04;

import edu.hm.cs.rs.se.ss23.a04.IntField;

import java.util.ArrayList;

/**
 * Reverse IntField chain.
 * @param backing -> old IntField
 * @param intChain -> underlying chain
 */
public record ReverseIntField(IntField backing, ArrayList<Integer> intChain) implements IntField{

    /**
     * Ctor - for user.
     * @param backing -> old IntField which should be reversed
     */
    public ReverseIntField(IntField backing){
        this(backing, new ArrayList<>());
    }

    /**
     * Ctor.
     * @param backing -> old IntField which should be reversed
     * @param intChain -> underlying chain
     */
    public ReverseIntField(IntField backing, ArrayList<Integer> intChain){
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
    public int at(int index) {
        return intChain().get(index);
    }
}
