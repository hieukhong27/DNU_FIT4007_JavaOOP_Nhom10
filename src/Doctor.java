import java.util.Scanner;

public class Doctor {
    private String maBS;
    private String tenBS;
    private String chuyenKhoa;
    private String sdt;
    private int soLuotKham; // để thống kê số lượt khám

    public Doctor(String maBS, String tenBS, String chuyenKhoa, String sdt) {
        this.maBS = maBS;
        this.tenBS = tenBS;
        this.chuyenKhoa = chuyenKhoa;
        this.sdt = sdt;
        this.soLuotKham = 0;
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
    public String getSdt() {
        return sdt;
    }
    public int getSoLuotKham() {
        return soLuotKham;
    }

    // SETTER
    public void setTenBS(String tenBS) {
        this.tenBS = tenBS;
    }
    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void tangLuotKham() {
        this.soLuotKham++;
    }

    // Hiển thị
    public void hienThi() {
        System.out.println("Mã BS: " + maBS + " | Tên: " + tenBS +
                " | Chuyên khoa: " + chuyenKhoa +
                " | SĐT: " + sdt +
                " | Số lượt khám: " + soLuotKham);
    }

    // Nhập bác sĩ mới
    public static Doctor nhapDoctor() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã bác sĩ: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tên bác sĩ: ");
        String ten = sc.nextLine();

        System.out.print("Nhập chuyên khoa: ");
        String ck = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();

        return new Doctor(ma, ten, ck, sdt);
    }
}
