package Chapter_40;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentServerInterface extends Remote {
    public double findScore(String name) throws RemoteException;
}
