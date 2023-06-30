package edu.hm.gaertner.simon.lab23.b11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {
    public static void main(String... args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(1234)) { // 1
            while(true)
                try(Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    OutputStream outputStream = socket.getOutputStream()) {

                    System.out.println("connection from: " + socket.getRemoteSocketAddress());

                    while(true) {

                        outputStream.write(": ".getBytes());
                        outputStream.flush();

                        String command = bufferedReader.readLine(); // 3

                        final Runtime runtime = Runtime.getRuntime();
                        final Process process = runtime.exec(command); // 4
                        process.waitFor();

                        try(InputStream fromProcess = process.getInputStream()) { // 5
                            fromProcess.transferTo(outputStream); // 6
                        }

                    }
                } catch(IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
