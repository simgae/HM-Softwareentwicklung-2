import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharLineCount {
    public static void main(String... args) throws IOException {
        FileReader reader = new FileReader("CharLineCount.java");
        int chars = 0;
        int words = 0;
        int lines = 0;
        int code = reader.read();
        while(code >= 0) {
            code = reader.read();
        }
        System.out.println(chars);
        System.out.println(words);
        System.out.println(lines);
    }
}
