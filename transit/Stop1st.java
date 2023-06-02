import java.util.List;
import java.util.Random;

/** Laborpraktikum Threads, Interrupts.
 * @version 2023-05-30
 */

1 - Worker erwartet main-Thread fuer Rueckmeldung
2 - Worker mit main-Thread initialisieren
3 - Worker schicken am Ende Interrupt an main
4 - main wartet auf ersten Interrupt; Busy waiting, schlecht
5 - main wartet auf ersten Interrupt, besser
6 - main schickt Inerrupt an alle Worker
7 - Worker stoppt wenn fertig *oder* Interrupt
8 - Worker gibt aus completed oder interrupted

public class Stop1st {
    /** Systemzeit beim Programmstart. */
    private final static long START_MILLIS = System.currentTimeMillis();

    /** Verbraucht CPU-Zeit.
     * @param work Anzahl Millisekunden.
     */
    record Worker(int work) implements Runnable {
        /** Rechnet die festgesetzte Zeit.
         */
        @Override public void run() {
            System.out.println("working: " + work);
            boolean done = false;
            while(!done)
                done = System.currentTimeMillis() - START_MILLIS > work;
            System.out.println("completed: " + work);
        }
    }

    /** Startet eine Anzahl Threads, die jeweils eine zufaellige Zeit rechnen.
     */
    public static void main(String... args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();
        List<Thread> workers = new Random().ints(10, 2_000, 10_000)
                .mapToObj(Worker::new)
                .map(Thread::new)
                .toList();

        workers.forEach(Thread::start);
        System.out.println("workers started");
    }
}
