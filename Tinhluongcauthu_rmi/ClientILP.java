
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ClientILP extends UnicastRemoteObject implements ClientITF {

    HashMap<String, Class_CauThu> data = new HashMap<String, Class_CauThu>();

    public ClientILP() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public boolean insert(Class_CauThu ct) throws RemoteException {
        // TODO Auto-generated method stub
        if (!data.containsKey(ct.getMa())) {
            data.put(ct.getMa(), ct);
            return true;
        }
        return false;
    }

    public String show() throws RemoteException {
        // TODO Auto-generated method stub
        String tmp = "";
        for (Class_CauThu ct : data.values()) {
            tmp += ct.toString() + "\n";
        }
        return tmp;
    }

    @Override
    public Class_CauThu search(String ma) throws RemoteException {
        // TODO Auto-generated method stub
        if (data.containsKey(ma)) {
            return data.get(ma);
        }
        return null;
    }

    @Override
    public double sum(int sotran, String ma_ct) throws RemoteException {
        // sotran = 0;
        Class_CauThu cts = new Class_CauThu();
        cts = search(ma_ct);
        // TODO Auto-generated method stub
        for (Class_CauThu ct : data.values()) {
            if (data.get(cts.getMa()) != null) {
                if (cts.getViTri().equalsIgnoreCase("Tien dao")) {
                    return sotran * (0.025 * cts.getLuongCB()) + cts.getLuongCB();
                } else if (cts.getViTri().equalsIgnoreCase("Tien ve")
                        || cts.getViTri().equalsIgnoreCase("Hau ve")) {
                    return sotran * (0.02 * cts.getLuongCB()) + cts.getLuongCB();
                } else {
                    return sotran * (0.015 * cts.getLuongCB()) + cts.getLuongCB();
                }
            } else {
                return 0;
            }
        }
        return sotran;
    }
}
