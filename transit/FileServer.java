import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String... args) throws IOException {
        try(ServerSocket serverSocket = null) { // 1
            while(true)
                try(Socket socket = null; // 2
                    InputStream inputStream = null; // 3
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    OutputStream outputStream = null) { // 4
                    System.out.println("connection from: " + socket.getRemoteSocketAddress());
                    String filename = null; // 5
                    try(InputStream fileInputStream = new FileInputStream(filename)) {
                        // 6
                    }
                } catch(IOException e) {
                    throw new RuntimeException(e);

                }
        }
    }
}
