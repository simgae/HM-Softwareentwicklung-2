package edu.hm.gaertner.simon.lab23.a75;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionReader extends Reader{

    private final Iterator<Character> iterator;

    public CollectionReader(Collection<Character> collection) {
        this.iterator = collection.iterator();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {

        int index = 0;

        while (off < len && iterator.hasNext()){
            cbuf[index] = iterator.next();
            index++;
        }

        return index;
    }

    @Override
    public void close(){
    }

    public static void main(String... args) throws IOException {
        try(FileWriter writer = new FileWriter("abc.txt");
            Reader reader = new CollectionReader(List.of('a', 'b', 'c'))) {

            char[] letters = new char[3];

            System.out.println(reader.read(letters, 0 , 3));
            System.out.println(letters);

            // reader.transferTo(writer);
        }
    }
}
