import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetPingPong {
    private final static int PORT = 7008;

    private static boolean stopped;

    public static void main(String... args) throws IOException {
        final boolean serverside = args.length == 0;
        try(ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = null; // 1
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            // 5
            System.out.println("connection from: " + socket.getRemoteSocketAddress());
            int message = 0; // 2
            while(!stopped) {
                System.out.println("received: " + message);
                message++;
                System.out.println("sending:  " + message);
                // 3
                // 4
            }
            System.out.println("client disconnected");
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}
