import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class HoaDon {

    private String maHD;
    private String maBN;
    private ArrayList<DichVu> dsDichVu;
    private LocalDate NgayLap;

    public HoaDon(String maHD, String maBN) {
        this.maHD = maHD;
        this.maBN = maBN;
        this.dsDichVu = new ArrayList<>();
        this.NgayLap = LocalDate.now();
    }
    public String getMaHD() {
        return maHD;
    }
    public String getMaBN() {
        return maBN;
    }
    public LocalDate getNgayLap() {
        return NgayLap;
    }
    // Thêm dịch vụ vào hóa đơn
    public void themDichVu(DichVu dv) {
        dsDichVu.add(dv);
    }

    // Tính tổng chi phí
    public double tinhTongChiPhi() {
        double tong = 0;
        for (DichVu dv : dsDichVu) tong += dv.getChiPhi();
        return tong;
    }

    // Hiển thị hóa đơn
    public void hienThi() {
        System.out.println("HÓA ĐƠN: " + maHD + " | BN: " + maBN + " | Ngày: " + NgayLap);
        for (DichVu dv : dsDichVu) dv.hienThi();
        System.out.println("Tổng chi phí: " + tinhTongChiPhi());
    }

    // Xuất hóa đơn ra CSV
    public void xuatCSV(String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (DichVu dv : dsDichVu) {
                fw.append(maHD).append(",")
                        .append(maBN).append(",")
                        .append(dv.getMaDV()).append(",")
                        .append(dv.getTenDV()).append(",")
                        .append(String.valueOf(dv.getChiPhi()))
                        .append(",").append(NgayLap.toString())
                        .append("\n");
            }
            System.out.println("Xuất hóa đơn ra CSV thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi xuất CSV: " + e.getMessage());
        }
    }
}
