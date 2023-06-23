package edu.hm.gaertner.simon.lab23.a91;

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


        try(InputStream inputStream = new FileInputStream(input.fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, input.charset);
            OutputStream outputStream = new FileOutputStream(output.fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, output.charset)){

            inputStreamReader.transferTo(outputStreamWriter);

        }
    }
}
