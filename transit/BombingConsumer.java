package p623;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-21
 */
@FunctionalInterface interface BombingConsumer<T> {
    void accept(T arg) throws Exception;

    static <U> Consumer<U> tunnel(BombingConsumer<U> bomber) {
        return arg -> {
            try {
                bomber.accept(arg);
            } catch(Exception exception) {
                throw new RuntimeException(exception);
            }
        };
    }
}

@FunctionalInterface interface BombingFunction<T, R> {
    R apply(T arg) throws Exception;

    static <U, V> Function<U, V> tunnel(BombingFunction<U, V> bomber) {
        return arg -> {
            try {
                return bomber.apply(arg);
            } catch(Exception exception) {
                throw new RuntimeException(exception);
            }
        };
    }
}
