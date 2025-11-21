import java.time.LocalDate;
import java.time.LocalTime;

public class LichKham {

    public enum TrangThai {
        SCHEDULED, COMPLETED, CANCELLED
    }

    private String maLich;
    private String maBN;
    private String maBS;
    private LocalDate ngayKham;
    private LocalTime gioKham;
    private TrangThai trangThai;

    public LichKham(String maLich, String maBN, String maBS, LocalDate ngayKham, LocalTime gioKham) {
        this.maLich = maLich;
        this.maBN = maBN;
        this.maBS = maBS;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.trangThai = TrangThai.SCHEDULED;
    }

    // GETTER
    public String getMaLich() {
        return maLich;
    }
    public String getMaBN() {
        return maBN;
    }
    public String getMaBS() {
        return maBS;
    }
    public LocalDate getNgayKham() {
        return ngayKham;
    }
    public LocalTime getGioKham() {
        return gioKham;
    }
    public TrangThai getTrangThai() {
        return trangThai;
    }

    // SETTER
    public void setTrangThai(TrangThai tt) {
        this.trangThai = tt;
    }

    // Hiển thị thông tin lịch khám
    public void hienThi() {
        System.out.println("Mã lịch: " + maLich +
                " | BN: " + maBN +
                " | BS: " + maBS +
                " | Ngày: " + ngayKham +
                " | Giờ: " + gioKham +
                " | Trạng thái: " + trangThai);
    }
}
