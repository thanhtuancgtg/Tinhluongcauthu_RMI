
import java.io.Serializable;
import java.text.DecimalFormat;

public class Class_CauThu implements Serializable {
    String ma_ct;
    String ten;
    int nam_sinh;
    String vitri_thidau;
    float luong_coban;

    public Class_CauThu() {

    }

    public Class_CauThu(String ma_ct, String ten, int nam_sinh, String vitri_thidau, float luong_coban) {
        super();
        this.ma_ct = ma_ct;
        this.ten = ten;
        this.nam_sinh = nam_sinh;
        this.vitri_thidau = vitri_thidau;
        this.luong_coban = luong_coban;
    }

    public String getMa() {
        return ma_ct;
    }

    public void setMa(String ma_ct) throws Exception {
        if (!ma_ct.isEmpty()) {
            this.ma_ct = ma_ct;
        } else {
            throw new Exception("ERROR");
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return nam_sinh;
    }

    public void setNamSinh(int nam_sinh) {
        this.nam_sinh = nam_sinh;
    }

    public String getViTri() {
        return vitri_thidau;
    }

    public void setViTri(String vitri_thidau) {
        this.vitri_thidau = vitri_thidau;
    }

    public float getLuongCB() {
        return luong_coban;
    }

    public void setLuongCB(float luong_coban) throws Exception {
        if (luong_coban > 0) {
            this.luong_coban = luong_coban;
        } else {
            throw new Exception("Salary > 0");
        }
    }

    DecimalFormat df = new DecimalFormat("#,###.000 VND");

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String s = "";
        s += String.format("|%-10s|%-15s|%-10s|%-15s|%-20s|", getMa(), getTen(), getNamSinh(), getViTri(),
                df.format(getLuongCB()));
        return s;
    }
}
