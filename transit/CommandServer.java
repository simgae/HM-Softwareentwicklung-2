import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {
    public static void main(String... args) throws IOException, InterruptedException {
        try(ServerSocket serverSocket = null) { // 1
            while(true)
                try(// 2 - wie FileServer
                    ) {
                    System.out.println("connection from: " + socket.getRemoteSocketAddress());
                    while(true) {
                        outputStream.write(": ".getBytes());
                        outputStream.flush();

                        String command = null; // 3
                        final Runtime runtime = Runtime.getRuntime();
                        final Process process = null; // 4
                        process.waitFor();
                        try(InputStream fromProcess = null) { // 5
                            // 6
                        }
                    }
                } catch(IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
