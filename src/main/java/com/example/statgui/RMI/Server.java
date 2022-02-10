package sample;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try{
            CalculatorRemote calc = new CalculatorRemote();
            LocateRegistry.createRegistry(8000);
            Naming.rebind("rmi://localhost:8000/remoteCalculator",calc);
            System.out.println("server running");
        }
        catch(Exception ex){
            
        }
    }

}
