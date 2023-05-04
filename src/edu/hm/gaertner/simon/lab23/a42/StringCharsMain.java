package edu.hm.gaertner.simon.lab23.a42;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Refactoring of StringCharsMain original class.
 * @see <a href="https://se.pages.gitlab.lrz.de/2023s/etc/lab/slide0033.html:">...</a>
 */
public class StringCharsMain {

    /**
     * Main method.
     * @param args - arguments - contain text which should be printed.
     */
    public static void main(String... args) {

        final String text = args[0];
        final Supplier<Iterator<Character>> chars = () -> new Iterator<>() {

            /**
             * Current position of iterator.
             */
            private int position;

            @Override
            public boolean hasNext() {
                return position < text.length();
            }

            @Override
            public Character next() {
                final char result = text.charAt(position);
                position++;
                return result;
            }
        };

        for (final Iterator<Character> slowIterator = chars.get(); slowIterator.hasNext(); ) {
            final char slow = slowIterator.next();
            for (final Iterator<Character> fastIterator = chars.get(); fastIterator.hasNext(); ) {
                final char fast = fastIterator.next();
                System.out.println(fast + "/" + slow);
            }
        }
    }
}