import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class BlockWrite {
    public static void main(String... args) throws IOException {
        String tempfileName = Path.of(System.getProperty("java.io.tmpdir")).resolve("zero").toString();
        int totalChars = 1 << 28; // ~256 MByte

            int blocksize = 1;
            int numBlocks = totalChars/blocksize;
            char[] block = new char[blocksize];
            long startMillis = System.currentTimeMillis();
            try(FileWriter tempfile = new FileWriter(tempfileName)) {
                for(int blocksWritten = 0; blocksWritten < numBlocks; blocksWritten++)
                    tempfile.write(block);
            }
            System.out.println("blocksize: " + blocksize);
            System.out.println("elapsed: " + (System.currentTimeMillis() - startMillis));
    }
}
