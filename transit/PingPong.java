class Bouncer extends Thread {
    private final String message;

    public Bouncer(String message) {
        this.message = message;
    }

    @Override public void run() {
        while(true)
            System.out.println(message);
    }
}

/** Startet Threads, die Interrupts austauschen
 * @version 2023-06-01
 */
public class PingPong {
    public static void main(String... args) {
        Bouncer ping = new Bouncer("ping");
        Bouncer pong = new Bouncer("pong");

        ping.start();
        pong.start();

    }
}
