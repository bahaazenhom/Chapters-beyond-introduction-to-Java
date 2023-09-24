package Chapter_33;

import java.io.*;
import java.net.*;

public class MultiThreadServerComputeArea {
    static int visitors = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                while (true) {
                    Socket socket = serverSocket.accept();
                    visitors++;
                    InetAddress inetAddress = socket.getInetAddress();
                    System.out.println("Visitor number " + visitors + ", Client: " + inetAddress.getHostName() + " Connected to the server");
                    Thread thread = new Thread(new HandleClient(socket, inetAddress));
                    thread.start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }

    static class HandleClient implements Runnable {
        private Socket socket;
        private InetAddress inetAddress;

        HandleClient(Socket socket, InetAddress inetAddress) {
            this.socket = socket;
            this.inetAddress = inetAddress;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    double radius = inputFromClient.readDouble();
                    System.out.println("Radius received from client: " + inetAddress.getHostName() + " is " + radius);
                    double area = radius * radius * Math.PI;
                    outputToClient.writeDouble(area);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
