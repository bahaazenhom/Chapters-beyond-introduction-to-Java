package Chapter_40;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterWithRMIServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            StudentServerInterface object = new StudentServerInterfaceImpl();
            registry.bind("StudentServerInterfaceImpl", object);
            System.out.println("Student Server " + object + " registered");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}

