package edu.hm.gaertner.simon.lab23.a62;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Bouncer extends Thread {
    private final String message;

    private Thread bouncer;

    public Bouncer(String message) {
        this.message = message;
    }

    @Override public void run() {
        int run = 10;
        while(run > 0){
            try{
                join();
            } catch (InterruptedException e){
                System.out.println(message);
                bouncer.interrupt();
                run--;
            }
        }
    }

    public void setBouncer(Thread bouncer) {
        this.bouncer = bouncer;
    }
}

/** Startet Threads, die Interrupts austauschen
 * @version 2023-06-01
 */
public class PingPong {
    public static void main(String... args) {
        /*
        Bouncer ping = new Bouncer("ping");
        Bouncer pong = new Bouncer("pong");
        ping.setBouncer(pong);
        pong.setBouncer(ping);

        ping.interrupt();

        ping.start();
        pong.start();

         */


        List<Bouncer> bouncerList = IntStream.range(0,10)
                .mapToObj(n -> "message " + n)
                .map(Bouncer::new)
                .toList();

        for (int i = 0; i < bouncerList.size(); i++) {
            bouncerList.get(i).setBouncer(bouncerList.get((i+1) % bouncerList.size()));
        }

        bouncerList.forEach(Bouncer::start);
        bouncerList.get(0).interrupt();
    }
}
