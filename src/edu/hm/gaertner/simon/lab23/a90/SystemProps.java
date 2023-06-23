package edu.hm.gaertner.simon.lab23.a90;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-22
 */
public class SystemProps {
    public static void main(String... args) {
        System.getProperties()
                .entrySet()
                .stream()
                .map(Object::toString)
                .sorted()
                .forEach(System.out::println);
    }
}
