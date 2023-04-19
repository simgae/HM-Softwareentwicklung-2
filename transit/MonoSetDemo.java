import java.util.List;
import java.util.Set;

/**
 * @version 2023-04-08
 */
public class MonoSetDemo {
    public static void main(String... args) {
        MonoSet<Integer> mi = new MonoSet<>();
        System.out.println(mi.isEmpty()); // true
        System.out.println(mi.add(23)); // true
        System.out.println(mi.add(42)); // false
        System.out.println(mi.remove(23)); // true
        System.out.println(mi.remove(23)); // false

        mi.addAll(List.of(666, -1, 666));
        for(int n: mi)
            System.out.println(n); // 666

        System.out.println(mi.equals(Set.of(666))); // true

        MonoSet<Set<Integer>> msi = new MonoSet<>();
        msi.add(mi); // true
        msi.add(Set.of(666)); // false
    }
}
