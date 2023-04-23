package edu.hm.gaertner.simon.lab23.a31;

import edu.hm.cs.rs.se.ss23.Xmark;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Mono Set. Contains only one element. All other elements are for this set duplicates.
 * @param <T> Object which should be saved in that set.
 */
@Xmark("a31")
public class MonoSet <T> extends AbstractSet<T>{

    /**
     * One and only value in this set.
     */
    private T value;

    /**
     * Ctor - initialize value with null.
     */
    public MonoSet(){
        this.value = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MonoSetIterator<>(getValue());
    }

    @Override
    public int size() {
        return Objects.isNull(getValue()) ? 0 : 1;
    }

    @Override
    public boolean add(T value){
        boolean result = false;

        if (Objects.isNull(getValue())){
            setValue(value);
            result = true;
        }

        return result;
    }

    @Override
    public boolean remove(Object value){

        boolean result = false;

        if(!Objects.isNull(getValue()) && getValue().equals(value)){
            setValue(null);
            result = true;
        }

        return result;
    }

    /**
     * private getter for value of set.
     * @return first and only value of this MonoSet.
     */
    private T getValue() {
        return value;
    }

    /**
     * private setter for value of set.
     * @param value new value.
     */
    private void setValue(T value) {
        this.value = value;
    }

}

/**
 * Class for Iterator about MonoSet.
 * @param <T> Object in MonoSet.
 */
class MonoSetIterator<T> implements Iterator<T>{

    /**
     * Value of MonoSet.
     */
    private final T value;

    /**
     * Length of MonoSet -> Default 1.
     * Limits the iterator for only one run.
     */
    private int length;

    /**
     * Ctor for MonoSet Iterator.
     * @param value of MonoSet.
     */
    MonoSetIterator(T value){
        this.value = value;

        this.length = 1;
    }

    @Override
    public boolean hasNext() {
        return getLength() == 1 && Objects.nonNull(getValue());
    }

    @Override
    public T next() {
        setLength();
        return getValue();
    }

    /**
     * private getter for value.
     * @return value of monoSet.
     */
    private T getValue() {
        return value;
    }

    /**
     * private getter for length of monoSet.
     * @return length.
     */
    private int getLength() {
        return length;
    }

    /**
     * private setter for length.
     * Can only set to value 0!
     */
    private void setLength() {
        this.length = 0;
    }
}


