
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientITF extends Remote {
    public boolean insert(Class_CauThu ct) throws RemoteException;

    public String show() throws RemoteException;

    public Class_CauThu search(String MaCT) throws RemoteException;

    public double sum(int sotran, String ma_ct) throws RemoteException;
}
