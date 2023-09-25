package Chapter_33.Exercises;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    static DataInputStream fromServer;
    static DataOutputStream toServer;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        connectToServer();
        new Thread(() -> {
            try {
                while (true) System.out.println("Server: " + fromServer.readUTF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        while (input.hasNext()) toServer.writeUTF(input.nextLine());
    }

    public static void connectToServer() throws Exception {
        try {
            Socket socket = new Socket("localhost", 8090);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
