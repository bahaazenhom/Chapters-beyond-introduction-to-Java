package Chapter_40;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class StudentServerInterfaceImpl extends UnicastRemoteObject implements StudentServerInterface {
    private HashMap<String, Double> scores = new HashMap<>();
    public StudentServerInterfaceImpl() throws RemoteException{
        initializeStudent();
    }

    private void initializeStudent() {
        scores.put("John", 90.5);
        scores.put("Michael", 100.0);
        scores.put("Michelle", 98.5);
    }

    @Override
    public double findScore(String name) throws RemoteException {
        Double score = scores.get(name);
        if(score == null) {
            System.out.println("Student "+name+" is not found");
            return -1;
        }
        System.out.println("Student "+name+" /'s score is "+score);
        return score;
    }
}
