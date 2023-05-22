import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/** Pipeline transformiert 1 Datum, nicht 2 oder mehr.
 */
public class PrimeFactors {
    public static void main(String... args) {
        int number = args.length > 0? Integer.parseInt(args[0]): 2*3*7*7;

        List<Integer> factors = null;
        factors = new ArrayList<>();
        int rest = number;
        int maybeFactor = 2;

        while(rest > 1) {
            if(rest%maybeFactor == 0) {
                factors.add(maybeFactor);
                rest /= maybeFactor;
            }
            else
                maybeFactor++;
        }

        System.out.println(factors);
    }
}
