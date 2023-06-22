package p623;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-21
 */
public class Recoder {
    public static void main(String... args) throws IOException {
        record FileWithEncoding(String fileName, Charset charset) {
            public FileWithEncoding(String[] words) {
                this(words[0], Charset.forName(words[1]));
            }
        }

        FileWithEncoding input = new FileWithEncoding(args[0].split(":"));
        FileWithEncoding output = new FileWithEncoding(args[1].split(":"));
    }
}
