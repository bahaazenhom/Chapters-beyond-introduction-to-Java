package Chapter_33;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientAsksArea {
    public static DataOutputStream toServer = null;
    public static DataInputStream fromServer = null;

    public static void main(String[] args) throws Exception {
        connectToServer();
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                double radius = input.nextDouble();
                toServer.writeDouble(radius);
                double area = fromServer.readDouble();
                System.out.println("The area received from the server is " + area);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connectToServer() throws Exception {
        try {
            Socket socket = new Socket("localhost", 8080);
            toServer = new DataOutputStream(socket.getOutputStream());
            toServer.flush();
            fromServer = new DataInputStream(socket.getInputStream());

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
