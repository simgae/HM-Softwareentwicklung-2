/** Funktion, der die natuerlichen Zahlen liefert.
 * @version 2023-03-22
 */
record Naturals() implements IntAt {
    /** {@return Ein natuerliche Zahl.}
     * @param index Wie viele natuerliche Zahlen vor dieser stehen.
     */
    @Override public int value(int index) {return index + 1;}
}

/** Demoprogramm.
 * Praktikum SE2, SS2023 (Schiedermeier).
 */
public class IntFieldDemo {
    public static void main(String... args) {
        IntField c = new ConstantIntField(10, 1);
        System.out.println(c.at(5)); // 1
        System.out.println(c.at(10)); // IndexOutOfBoundsException

        IntField a = new AtIntField(c, 2, 2);
        System.out.println(a.at(1)); // 1
        System.out.println(a.at(2)); // 2
        System.out.println(a.at(3)); // 1

        IntField r = new ReverseIntField(a);
        System.out.println(r.at(8)); // 1
        System.out.println(r.at(7)); // 2
        System.out.println(a.at(7)); // 1, weil a immutable ist

        IntField cp = new ComputedIntField(new Naturals(), 10);
        System.out.println(cp.at(0)); // 1
        System.out.println(new ReverseIntField(cp).at(0)); // 10
    }
}
