package Chapter_40;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class StudentServerInterfaceClient {
    private static StudentServerInterface student;
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        initializeRMI();

        System.out.println("Enter the student name: ");
        String name = input.next();
        getScore(name);

    }
    private static void getScore(String name){
        try{
            double studentScore = student.findScore(name);
            if(studentScore < 0) System.out.println("Not found");
            else System.out.println("The student score is: "+studentScore);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    protected static void initializeRMI() throws Exception {
        String host = "";
        try {
            Registry registry = LocateRegistry.getRegistry(host);// we can put whatever the host we want.
            student = (StudentServerInterface) registry.lookup("StudentServerInterfaceImpl");
        } catch (Exception e) {
            System.out.println(e+" llllllll");
        }
    }
}
