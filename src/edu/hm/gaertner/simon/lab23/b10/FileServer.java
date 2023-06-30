package edu.hm.gaertner.simon.lab23.b10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String... args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1234)) { // 1

            while (true) {

                try (Socket socket = serverSocket.accept(); // 2

                     InputStream inputStream = socket.getInputStream(); // 3
                     InputStreamReader reader = new InputStreamReader(inputStream);
                     BufferedReader bufferedReader = new BufferedReader(reader);

                     OutputStream outputStream = socket.getOutputStream()) { // 4

                    System.out.println("connection from: " + socket.getRemoteSocketAddress());
                    String filename = bufferedReader.readLine(); // 5

                    try (InputStream fileInputStream = new FileInputStream(filename)) {
                        fileInputStream.transferTo(outputStream); // 6
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
            }
        }
    }
}
