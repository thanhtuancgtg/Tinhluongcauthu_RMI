
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static String TieuDe() {
        String s = "";
        s += String.format("|%-10s|%-15s|%-10s|%-15s|%-20s|", "Ma CT", "Ten CT", "Nam Sinh", "Vi Tri CT", "Luong CB");
        return s;
    }

    public static void main(String[] args) {
        try {
            // ClientILP cli = new ClientILP();

            Registry req = LocateRegistry.getRegistry(9999);
            ClientITF cli = (ClientITF) req.lookup("KTTH");

            String menu = "\tMENU\n1 - Hien Thi Danh Sach Cau Thu\n2 - Them Cau Thu Moi Vao Danh Sach\n3 - Tinh Luong Thang Cau Thu\n4 - Thoat\n---------------------------------\nHay chon phuong thuc: ";
            Scanner in = new Scanner(System.in);
            Scanner nhap = new Scanner(System.in);
            String line;
            Class_CauThu ct;
            while (true) {
                System.out.print(menu);
                line = in.nextLine();
                switch (line) {
                    case "1":
                        System.out.println("Danh sach cau thu nhu sau :");
                        System.out.println(TieuDe());
                        System.out.println(cli.show()); // goi ham`
                        break;
                    case "2":
                        ct = new Class_CauThu();
                        System.out.print("Moi nhap ma cau thu: ");
                        ct.setMa(nhap.nextLine());

                        System.out.print("Moi nhap ho ten cau thu: ");
                        ct.setTen(nhap.nextLine());

                        System.out.print("Moi nhap nam sinh cau thu: ");
                        ct.setNamSinh(nhap.nextInt());
                        nhap.nextLine();

                        System.out.println("Moi nhap vi tri thi dau cau thu: ");
                        System.out.println("1. Tien dao");
                        System.out.println("2. Tien ve");
                        System.out.println("3. Hau ve");
                        System.out.println("4. Thu mon");
                        System.out.print("Lua chon: ");
                        int c = nhap.nextInt();
                        if (c == 1)
                            ct.setViTri("Tien dao");
                        else if (c == 2)
                            ct.setViTri("Tien ve");
                        else if (c == 3)
                            ct.setViTri("Hau ve");
                        else
                            ct.setViTri("Thu mon");

                        System.out.print("Moi nhap luong co ban: ");
                        ct.setLuongCB(nhap.nextFloat());
                        nhap.nextLine();

                        // goi ham
                        if (cli.insert(ct)) {
                            System.out.println("Ban Da Them Cau Thu Thanh Cong !");
                        } else {
                            System.out.println("Cau Thu Da Ton Tai !");
                        }
                        break;
                    case "3":
                        ct = new Class_CauThu();
                        int sotran = 0;
                        double tien = 0;

                        System.out.print("Nhap ma cau thu can tinh: ");
                        String maCT = nhap.nextLine();

                        Class_CauThu search = cli.search(maCT);
                        if (search != null) {
                            System.out.print("Nhap vao so tran dau trong thang: ");
                            sotran = nhap.nextInt();
                            nhap.nextLine();

                            tien = cli.sum(sotran, maCT);
                            System.out.println(
                                    "Luong thang cua " + search.getTen() + " la: " + tien);

                        } else {
                            System.out.println("Cau thu khong ton tai !");
                        }
                        break;
                    case "4":
                        System.exit(1);
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ban da nhap sai lenh");
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("Khong the ket noi Server");
        }
    }
}
