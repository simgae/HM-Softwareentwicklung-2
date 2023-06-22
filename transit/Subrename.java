package p623;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-21
 */
public class Subrename {
    public static void main(String... args) throws IOException {
        String from = args[0];
        if(from.isEmpty())
            throw new IllegalArgumentException("cannot replace empty substring");
        String into = args[1];

    }

}
