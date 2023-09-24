package Chapter_33;

import java.net.*;
import java.util.*;
import java.io.*;

public class StudentClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8000);
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                String name = input.next(),
                        street = input.next(),
                        city = input.next(),
                        state = input.next(),
                        zip = input.next();
                StudentAddress studentAddress = new StudentAddress(name, street, city, state, zip);
                toServer.writeObject(studentAddress);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
