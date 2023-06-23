package edu.hm.gaertner.simon.lab23.a91;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hexdump {
    public static void main(String... args) throws IOException {
        byte[] content = Files.readAllBytes(Path.of(args[0]));
        int dumped = 0;
        for(int bite : content) {
            System.out.printf("%02X ", bite & 0xFF);
            dumped++;
            if(dumped%16 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
