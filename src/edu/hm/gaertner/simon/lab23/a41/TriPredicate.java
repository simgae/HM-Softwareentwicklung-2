package edu.hm.gaertner.simon.lab23.a41;

/**
 * Check three parameters for a condition. - Functional Interface
 * @param <T> type of this three parameters.
 */
@FunctionalInterface
public interface TriPredicate<T> {

    /**
     * Check three parameters for a condition.
     * @param fst - 1. parameter
     * @param snd - 2. parameter
     * @param trd - 3. parameter
     * @return true if condition is met - false if not
     */
    boolean test(T fst, T snd, T trd);
}
