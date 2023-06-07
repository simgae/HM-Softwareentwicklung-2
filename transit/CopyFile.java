import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String... args) throws IOException {
        String fromFilename = args[0];
        String toFilename = args[1];
        FileReader reader = new FileReader(fromFilename);
        FileWriter writer = new FileWriter(toFilename);
        int code = reader.read();
        while(code >= 0) {
            writer.write(code);
            code = reader.read();
        }
    }
}
