package edu.hm.gaertner.simon.lab23.a71;

import java.io.FileReader;
import java.io.IOException;

public class CharLineCount {
    public static void main(String... args) throws IOException {
        int chars = 0;
        int words = 0;
        int lines = 0;

        try(FileReader reader = new FileReader("CharLineCount.java")){
            int code = reader.read();
            while(code >= 0) {

                chars++;

                if(code == '\n')
                    lines++;

                if(Character.isWhitespace(code))
                    words++;

                code = reader.read();
            }
        }

        System.out.println(chars);
        System.out.println(words);
        System.out.println(lines);
    }
}
