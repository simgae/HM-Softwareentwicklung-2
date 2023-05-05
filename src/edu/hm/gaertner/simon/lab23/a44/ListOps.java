package edu.hm.gaertner.simon.lab23.a44;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * List operations.
 *
 * @param elements for list.
 * @param <T>      type of elements.
 */
public record ListOps<T>(List<T> elements) {

    /**
     * Create a ctor - to copy transmitted list - prevent aliasing.
     *
     * @param elements elements for list.
     */
    public ListOps(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    /**
     * Disable getter for elements.
     *
     * @return noting.
     */
    public List<T> elements() {
        throw new RuntimeException();
    }

    /**
     * Do operation on elements after start index.
     *
     * @param startIndex define where the operation should start.
     * @param operator   - operation on elements.
     * @return result of operation.
     */
    public T fold(int startIndex, BinaryOperator<T> operator) {

        T result = null;
        T fst = null;

        if (startIndex < elements.size()) {
            fst = elements.get(startIndex);
            result = fst;
        }
        if (startIndex < elements.size() - 1) {
            final T snd = elements.get(startIndex + 1);
            result = operator.apply(fst, snd);
        }


        for (int index = startIndex + 2; index < elements.size(); index++) {
            result = operator.apply(result, elements.get(index));
        }

        return result;

    }

    /**
     * Apply a list of functions on one variable.
     *
     * @param operator List of functions. -> return a list
     * @return ListOps with all results.
     */
    public ListOps<T> spread(Function<T, List<T>> operator) {
        final List<T> result = new ArrayList<>();

        for (T element : elements) {
            result.addAll(operator.apply(element));
        }

        return new ListOps<>(result);
    }

    /**
     * Move the content in one list to another index.
     *
     * @param operator - define the movement.
     * @return new list with the moved parameters.
     */
    public ListOps<T> moved(BinaryOperator<Integer> operator) {

        final List<T> storage = new ArrayList<>(elements);

        for (T element : elements) {
            storage.set(operator.apply(elements.size(), elements.indexOf(element)), element);
        }

        return new ListOps<T>(storage);

    }


    /**
     * Check how many items match one criteria.
     *
     * @param amount   - how many items should match.
     * @param operator - criteria.
     * @return yes if the amount of matched items are equal to the enum amount.
     */
    public boolean are(Which amount, Predicate<T> operator) {
        boolean result;
        int counter = 0;

        for (T element : elements) {
            result = operator.test(element);
            if (result)
                counter++;

        }

        if (amount.equals(Which.ALL) && counter == elements.size())
            result = true;
        else if (amount.equals(Which.SOME) && counter > 0)
            result = true;
        else
            result = amount.equals(Which.NONE) && counter == 0;


        return result;
    }

}

/**
 * Demo class to test ListOps.
 */
@SuppressWarnings({"PMD", "CHECKSTYLE"})
class ListOpsDemo {

    /**
     * Main method for testing.
     *
     * @param args - arguments.
     */
    public static void main(String[] args) {
        final ListOps<Integer> lops = new ListOps<>(List.of(1, 2, 3, 4, 5));
        System.out.println(lops.fold(0, (x, y) -> x + y));  // 15 = Summe der Elemente
        System.out.println(lops.fold(1, (x, y) -> x * y));  // 120 = Produkt der Elemente

        System.out.println("__________________________________________________");


        final ListOps<String> test1 = new ListOps<>(List.of("Abra", "ka", "dabra"));
        final ListOps<String> p = test1.spread(x -> List.of(x.substring(0, 1), x.substring(1)));
        System.out.println(p); // [A, bra, k, a, d, abra]
        System.out.println(p.spread(x -> x.length() > 1 ? List.of(x) : List.of())); // [bra, abra]

        System.out.println("__________________________________________________");

        final ListOps<Integer> test2 = new ListOps<>(List.of(1, 2, 3, 4, 5, 6));

        System.out.println(test2.moved((length, index) -> length - 1 - index));  // [6, 5, 4, 3, 2, 1]

        System.out.println(test2.moved((length, index) -> (index + 1) % length));  // 6, 1, 2, 3, 4, 5

        System.out.println(test2.moved((length, index) -> index % 2 == 0 ? (index + 1) % length : (index + length - 1) % length));  // 2, 1, 4, 3, 6, 5

        System.out.println(test2.moved((length, index) -> (index + length / 2) % length));  // 4, 5, 6, 1, 2, 3

        System.out.println("__________________________________________________");
        final ListOps<Integer> test3 = new ListOps<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(test3.are(Which.ALL, x -> x > 0)); // true
        System.out.println(test3.are(Which.NONE, x -> x == 5)); // false
        System.out.println(test3.are(Which.SOME, x -> x == 5)); // true
    }
}
