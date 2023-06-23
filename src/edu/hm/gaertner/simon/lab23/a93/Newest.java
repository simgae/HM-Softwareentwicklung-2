package edu.hm.gaertner.simon.lab23.a93;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Newest {
    public static void main(String[] args) throws IOException {
        try(Stream<Path> pathStream = Files.walk(Path.of(args[0]))){
            pathStream.filter(Files::isRegularFile)
                    .sorted((o1, o2) -> {
                        try {
                            if (Files.getLastModifiedTime(o1).toMillis() >  Files.getLastModifiedTime(o2).toMillis())
                                return -1;
                            else if (Files.getLastModifiedTime(o1).toMillis() == Files.getLastModifiedTime(o2).toMillis())
                                return 0;
                            else
                                return 1;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .limit(10)
                    .forEach(System.out::println);
        }
    }
}
