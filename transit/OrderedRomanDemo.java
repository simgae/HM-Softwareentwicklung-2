import edu.hm.cs.rs.se.ss23.a31.MonoSet;
import edu.hm.cs.rs.se.ss23.a32.Roman;
import java.util.Set;
import java.util.TreeSet;

/** Demoanwendung fuer geordnete Romans.
 * @version 2023-04-17
 */
public class OrderedRomanDemo {
    /**
     * Entry point.
     * @param args Kommandozeilenargumente: keine.
     */
    public static void main(String... args) {
        {
            OrderedRoman one = new OrderedRoman(1);
            OrderedRoman onceMore = new OrderedRoman(1);
            System.out.println(one.equals(onceMore)); // true

            Set<OrderedRoman> tsor = new TreeSet<>();
            for(int n = 10; n > 1; n--)
                tsor.add(new OrderedRoman(n/2));
            System.out.println(tsor.size()); // 5
            System.out.println(tsor.iterator().next().equals(one)); // true

            MonoSet<OrderedRoman> msr = new MonoSet<>();
            msr.add(one);
            System.out.println(msr.contains(onceMore)); // true
        }
        {
            Set<Roman> tsr = new TreeSet<>(new RomanLexicalOrder());
            for(int n = 10; n >= 1; n--)
                tsr.add(new OrderedRoman(n));
            for(Roman roman : tsr)
                System.out.println(roman.text()); // I, II, III, IV, IX, V, VI, VII, VIII, X
        }
        {
            Set<Roman> tsr = new TreeSet<>(new RomanTextLengthOrder());
            for(int n = 10; n >= 1; n--)
                tsr.add(new OrderedRoman(n));
            for(Roman roman : tsr)
                System.out.println(roman.text()); // X, IX, VII, VIII
        }
        {
            Set<Roman> tsr = new TreeSet<>(new RomanByFactors());
            for(int n = 10; n > 1; n--)
                tsr.add(new OrderedRoman(n));
            for(Roman roman : tsr)
                System.out.println(roman.text()); // II, III, V, VII, IV, VI, IX, X, VIII
        }
    }
}
