import java.util.Scanner;

public class BacSi {

    private String maBS;
    private String tenBS;
    private String chuyenKhoa;
    private String lichTruc;
    private String sdt;

    public BacSi(String maBS, String tenBS, String chuyenKhoa, String lichTruc, String sdt) {
        this.maBS = maBS;
        this.tenBS = tenBS;
        this.chuyenKhoa = chuyenKhoa;
        this.lichTruc = lichTruc;
        this.sdt = sdt;
    }

    // GETTER
    public String getMaBS() {
        return maBS;
    }
    public String getTenBS() {
        return tenBS;
    }
    public String getChuyenKhoa() {
        return chuyenKhoa;
    }
    public String getLichTruc() {
        return lichTruc;
    }
    public String getSdt() {
        return sdt;
    }

    // SETTER
    public void setTenBS(String tenBS) {
        this.tenBS = tenBS;
    }
    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }
    public void setLichTruc(String lichTruc) {
        this.lichTruc = lichTruc;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Hiển thị thông tin
    public void hienThi() {
        System.out.println(
                "Mã BS: " + maBS +
                        " | Tên: " + tenBS +
                        " | Chuyên khoa: " + chuyenKhoa +
                        " | Lịch trực: " + lichTruc +
                        " | SĐT: " + sdt
        );
    }

    // Nhập bác sĩ (static)
    public static BacSi nhapBacSi() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã bác sĩ: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tên bác sĩ: ");
        String ten = sc.nextLine();

        System.out.print("Nhập chuyên khoa: ");
        String ck = sc.nextLine();

        System.out.print("Nhập lịch trực (ví dụ: Thứ 2-4-6): ");
        String lt = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();

        return new BacSi(ma, ten, ck, lt, sdt);
    }
}
