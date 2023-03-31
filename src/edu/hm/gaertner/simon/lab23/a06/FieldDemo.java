package edu.hm.gaertner.simon.lab23.a06;

/** Funktion, der die natuerlichen Zahlen liefert.
 * @version 2023-03-22
 */
record Naturals<T>() implements At<T> {
    /**
     * {@return Ein natuerliche Zahl.}
     *
     * @param index Wie viele natuerliche Zahlen vor dieser stehen.
     */
    @Override public T value(int index) {return (T) "index + 1";}
}

/** Demoprogramm.
 * Praktikum SE2, SS2023 (Schiedermeier).
 */
public class FieldDemo {
    public static void main(String... args) {
        Field c = new ConstantField(10, "TEST");
        System.out.println(c.at(5)); // 1
        // System.out.println(c.at(10)); // IndexOutOfBoundsException
        System.out.println("---------------------------");

        Field a = new AtField(c, 2, "TESTING");
        System.out.println(a.at(1)); // 1
        System.out.println(a.at(2)); // 2
        System.out.println(a.at(3)); // 1
        System.out.println("---------------------------");

        Field r = new ReverseField(a);
        System.out.println(r.at(8)); // 1
        System.out.println(r.at(7)); // 2
        System.out.println(a.at(7)); // 1, weil a immutable ist
        System.out.println("---------------------------");

        Field cp = new ComputedField(new Naturals<String>(), 10);

        System.out.println(cp.at(0)); // 1
        System.out.println(new ReverseField(cp).at(0)); // 10
    }
}
