package edu.hm.gaertner.simon.lab23.a61;

import java.util.List;
import java.util.Random;

/**
 * Laborpraktikum Threads, Interrupts.
 *
 * @version 2023-05-30
 */

public class Stop1st {
    /**
     * Systemzeit beim Programmstart.
     */
    private final static long START_MILLIS = System.currentTimeMillis();

    /**
     * Verbraucht CPU-Zeit.
     *
     * @param work Anzahl Millisekunden.
     */
    record Worker(int work, Thread mainThread) implements Runnable {
        /**
         * Rechnet die festgesetzte Zeit.
         */
        @Override
        public void run() {
            System.out.println("working: " + work);

            boolean done = false;

            while (!done && !Thread.currentThread().isInterrupted()) {
                done = System.currentTimeMillis() - START_MILLIS > work;
            }

            if(!Thread.currentThread().isInterrupted())
                System.out.println("completed: " + work);
            else
                System.out.println("interrupted: " + work);

            mainThread.interrupt();
        }
    }

    /**
     * Startet eine Anzahl Threads, die jeweils eine zufaellige Zeit rechnen.
     */
    public static void main(String... args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();

        List<Thread> workers = new Random().ints(10, 2_000, 10_000)
                .mapToObj(n -> new Worker(n, mainThread))
                .map(Thread::new)
                .toList();

        workers.forEach(Thread::start);
        System.out.println("workers started");

        try {
            mainThread.join();
        } catch (InterruptedException e) {
            workers.forEach(Thread::interrupt);
            System.out.println("interrupted");
        }

        System.out.println("all workers done!");
    }
}
