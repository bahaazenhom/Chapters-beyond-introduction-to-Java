package Chapter_33;

import java.net.*;
import java.util.*;
import java.io.*;

public class StudentServer {
    public static ObjectOutputStream outputToFile;
    public static ObjectInputStream inputFromClient;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                System.out.println("Server started..");
                outputToFile = new ObjectOutputStream(new FileOutputStream("C:\\Users\\bahaa\\Documents\\Main\\src\\input.txt", true));
                while (true) {
                    Socket socket = serverSocket.accept();
                    inputFromClient = new ObjectInputStream(socket.getInputStream());
                    Object object = inputFromClient.readObject();
                    outputToFile.writeObject(object.toString());
                    System.out.println("A new student object is stored");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }
}
