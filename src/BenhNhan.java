import java.util.Scanner;

public class BenhNhan {
    private String maBN;
    private String tenBN;
    private int tuoi;
    private String diaChi;
    private String sdt;

    public BenhNhan(String maBN, String tenBN, int tuoi, String diaChi, String sdt) {
        this.maBN = maBN;
        this.tenBN = tenBN;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // GETTER
    public String getMaBN() {
        return maBN;
    }
    public String getTenBN() {
        return tenBN;
    }
    public int getTuoi() {
        return tuoi;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getSdt() {
        return sdt;
    }

    // SETTER
    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Xuất thông tin
    public void hienThi() {
        System.out.println("Mã BN: " + maBN +
                " | Tên: " + tenBN +
                " | Tuổi: " + tuoi +
                " | Địa chỉ: " + diaChi +
                " | SĐT: " + sdt);
    }

    // Nhập bệnh nhân (trả về đối tượng)
    public static BenhNhan nhapBenhNhan() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã bệnh nhân: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tên bệnh nhân: ");
        String ten = sc.nextLine();

        int Tuoi;
        while (true) {
            try {
                System.out.print("Tuổi của bệnh nhân: ");
                Tuoi = Integer.parseInt(sc.nextLine());

                if (Tuoi < 0) {
                    System.out.println("Tuổi không được âm. Nhập lại!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Tuổi phải là số nguyên. Nhập lại!");
            }
        }

        System.out.print("Nhập địa chỉ: ");
        String dc = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();

        return new BenhNhan(ma, ten, Tuoi, dc, sdt);
    }
}
