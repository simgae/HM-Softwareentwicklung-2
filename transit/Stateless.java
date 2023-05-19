import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stateless {
    public static void main(String... args) {
        final long startMillis = System.currentTimeMillis();
        final int elements = 1_000_000_000;
        long numEven = 0;
//        {
//            int[] array = new int[elements];
//            for (int i = 0; i < elements; i++)
//                array[i] = i;
//
//            numEven = 0;
//            for (int i = 0; i < elements; i++)
//                if (array[i] % 2 == 0)
//                    numEven++;
//
//            System.out.println(numEven);
//        }
//        {
//            numEven = Stream.iterate(0, n -> n + 1)
//                    .limit(elements)
//                    .filter(m -> m % 2 == 0)
//                    .count();
//        }
        {
            numEven = IntStream.iterate(0, n -> n < elements,n -> n + 1)
                    .parallel()
                    .filter(m -> m % 2 == 0)
                    .count();
        }
        System.out.println(numEven);
        System.out.println(System.currentTimeMillis() - startMillis);
    }
}
