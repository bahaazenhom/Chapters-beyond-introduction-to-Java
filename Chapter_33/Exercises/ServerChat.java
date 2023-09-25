package Chapter_33.Exercises;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            Socket socket = serverSocket.accept();
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream fromClient = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) System.out.println("Client: " + fromClient.readUTF());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }).start();

            while (input.hasNext()) toClient.writeUTF(input.nextLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
