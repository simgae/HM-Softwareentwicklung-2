import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;

public class PipedPingPong {
    record Bouncer() implements Runnable {
        @Override public void run() {
            try {
                while(true) {
                    int code = 0;
                    System.out.println(Thread.currentThread().getName() + ": received " + code);
                    code++;
                    System.out.println(Thread.currentThread().getName() + ": sent " + code);
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String... args) throws IOException, InterruptedException {
        Thread ping = new Thread(new Bouncer(), "ping");
        Thread pong = new Thread(new Bouncer(), "pong");

        ping.start();
        pong.start();

        Thread.sleep(Long.MAX_VALUE);
    }
}
