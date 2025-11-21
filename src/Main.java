import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BenhNhan> danhSachBN = new ArrayList<>();
        ArrayList<Doctor> danhSachBS = new ArrayList<>();
        QuanLyLichKham ql = new QuanLyLichKham();
        ArrayList<DichVu> danhSachDV = new ArrayList<>();
        ArrayList<HoaDon> danhSachHD = new ArrayList<>();
        ArrayList<LichKham> danhSachLich = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ HỒ SƠ BỆNH NHÂN VÀ LỊCH KHÁM =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xem danh sách bệnh nhân");
            System.out.println("3. Tìm bệnh nhân theo mã");
            System.out.println("4. Xóa bệnh nhân");
            System.out.println("5. Sửa thông tin bệnh nhân");
            System.out.println("6. Thêm bác sĩ");
            System.out.println("7. Hiển thị danh sách bác sĩ");
            System.out.println("8. Tìm bác sĩ theo chuyên khoa");
            System.out.println("9. Thống kê số lượt khám theo bác sĩ");
            System.out.println("10. Đặt lịch khám");
            System.out.println("11. Hiển thị danh sách lịch khám");
            System.out.println("12. Cập nhật trạng thái lịch khám");
            System.out.println("13. Danh sách bệnh nhân khám trong 1 ngày");
            System.out.println("14. Thêm dịch vụ y tế");
            System.out.println("15. Hiển thị danh sách dịch vụ");
            System.out.println("16. Tạo hóa đơn và tính chi phí");
            System.out.println("17. Xuất hóa đơn ra CSV");
            System.out.println("18. Báo cáo doanh thu theo ngày");
            System.out.println("19. Danh sách bệnh nhân điều trị dài hạn");

            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {

                case 1:
                    System.out.println("\n--- Thêm bệnh nhân mới ---");
                    BenhNhan bn = BenhNhan.nhapBenhNhan();
                    danhSachBN.add(bn);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.println("\n--- Danh sách bệnh nhân ---");
                    if (danhSachBN.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (BenhNhan b : danhSachBN) {
                            b.hienThi();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Tìm bệnh nhân theo mã ---");
                    System.out.print("Nhập mã: ");
                    String ma = sc.nextLine();
                    boolean found = false;

                    for (BenhNhan b : danhSachBN) {
                        if (b.getMaBN().equalsIgnoreCase(ma)) {
                            b.hienThi();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy!");
                    break;

                case 4:
                    System.out.println("\n--- Xóa bệnh nhân ---");
                    System.out.print("Nhập mã bệnh nhân: ");
                    String maXoa = sc.nextLine();

                    boolean removed = danhSachBN.removeIf(b -> b.getMaBN().equalsIgnoreCase(maXoa));
                    if (removed) System.out.println("Đã xóa thành công!");
                    else System.out.println("Không tìm thấy bệnh nhân!");
                    break;

                case 5:
                    System.out.println("\n--- Sửa thông tin bệnh nhân ---");
                    System.out.print("Nhập mã bệnh nhân: ");
                    String maSua = sc.nextLine();

                    BenhNhan sua = null;
                    for (BenhNhan b : danhSachBN) {
                        if (b.getMaBN().equalsIgnoreCase(maSua)) {
                            sua = b;
                            break;
                        }
                    }

                    if (sua == null) {
                        System.out.println("Không tìm thấy bệnh nhân!");
                    } else {
                        System.out.print("Tên mới: ");
                        sua.setTenBN(sc.nextLine());

                        int tuoi;
                        while (true) {
                            System.out.print("Nhập tuổi: ");
                            try {
                                tuoi = Integer.parseInt(sc.nextLine());
                                if (tuoi > 0) break;
                                else System.out.println("Tuổi phải lớn hơn 0. Nhập lại!");
                            } catch (Exception e) {
                                System.out.println("Tuổi phải là số. Nhập lại!");
                            }
                        }

                        System.out.print("Địa chỉ mới: ");
                        sua.setDiaChi(sc.nextLine());

                        System.out.print("Số điện thoại mới: ");
                        sua.setSdt(sc.nextLine());

                        System.out.println(" Cập nhật thành công!");
                    }
                    break;

                case 6:
                    System.out.println("--- Thêm bác sĩ ---");
                    Doctor bs = Doctor.nhapDoctor();
                    danhSachBS.add(bs);
                    System.out.println(" Thêm thành công!");
                    break;

                case 7:
                    System.out.println("--- Danh sách bác sĩ ---");
                    if (danhSachBS.isEmpty()) System.out.println("Danh sách trống!");
                    else for (Doctor d : danhSachBS) d.hienThi();
                    break;

                case 8: {
                    System.out.println("--- Tìm bác sĩ theo chuyên khoa ---");
                    System.out.print("Nhập chuyên khoa: ");
                    String ck = sc.nextLine();
                    boolean foundCK = false;
                    for (Doctor d : danhSachBS) {
                        if (d.getChuyenKhoa().equalsIgnoreCase(ck)) {
                            d.hienThi();
                            foundCK = true;
                        }
                    }
                    if (!foundCK) System.out.println(" Không tìm thấy bác sĩ của chuyên khoa này");
                    break;
                }

                case 9:
                    System.out.println("--- Thống kê số lượt khám theo bác sĩ ---");
                    for (Doctor d : danhSachBS) {
                        System.out.println(d.getTenBS() + " | Số lượt khám: " + d.getSoLuotKham());
                    }
                    break;
                case 10:
                    System.out.println("--- Đặt lịch khám ---");
                    ql.datLich(sc);
                    break;

                case 11:
                    System.out.println("--- Danh sách lịch khám ---");
                    ql.hienThiDanhSach();
                    break;

                case 12:
                    System.out.println("--- Cập nhật trạng thái lịch khám ---");
                    ql.capNhatTrangThai(sc);
                    break;

                case 13:
                    System.out.println("--- Danh sách bệnh nhân khám theo ngày ---");
                    ql.dsBenhNhanTheoNgay(sc);
                    break;
                case 14:
                    DichVu dv = DichVu.nhapDichVu(sc);
                    danhSachDV.add(dv);
                    System.out.println("Thêm dịch vụ thành công!");
                    break;

                case 15:
                    System.out.println("--- Danh sách dịch vụ ---");
                    for (DichVu d : danhSachDV) d.hienThi();
                    break;

                case 16:
                    System.out.print("Mã hóa đơn: ");
                    String maHD = sc.nextLine();
                    System.out.print("Mã bệnh nhân: ");
                    String maBN = sc.nextLine();

                    HoaDon hd = new HoaDon(maHD, maBN);

                    System.out.println("Chọn dịch vụ để thêm vào hóa đơn (nhập mã DV, kết thúc nhập '0'):");
                    while (true) {
                        String maDV = sc.nextLine();
                        if (maDV.equals("0")) break;

                        boolean foundCK = false;
                        for (DichVu d : danhSachDV) {
                            if (d.getMaDV().equals(maDV)) {
                                hd.themDichVu(d);
                                foundCK = true;
                                System.out.println("Thêm dịch vụ " + d.getTenDV());
                                break;
                            }
                        }
                        if (!foundCK) System.out.println("Không tìm thấy dịch vụ.");
                    }

                    hd.hienThi();
                    break;

                case 17:
                    System.out.print("Mã hóa đơn: ");
                    String maHDCSV = sc.nextLine();
                    System.out.print("Mã bệnh nhân: ");
                    String maBNCSV = sc.nextLine();

                    HoaDon hdCSV = new HoaDon(maHDCSV, maBNCSV);
                    // Lấy tất cả dịch vụ (ví dụ minh họa)
                    for (DichVu d : danhSachDV) hdCSV.themDichVu(d);

                    hdCSV.xuatCSV("hoadon.csv");
                    break;
                case 18:
                    BaoCao.doanhThuTheoNgay(danhSachHD);
                    break;
                case 19:
                    BaoCao.dsBenhNhanDaiHan(danhSachLich);
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println("Chọn sai! Vui lòng nhập lại.");
            }
        }
    }
}
