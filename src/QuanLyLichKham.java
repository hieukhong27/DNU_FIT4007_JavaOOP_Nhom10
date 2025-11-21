import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyLichKham {

    private ArrayList<LichKham> danhSachLich;

    public QuanLyLichKham() {
        danhSachLich = new ArrayList<>();
    }

    // Kiểm tra trùng lịch
    private boolean isConflict(String maBS, LocalDate ngay, LocalTime gio) {
        for (LichKham l : danhSachLich) {
            if (l.getMaBS().equals(maBS) && l.getNgayKham().equals(ngay) && l.getGioKham().equals(gio)) {
                return true;
            }
        }
        return false;
    }

    // Đặt lịch
    public void datLich(Scanner sc) {
        System.out.print("Mã lịch: ");
        String maLich = sc.nextLine();

        System.out.print("Mã bệnh nhân: ");
        String maBN = sc.nextLine();

        System.out.print("Mã bác sĩ: ");
        String maBS = sc.nextLine();

        System.out.print("Ngày khám(year-month-day): ");
        LocalDate ngay = LocalDate.parse(sc.nextLine());

        System.out.print("Giờ khám(hour-minute): ");
        LocalTime gio = LocalTime.parse(sc.nextLine());

        if (isConflict(maBS, ngay, gio)) {
            System.out.println("Lịch khám trùng với lịch khác. Vui lòng chọn giờ khác.");
            return;
        }

        LichKham lich = new LichKham(maLich, maBN, maBS, ngay, gio);
        danhSachLich.add(lich);
        System.out.println("Đặt lịch thành công!");
    }

    // Hiển thị tất cả lịch
    public void hienThiDanhSach() {
        if (danhSachLich.isEmpty()) {
            System.out.println("Danh sách lịch trống!");
        } else {
            for (LichKham l : danhSachLich) {
                l.hienThi();
            }
        }
    }

    // Cập nhật trạng thái lịch
    public void capNhatTrangThai(Scanner sc) {
        System.out.print("Nhập mã lịch: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (LichKham l : danhSachLich) {
            if (l.getMaLich().equals(ma)) {
                System.out.print("Nhập trạng thái (SCHEDULED / COMPLETED / CANCELLED): ");
                String tt = sc.nextLine().toUpperCase();
                l.setTrangThai(LichKham.TrangThai.valueOf(tt));
                System.out.println("Cập nhật trạng thái thành công!");
                found = true;
                break;
            }
        }

        if (!found) System.out.println("Không tìm thấy lịch.");
    }

    // Danh sách bệnh nhân khám trong 1 ngày cụ thể
    public void dsBenhNhanTheoNgay(Scanner sc) {
        System.out.print("Nhập ngày (yyyy-MM-dd): ");
        LocalDate ngay = LocalDate.parse(sc.nextLine());
        boolean found = false;

        for (LichKham l : danhSachLich) {
            if (l.getNgayKham().equals(ngay)) {
                System.out.println("BN: " + l.getMaBN() + " | BS: " + l.getMaBS() +
                        " | Giờ: " + l.getGioKham() + " | Trạng thái: " + l.getTrangThai());
                found = true;
            }
        }

        if (!found) System.out.println("Không có bệnh nhân nào khám trong ngày này.");
    }
}
