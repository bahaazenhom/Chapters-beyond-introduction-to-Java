package Chapter_33;

import java.io.*;
import java.net.*;

public class ServerComputeArea {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Socket socket = serverSocket.accept();
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                InetAddress inetAddress = socket.getInetAddress(); // to have the client information like host name and host address etc...
                System.out.println(inetAddress.getHostName() + "\n" + inetAddress.getHostAddress());
                InetAddress inetAddressByName = InetAddress.getByName("www.google.com"); // we can also have information just by putting the name of any ip.
                System.out.println(inetAddressByName.getHostName() + "\n" + inetAddressByName.getHostAddress());
                while (true) {
                    double radius = inputFromClient.readDouble();
                    double area = radius * radius * Math.PI;
                    outputToClient.writeDouble(area);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }
}
