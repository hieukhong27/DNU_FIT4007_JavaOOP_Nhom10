import java.util.Scanner;

public class DichVu {

    private String maDV;
    private String tenDV;
    private double chiPhi;

    public DichVu(String maDV, String tenDV, double chiPhi) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.chiPhi = chiPhi;
    }

    // GETTER
    public String getMaDV() {
        return maDV;
    }
    public String getTenDV() {
        return tenDV;
    }
    public double getChiPhi() {
        return chiPhi;
    }

    // Hiển thị dịch vụ
    public void hienThi() {
        System.out.println("Mã DV: " + maDV + " | Tên: " + tenDV + " | Chi phí: " + chiPhi);
    }

    // Nhập dịch vụ mới
    public static DichVu nhapDichVu(Scanner sc) {
        System.out.print("Nhập mã dịch vụ: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tên dịch vụ: ");
        String ten = sc.nextLine();

        double cp;
        while (true) {
            System.out.print("Nhập chi phí: ");
            try {
                cp = Double.parseDouble(sc.nextLine());
                if (cp >= 0) break;
                else System.out.println("Chi phí phải >= 0. Nhập lại!");
            } catch (Exception e) {
                System.out.println("Chi phí phải là số. Nhập lại!");
            }
        }

        return new DichVu(ma, ten, cp);
    }
}
