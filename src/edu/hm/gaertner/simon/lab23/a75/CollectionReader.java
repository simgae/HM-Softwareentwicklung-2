package edu.hm.gaertner.simon.lab23.a75;

import java.io.*;
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

        int index = off;
        int copyOff = off;

        while (index < len && iterator.hasNext()){
            if(index >= copyOff){
                cbuf[index] = iterator.next();
                index++;
            } else{
                copyOff--;
                iterator.next();
            }
        }

        return index - off;
    }

    @Override
    public void close(){
    }

    public static void main(String... args) throws IOException {
        try(Reader reader = new CollectionReader(List.of('a', 'b', 'c'))) {

            char[] letters = new char[3];

            System.out.println(reader.read(letters, 0, 3));
            System.out.println(letters);
        }
    }
}
