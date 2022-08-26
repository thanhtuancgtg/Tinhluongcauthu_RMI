
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        try {
            ClientILP cli = new ClientILP();

            LocateRegistry.createRegistry(9999);
            Registry req = LocateRegistry.getRegistry(9999);

            req.bind("KTTH", cli);

            System.out.println("Server is listening....");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
