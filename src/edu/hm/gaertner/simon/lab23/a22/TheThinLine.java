package edu.hm.gaertner.simon.lab23.a22;

import edu.hm.cs.rs.se.ss23.Xmark;
import edu.hm.cs.rs.se.ss23.a22.ThinLine;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Task 2.2.
 * @param <E> generic parameter.
 *           Basic idea of the implementation:
 *              One list with all the index and a second one with the values.
 *              So on index one in index list you have the index of index one in the nonDefaultValue list.
 *              When you want to load an element at one index you have to search it into index list, pick the index in that list
 *              and search on that index in the nonDefaultValue list.
 *
 *              The lists have the same length at any time. Otherwise, you have to many indexes for values or vice versa.
 */
@Xmark("a22")
public class TheThinLine<E> implements ThinLine<E> {

    /**
     * Default value.
     */
    private final E defaultValue;

    /**
     * List with non default values.
     */
    private final List<E> nonDefaultValues;

    /**
     * List with indexes of default values.
     */
    private final List<Integer> index;

    /**
     * Ctor when user will define default value.
     * @param value - default value
     */
    public TheThinLine(E value) {
        this.defaultValue = value;
        this.index = new ArrayList<>();
        this.nonDefaultValues = new ArrayList<>();
    }

    /**
     * Default Ctor -> default value null.
     */
    public TheThinLine() {
        this(null);
    }

    @Override
    public void replace(int index, E value) {
        if (checkIfDefaultValue(index)) {

            final int indexInList = getIndex().indexOf(index);
            getNonDefaultValues().set(indexInList, value);

        } else
            insert(index, value);

        if (value.equals(getDefaultValue())) {
            delete(index);
        }


    }

    @Override
    public void insert(int index, E value) {

        int listIndex = getIndex().size();

        for (int currentIndex : getIndex()) {
            if (index <= currentIndex) {
                listIndex = getIndex().indexOf(currentIndex);
                getIndex().set(listIndex, currentIndex + 1);
            }

        }


        getIndex().add(listIndex, index);
        getNonDefaultValues().add(listIndex, value);


    }


    @Override
    public E read(int index) {

        E result = getDefaultValue();

        if (checkIfDefaultValue(index)) {
            final int listIndex = getIndex().indexOf(index);
            result = getNonDefaultValues().get(listIndex);

        }

        return result;
    }

    @Override
    public E delete(int index) {

        E result = getDefaultValue();

        if (checkIfDefaultValue(index)) {
            final int listIndex = getIndex().lastIndexOf(index);
            getIndex().remove(listIndex);
            result = getNonDefaultValues().remove(listIndex);

            for (int currentIndex : getIndex()) {

                // This Mutation failure can not be solved, because it makes no difference between < and <=.
                // This is because the index can not be identical (because auf insert and replace method).
                // So you can use < and <= and it makes no difference :).
                if (index <= currentIndex) {
                    final int secondListIndex = getIndex().indexOf(currentIndex);
                    getIndex().set(secondListIndex, currentIndex - 1);
                }
            }

        }


        return result;
    }

    @Override
    public int lastAt() {

        int result = -1;

        final int lastListIndex = getIndex().size() - 1;

        if (lastListIndex >= 0)
            result = getIndex().get(lastListIndex);

        return result;
    }

    /**
     * Check if this index is default or not.
     * @param index of element
     * @return true if -> non default / false if default
     */
    private boolean checkIfDefaultValue(int index) {
        return getIndex().contains(index);
    }

    /**
     * Getter for default value.
     * @return default value.
     */
    public E getDefaultValue() {
        return defaultValue;
    }

    /**
     * Getter for index list.
     * @return - index of non default values > list format
     */
    public List<Integer> getIndex() {
        return index;
    }

    /**
     * Getter for value list.
     * @return - non default values > list format
     */
    public List<E> getNonDefaultValues() {
        return nonDefaultValues;
    }
}
