import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionReader
{
    public CollectionReader(Collection<Character> collection) {
    }

    public static void main(String... args) throws IOException {
        try(FileWriter writer = new FileWriter("abc.txt");
            Reader reader = new CollectionReader(List.of('a', 'b', 'c'))) {
            reader.transferTo(writer);
        }
    }
}
