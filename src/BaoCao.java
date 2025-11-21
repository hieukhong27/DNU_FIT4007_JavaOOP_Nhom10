import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class BaoCao {
    // 1. Báo cáo doanh thu theo ngày
    public static void doanhThuTheoNgay(ArrayList<HoaDon> danhSachHD) {
        HashMap<LocalDate, Double> doanhThu = new HashMap<>();

        for (HoaDon hd : danhSachHD) {
            LocalDate ngay = hd.getNgayLap();
            double tong = hd.tinhTongChiPhi();
            doanhThu.put(ngay, doanhThu.getOrDefault(ngay, 0.0) + tong);
        }

        System.out.println("--- Doanh thu theo ngày ---");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate ngay : doanhThu.keySet()) {
            System.out.println("Ngày: " + ngay.format(f) + " | Doanh thu: " + doanhThu.get(ngay));
        }
    }

    // 2. Báo cáo danh sách bệnh nhân điều trị dài hạn
    public static void dsBenhNhanDaiHan(ArrayList<LichKham> danhSachLich) {
        HashMap<String, Integer> soLuot = new HashMap<>();
        for (LichKham l : danhSachLich) {
            if (l.getTrangThai() == LichKham.TrangThai.SCHEDULED || l.getTrangThai() == LichKham.TrangThai.COMPLETED) {
                soLuot.put(l.getMaBN(), soLuot.getOrDefault(l.getMaBN(), 0) + 1);
            }
        }

        System.out.println("--- Danh sách bệnh nhân điều trị dài hạn (>= 3 lượt khám) ---");
        for (String maBN : soLuot.keySet()) {
            if (soLuot.get(maBN) >= 3) {  // có >= 3 lượt khám coi là dài hạn
                System.out.println("Bệnh nhân: " + maBN + " | Số lượt khám: " + soLuot.get(maBN));
            }
        }
    }
}
