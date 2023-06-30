package edu.hm.gaertner.simon.lab23.b13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetPingPong {
    private static int PORT = 7008;

    private static boolean stopped;

    public static void main(String... args) {
        final boolean serverside = args.length == 0;
        try(ServerSocket serverSocket = new ServerSocket(PORT  + (serverside? 0 : 1));
            Socket socket = serverside? serverSocket.accept(): new Socket("", PORT); // 1

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {

            if (serverside){
                outputStream.write(0);// 5
                outputStream.flush();
            }

            System.out.println("connection from: " + socket.getRemoteSocketAddress());

            int message = inputStream.read(); // 2

            while(!stopped) {
                System.out.println("received: " + message);
                message++;
                System.out.println("sending:  " + message);

                outputStream.write(message); // 3
                outputStream.flush();

                message = inputStream.read();// 4
            }

            System.out.println("client disconnected");

        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}
