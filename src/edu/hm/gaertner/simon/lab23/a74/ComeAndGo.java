package edu.hm.gaertner.simon.lab23.a74;

import java.io.Closeable;

public record ComeAndGo() implements Closeable {
    public ComeAndGo {
        System.out.println("Oh, hi, it's you!");
    }

    void talk(String message) {
        System.out.println(message + " - that's nice :)");
    }

    @Override
    public void close() {
        System.out.println("Farewell!");
    }
}

class ComeAndGoMain {
    public static void main(String... args) {

        try(ComeAndGo comeAndGo = new ComeAndGo()){
            comeAndGo.talk("hello!");
        }
    }
}
