package edu.hm.gaertner.simon.lab23.a44;

import java.util.List;

/**
 * Demo class for list ops.
 */
public class ListOpsDemo {

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
