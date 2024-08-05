/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;

import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.LoaiSpDao;
import DAO.NhanVienDAO;
import DAO.SanPhamDAo;
import DAO.thongKeDAO;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.LoaiSp;
import Entity.NhanVien;
import Entity.SanPham;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XDate;
import utils.XImage;


import java.io.IOException;

/**
 *
 * @author XUAN TRUONG
 */
public class trangchu extends JFrame {

    Container container;
    JButton btnTrangchu, btnSanpham, btnNhanvien, btnHoadon, btnThongke, btnDangXuat, btnKhachHang,
            btnExit, btnDangNhap, btnChonNgaySinh, btnThemMoi, btnThoat, btnXoa, btnLuu, btnSua, btnDau, btnCuoi, btnTiepTheo,
            btnLuiLai, btnMoi, btnIn, btnXong, btnXuatExcel,btntimKiem;
    JLabel lblUser, lblVaiTro, clock, lbldoiMK, lblHinh, lblhinhSP, lblTDTrang,lblSoLuongThanhVien,lblTongDoanhThu;
    JPanel giaoDienCon,tabCapNhap, tabDanhSach;
    ButtonGroup group, group1, group2;
    JTextField txtMaNhanVien, txtTenNV, txtSDTNhanVien, txtNgaySinh, txtMaHD, txtDonGia, txtSoLuong, txtmaKH, txtThanhTien,
            txtMaSanPham, txtTensanpham, txtKichco, txtDonGiaBan, txtSoLuongSP, txtMaKhachHang, txtTenKhachHang,
            txtSoDienThoaiKhachHang, txtDiaChiKhachHang, txtEmailKhachHang,
            txtTimKiemKhachHang;
    JPasswordField matkhau;
    JTextArea ghiChuSP;
    JTable BangNhanVien, BangHoaDon, bangSanPham, bangKhachHang,BangThongKeSanPham,BangThongKeHoaDon,BangThomgKeKhachHang,BangThongKeDoanhThu;
    JRadioButton rdoNhanVien, rdoQuanLi, rdoKhong, rdoCo, rdoNam, rdoNu;
    JScrollPane scrollNhanVien, scrollHoaDon, scrollSanPham, scrollKhachHang,scThongKeSanPham,crThongKeHoaDon,srThomgKeKhachHang,srThongKeDoanhThu;
    JComboBox cboLoaiSanPham, cboTenSanPham, cbDanhMucSP;
    JCheckBox checkmk;
    JTabbedPane tab;
    JFileChooser fileChooser;
    NhanVienDAO nvDAO = new NhanVienDAO();
    thongKeDAO tkDao= new thongKeDAO();
    public int row = -1;

    public trangchu() {
        giaodien();
        trangchu();
        hoadon();
        nhanvien();
        khachHang();
        thongke();
        Sanpham();
        chucnang();
//        fillToTableNhanVien();
    }

    public void giaodien() {
        container = getContentPane();
        setTitle("NIKE STORE");
        setSize(1400, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //set logo cho phần setitle
        ImageIcon image = new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nike.png");
        setIconImage(image.getImage());

        //thanh menu
        JPanel menu = new JPanel();
        menu.setBorder(new LineBorder(Color.GRAY));
        menu.setLayout(null);
        menu.setBounds(0, 0, 200, 763);
        menu.setBackground(Color.CYAN);

        //logo
        JLabel logo = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nike.png"));
        logo.setBounds(50, 25, 100, 50);

        JLabel nike = new JLabel("NIKE STORE");
        Font font = new Font("Cooper Black", Font.BOLD, 16);
        nike.setFont(font);
        nike.setForeground(Color.BLACK);
        nike.setBounds(50, 65, 150, 50);

        //chức năng 
        JPanel chucnang = new JPanel();
        chucnang.setLayout(null);
        chucnang.setBorder(new LineBorder(Color.GRAY));
        chucnang.setBounds(0, 120, 200, 470);
        chucnang.setBackground(Color.CYAN);

        //trang chủ
        btnTrangchu = new JButton("TRANG CHỦ", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\home.png"));
        btnTrangchu.setBounds(0, 20, 199, 50);
        btnTrangchu.setBackground(Color.YELLOW);

        //nhân viên
        btnNhanvien = new JButton("NHÂN VIÊN", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nhannvien.png"));
        btnNhanvien.setBounds(0, 90, 199, 50);
        btnNhanvien.setBackground(Color.YELLOW);

        //khách hàng
        btnHoadon = new JButton("HÓA ĐƠN", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\hoadon.png"));
        btnHoadon.setBounds(0, 160, 199, 50);
        btnHoadon.setBackground(Color.YELLOW);

        //thống kê
        btnThongke = new JButton("THỐNG KÊ", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\thongke.png"));
        btnThongke.setBounds(0, 240, 199, 50);
        btnThongke.setBackground(Color.yellow);

        //khách hàng
        btnKhachHang = new JButton("KHÁCH HÀNG", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\khachhang.png"));
        btnKhachHang.setBounds(0, 320, 199, 50);
        btnKhachHang.setBackground(Color.YELLOW);

        //sản phẩm
        btnSanpham = new JButton("SẢN PHẨM", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sanpham.png"));
        btnSanpham.setBounds(0, 400, 199, 50);
        btnSanpham.setBackground(Color.YELLOW);

        chucnang.add(btnTrangchu);
        chucnang.add(btnNhanvien);
        chucnang.add(btnHoadon);
        chucnang.add(btnThongke);
        chucnang.add(btnKhachHang);
        chucnang.add(btnSanpham);

        //user
        JPanel user = new JPanel();
        user.setLayout(null);
        user.setBounds(0, 610, 199, 130);
        user.setBackground(Color.YELLOW);
        JLabel maNV = new JLabel("Tên     : ");
        maNV.setBounds(25, 10, 50, 25);
        lblUser = new JLabel();
        lblUser.setBounds(80, 10, 100, 25);
        JLabel vaitro = new JLabel("Vai Trò :");
        vaitro.setBounds(25, 45, 50, 25);
        lblVaiTro = new JLabel("Nhân Viên");
        lblVaiTro.setBounds(80, 45, 100, 25);
        btnDangXuat = new JButton("ĐĂNG XUẤT", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dangxuatt.png"));
        btnDangXuat.setBounds(20, 75, 140, 40);
        btnDangXuat.setBackground(Color.ORANGE);
        if (Auth.isLogin()) {
            lblUser.setText(Auth.user.getTenNV());
            if (Auth.isManager()) {
                lblVaiTro.setText("Quản lý");
            }
            else
            {
                lblVaiTro.setText("Nhân Viên");
            }
        }
        else
        {
            lblUser.setText("");
            lblVaiTro.setText("");
        }
        

        user.add(maNV);
        user.add(lblUser);
        user.add(vaitro);
        user.add(lblVaiTro);
        user.add(btnDangXuat);

        menu.add(logo);
        menu.add(nike);
        menu.add(chucnang);
        menu.add(user);

        //giao diện con bên phải
        giaoDienCon = new JPanel();
        giaoDienCon.setLayout(null);
        giaoDienCon.setBackground(Color.white);
        giaoDienCon.setBounds(200, 50, 1189, 740);
        JLabel logo1 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nikexanh.jpg"));
        logo1.setBounds(100, 200, 550, 500);
        JLabel logo2 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\breabrick.png"));
        logo2.setBounds(690, 140, 500, 500);
        JLabel logo3 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\jodan.png"));
        logo3.setBounds(80, 60, 170, 70);
        JLabel duongke = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\duongke.png"));
        duongke.setBounds(90, 140, 150, 2);
        JLabel nike3 = new JLabel("NIKE STORE");
        nike3.setBounds(110, 150, 150, 25);
        Font nikefont = new Font("Cooper Black", Font.BOLD, 14);
        nike3.setFont(nikefont);

        btnTrangchu.setBackground(Color.WHITE);
        giaoDienCon.add(logo1);
        giaoDienCon.add(logo2);
        giaoDienCon.add(logo3);
        giaoDienCon.add(duongke);
        giaoDienCon.add(nike3);

        //thanh timer
        JPanel timer = new JPanel();
        timer.setLayout(null);
        timer.setBounds(200, 0, 1189, 50);
        timer.setBorder(new LineBorder(Color.GRAY));
        timer.setBackground(Color.WHITE);

        JLabel dongho = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\clock.png"));
        dongho.setBounds(5, 0, 70, 50);
        clock = new JLabel("02:30:54" + "AM");
        clock.setBounds(60, 19, 100, 15);

        //tạo dòng thời gian
        Thread clockThread = new Thread(this::updateClockContinuously);
        clockThread.start();

        btnDangNhap = new JButton("Đăng nhập", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dangnhap.png"));
        btnDangNhap.setBounds(730, 10, 140, 35);
        btnDangNhap.setBackground(Color.WHITE);

        btnExit = new JButton("Thoát", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\thoat.png"));
        btnExit.setBounds(890, 10, 120, 35);
        btnExit.setBackground(Color.WHITE);

        JLabel anh = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\doimatkhau.png"));
        anh.setBounds(1013, 0, 50, 50);
        lbldoiMK = new JLabel("Đổi Mật Khẩu?");
        lbldoiMK.setForeground(Color.BLUE);
        lbldoiMK.setBounds(1060, 15, 150, 25);
        lbldoiMK.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        lbldoiMK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // This method is called when the mouse is clicked on the label
                lbldoiMK.setForeground(Color.RED.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // This method is called when the mouse exits the label
                lbldoiMK.setForeground(Color.BLUE); // Reset the text color
            }
        });

        timer.add(dongho);
        timer.add(clock);
        timer.add(btnDangNhap);
        timer.add(btnExit);
        timer.add(anh);
        timer.add(lbldoiMK);

        container.add(menu);
        container.add(timer);
        container.add(giaoDienCon);
        setVisible(true);
    }

    public void trangchu() {
        btnTrangchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaoDienCon.removeAll();
                JLabel logo1 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nikexanh.jpg"));
                logo1.setBounds(100, 230, 550, 500);
                JLabel logo2 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\breabrick.png"));
                logo2.setBounds(690, 180, 500, 500);
                JLabel logo3 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\jodan.png"));
                logo3.setBounds(80, 30, 170, 70);
                JLabel duongke = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\duongke.png"));
                duongke.setBounds(90, 100, 150, 2);
                JLabel nike3 = new JLabel("NIKE STORE");
                nike3.setBounds(110, 110, 150, 25);
                Font nikefont = new Font("Cooper Black", Font.BOLD, 14);
                nike3.setFont(nikefont);

                giaoDienCon.add(logo1);
                giaoDienCon.add(logo2);
                giaoDienCon.add(logo3);
                giaoDienCon.add(duongke);
                giaoDienCon.add(nike3);

                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.WHITE);
                btnHoadon.setBackground(Color.yellow);
                btnKhachHang.setBackground(Color.yellow);
                btnNhanvien.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.yellow);
                btnThongke.setBackground(Color.yellow);

            }
        });
    }

    //trang nhân viên
    public void nhanvien() {
        btnNhanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaoDienCon.removeAll();
                JLabel qlNhanVien = new JLabel("QUẢN LÍ NHÂN VIÊN");
                qlNhanVien.setBounds(490, -20, 250, 100);
                Font qlNV = new Font("Times new roman", Font.BOLD, 20);
                qlNhanVien.setFont(qlNV);
                qlNhanVien.setForeground(Color.BLUE);

                //nhập thông tin 
                JPanel nhapThongTin = new JPanel();
                nhapThongTin.setLayout(null);
                nhapThongTin.setBounds(0, 60, 1185, 260);
                nhapThongTin.setBorder(new LineBorder(Color.GRAY));
                nhapThongTin.setBackground(Color.WHITE);
                JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
                Font fontChu = new Font("times new roman", Font.BOLD, 16);

                //mã nhân viên
                lblMaNhanVien.setBounds(10, 30, 200, 25);
                lblMaNhanVien.setFont(fontChu);
                txtMaNhanVien = new JTextField();
                txtMaNhanVien.setForeground(Color.red);
                txtMaNhanVien.setFont(fontChu);
                txtMaNhanVien.setBounds(10, 70, 300, 40);

                //tên nhan viên
                JLabel lblTenNhanVien = new JLabel("Tên nhân viên:");
                lblTenNhanVien.setFont(fontChu);
                lblTenNhanVien.setBounds(10, 130, 200, 25);
                txtTenNV = new JTextField();
                txtTenNV.setFont(fontChu);
                txtTenNV.setBounds(10, 170, 300, 40);

                //sdt
                JLabel lblsdt = new JLabel("Email:");
                lblsdt.setFont(fontChu);
                lblsdt.setBounds(380, 30, 200, 25);
                txtSDTNhanVien = new JTextField();
                txtSDTNhanVien.setFont(fontChu);
                txtSDTNhanVien.setBounds(380, 70, 300, 40);

                //mật khẩu
                JLabel lblpass = new JLabel("Mật khẩu:");
                lblpass.setFont(fontChu);
                lblpass.setBounds(380, 130, 300, 40);
                matkhau = new JPasswordField();
                matkhau.setFont(fontChu);
                matkhau.setBounds(380, 170, 300, 40);
                checkmk = new JCheckBox("Xem Mật khẩu");
                checkmk.setBounds(380, 210, 200, 40);
                checkmk.setBackground(Color.WHITE);
                checkmk.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        matkhau.setEchoChar(checkmk.isSelected() ? '\0' : '*');
                    }
                });

                //giới tính
                JLabel lblGioiTinh = new JLabel("Giới tính:");
                lblGioiTinh.setFont(fontChu);
                lblGioiTinh.setBounds(730, 30, 200, 25);
                group2 = new ButtonGroup();
                rdoNam = new JRadioButton("Nam");
                rdoNam.setBackground(Color.WHITE);
                rdoNam.setBounds(730, 70, 100, 40);
                rdoNu = new JRadioButton("Nữ");
                rdoNu.setBackground(Color.WHITE);
                rdoNu.setBounds(850, 70, 100, 40);
                group2.add(rdoNam);
                group2.add(rdoNu);

                //ngày sinh
                JLabel lblNgaySinh = new JLabel("Ngày sinh:");
                lblNgaySinh.setFont(fontChu);
                lblNgaySinh.setBounds(730, 130, 200, 25);
                txtNgaySinh = new JTextField();
                txtNgaySinh.setFont(fontChu);
                txtNgaySinh.setBounds(730, 170, 230, 40);
                btnChonNgaySinh = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\ngaysinh.png"));
                btnChonNgaySinh.setBounds(970, 170, 60, 40);
                btnChonNgaySinh.setBackground(Color.WHITE);

                //vai trò
                group = new ButtonGroup();
                JLabel lblVaiTro = new JLabel("Vai trò:");
                lblVaiTro.setFont(fontChu);
                lblVaiTro.setBounds(10, 230, 100, 25);
                lblVaiTro.setForeground(Color.BLUE);
                rdoQuanLi = new JRadioButton("Quản lí");
                rdoQuanLi.setFont(fontChu);
                rdoQuanLi.setBounds(80, 230, 90, 25);
                rdoQuanLi.setBackground(Color.WHITE);
                rdoNhanVien = new JRadioButton("Nhân viên");
                rdoNhanVien.setFont(fontChu);
                rdoNhanVien.setBounds(170, 230, 100, 25);
                rdoNhanVien.setBackground(Color.WHITE);
                group.add(rdoQuanLi);
                group.add(rdoNhanVien);

                nhapThongTin.add(lblMaNhanVien);
                nhapThongTin.add(txtMaNhanVien);
                nhapThongTin.add(lblTenNhanVien);
                nhapThongTin.add(txtTenNV);
                nhapThongTin.add(lblVaiTro);
                nhapThongTin.add(rdoNhanVien);
                nhapThongTin.add(rdoQuanLi);
                nhapThongTin.add(lblsdt);
                nhapThongTin.add(txtSDTNhanVien);
                nhapThongTin.add(lblpass);
                nhapThongTin.add(matkhau);
                nhapThongTin.add(checkmk);
                nhapThongTin.add(lblGioiTinh);
                nhapThongTin.add(rdoNam);
                nhapThongTin.add(rdoNu);
                nhapThongTin.add(lblNgaySinh);
                nhapThongTin.add(txtNgaySinh);
                nhapThongTin.add(btnChonNgaySinh);

                //bảng dữ liệu
                JLabel lblBang = new JLabel("DANH SÁCH");
                lblBang.setFont(fontChu);
                lblBang.setBounds(10, 220, 1185, 250);
                //xét jpanel cho bảng
                JPanel bang = new JPanel();
                bang.setLayout(null);
                bang.setBounds(10, 370, 1175, 270);
                bang.setBorder(new LineBorder(Color.gray));
                bang.setBackground(Color.WHITE);

                scrollNhanVien = new JScrollPane();//tạo ra thanh cuộn
                scrollNhanVien.setBounds(0, 0, 1175, 270);
                BangNhanVien = new JTable();
                BangNhanVien.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null}
                        },
                        new String[]{"Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Giới tính", "Ngày sinh", "Vai Trò", "Email"}
                ));
                BangNhanVien.setBounds(0, 0, 1175, 270);
                scrollNhanVien.setViewportView(BangNhanVien);

                bang.add(scrollNhanVien);

                //các nút button
                btnThemMoi = new JButton("Thêm Mới", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\them.png"));
                btnThemMoi.setBounds(15, 660, 120, 40);
                btnThemMoi.setBackground(Color.yellow);
                btnXoa = new JButton("Xóa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\xoa.png"));
                btnXoa.setBounds(145, 660, 120, 40);
                btnXoa.setBackground(Color.yellow);
                btnLuu = new JButton("Lưu", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\luu.png"));
                btnLuu.setBounds(275, 660, 120, 40);
                btnLuu.setBackground(Color.yellow);
                btnThoat = new JButton("Thoát", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\thoat.png"));
                btnThoat.setBounds(405, 660, 120, 40);
                btnThoat.setBackground(Color.yellow);
                btnSua = new JButton("Sửa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sua.png"));
                btnSua.setBounds(535, 660, 120, 40);
                btnSua.setBackground(Color.yellow);

                //thanh điều hướng
                btnDau = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dau.png"));
                btnDau.setBounds(900, 660, 50, 40);
                btnDau.setBackground(Color.yellow);
                btnLuiLai = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\truoc.png"));
                btnLuiLai.setBounds(970, 660, 50, 40);
                btnLuiLai.setBackground(Color.yellow);
                btnTiepTheo = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sau.png"));
                btnTiepTheo.setBounds(1040, 660, 50, 40);
                btnTiepTheo.setBackground(Color.yellow);
                btnCuoi = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\cuoi.png"));
                btnCuoi.setBounds(1110, 660, 50, 40);
                btnCuoi.setBackground(Color.yellow);

                giaoDienCon.add(qlNhanVien);
                giaoDienCon.add(nhapThongTin);
                giaoDienCon.add(lblBang);
                giaoDienCon.add(bang);
                giaoDienCon.add(btnThemMoi);
                giaoDienCon.add(btnXoa);
                giaoDienCon.add(btnLuu);
                giaoDienCon.add(btnThoat);
                giaoDienCon.add(btnSua);
                giaoDienCon.add(btnDau);
                giaoDienCon.add(btnTiepTheo);
                giaoDienCon.add(btnLuiLai);
                giaoDienCon.add(btnCuoi);

                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.YELLOW);
                btnHoadon.setBackground(Color.YELLOW);
                btnKhachHang.setBackground(Color.yellow);
                btnNhanvien.setBackground(Color.WHITE);
                btnSanpham.setBackground(Color.yellow);
                btnThongke.setBackground(Color.yellow);

                btnChonNgaySinh.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame dateFrame = new JFrame("Chọn Ngày Sinh");

                        // Tạo các ComboBox để chọn ngày, tháng, năm
                        String[] days = new String[31];
                        String[] months = new String[12];
                        String[] years = new String[120];

                        for (int i = 0; i < 31; i++) {
                            days[i] = String.valueOf(i + 1);
                        }

                        for (int i = 0; i < 12; i++) {
                            months[i] = String.valueOf(i + 1);
                        }

                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        for (int i = 0; i < 120; i++) {
                            years[i] = String.valueOf(currentYear - i);
                        }

                        JComboBox<String> dayBox = new JComboBox<>(days);
                        JComboBox<String> monthBox = new JComboBox<>(months);
                        JComboBox<String> yearBox = new JComboBox<>(years);

                        JButton selectButton = new JButton("Chọn");
                        selectButton.setBackground(Color.WHITE);
                        selectButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String selectedDate = (String) dayBox.getSelectedItem() + "/"
                                        + (String) monthBox.getSelectedItem() + "/"
                                        + (String) yearBox.getSelectedItem();
                                txtNgaySinh.setText(selectedDate);
                                dateFrame.dispose();
                            }
                        });

                        JPanel panel = new JPanel();
                        panel.setLayout(new GridLayout(4, 5));
                        panel.add(new JLabel("Ngày:"));
                        panel.add(dayBox);
                        panel.add(new JLabel("Tháng:"));
                        panel.add(monthBox);
                        panel.add(new JLabel("Năm:"));
                        panel.add(yearBox);
                        panel.add(selectButton);

                        dateFrame.add(panel);
                        dateFrame.pack();
                        dateFrame.setLocationRelativeTo(null);
                        dateFrame.setVisible(true);
                    }
                });

                btnThemMoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFormNhanVien();
                    }
                });
                btnLuu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validateFormNhanVien()) {
                            insertNhanvien();
                        }
                    }
                });
                btnSua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateNhanVien();

                    }
                });
                btnXoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteNhanVien();
                    }
                });
                BangNhanVien.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            row = BangNhanVien.getSelectedRow();
                            editNhanVien();
                        }
                    }

                });
                btnDau.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        firstNhanVien();
                    }

                });
                btnTiepTheo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nextNhanVien();
                    }

                });
                btnLuiLai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        prevNhanVien();
                    }

                });
                btnCuoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lastNhanVien();
                    }
                });
                btnThoat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dangnhap dn= new dangnhap();
                        dn.setVisible(true);
                        dispose();
                    }
                });

                fillToTableNhanVien();
            }
        });
    }

    //trang hóa đơn
    public void hoadon() {
        btnHoadon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaoDienCon.removeAll();
                Font fontChu = new Font("times new roman", Font.BOLD, 16);
                JLabel qlHoaDon = new JLabel("QUẢN LÍ HÓA ĐƠN");
                qlHoaDon.setBounds(490, -20, 250, 100);
                Font qlNV = new Font("Times new roman", Font.BOLD, 20);
                qlHoaDon.setFont(qlNV);
                qlHoaDon.setForeground(Color.BLUE);

                JPanel tab2 = new JPanel();
                tab2.setLayout(null);
                tab2.setBackground(Color.WHITE);
                tab2.setBorder(new LineBorder(Color.CYAN, 3));
                Font fontChu1 = new Font("times new roman", Font.BOLD, 17);
                JLabel lblLoaiSanPham = new JLabel("Mã sản phẩm:");
                lblLoaiSanPham.setBounds(30, 40, 120, 30);
                lblLoaiSanPham.setFont(fontChu1);
                cboLoaiSanPham = new JComboBox();
                cboLoaiSanPham.setBackground(Color.WHITE);
                cboLoaiSanPham.setBounds(280, 40, 280, 30);
//                cboLoaiSanPham.addItem("SP001");
//                cboLoaiSanPham.addItem("SP002");
//                cboLoaiSanPham.addItem("SP003");
//                cboLoaiSanPham.addItem("SP004");
//                cboLoaiSanPham.addItem("SP005");
//                HoaDonDAO hddao = new HoaDonDAO();
                
                JLabel lblTenSP = new JLabel("Tên sản phẩm:");
                lblTenSP.setFont(fontChu1);
                lblTenSP.setBounds(30, 100, 120, 30);
                cboTenSanPham = new JComboBox();
                cboTenSanPham.setBackground(Color.WHITE);
                cboTenSanPham.setBounds(280, 100, 280, 30);
//                cboTenSanPham.addItem("Giày thể thao nam");
//                cboTenSanPham.addItem("Giày thể thao nữ");
//                cboTenSanPham.addItem("Giày thể thao học sinh");
//                cboTenSanPham.addItem("Giày Penny Loafer");
//                cboTenSanPham.addItem("Giày Tassel Loafer");
                List<HoaDon> hdList = hdDao.selectAll();
                    for (HoaDon hd :hdList ) {
                        String MaSP = hd.getMaSP();
                        String TenSP = hd.getTenSP();
                        cboLoaiSanPham.addItem(MaSP);
                        cboTenSanPham.addItem(TenSP);
                    }
                JLabel lblMaHD = new JLabel("Mã hóa đơn:");
                lblMaHD.setFont(fontChu1);
                lblMaHD.setBounds(30, 160, 120, 30);
                txtMaHD = new JTextField();
                txtMaHD.setBounds(280, 160, 280, 30);
                lblHinh = new JLabel();
                lblHinh.setBorder(new LineBorder(Color.gray));
                lblHinh.setBounds(30, 220, 160, 160);
                JLabel lblDonGia = new JLabel("Đơn giá:");
                lblDonGia.setFont(fontChu1);
                lblDonGia.setBounds(700, 40, 100, 30);
                txtDonGia = new JTextField("50000");
                txtDonGia.setFont(fontChu1);
                txtDonGia.setForeground(Color.BLUE);
                txtDonGia.setBounds(820, 40, 180, 30);
                JLabel lblSoluong = new JLabel("Số lượng:");
                lblSoluong.setFont(fontChu1);
                lblSoluong.setBounds(700, 100, 100, 25);
                txtSoLuong = new JTextField();
                txtSoLuong.setFont(fontChu1);
                txtSoLuong.setBounds(820, 100, 180, 30);
                JLabel lblmaKH = new JLabel("Mã khách hàng:");
                lblmaKH.setFont(fontChu1);
                lblmaKH.setBounds(670, 155, 130, 25);
                txtmaKH = new JTextField();
                txtmaKH.setFont(fontChu1);
                txtmaKH.setBounds(820, 155, 180, 30);
                JLabel lblThanhTien = new JLabel("Thành tiền:");
                lblThanhTien.setFont(fontChu1);
                lblThanhTien.setBounds(700, 200, 100, 25);
                txtThanhTien = new JTextField();
                txtThanhTien.setFont(fontChu1);
                txtThanhTien.setBounds(820, 200, 180, 30);
                JLabel dv1 = new JLabel("VNĐ");
                dv1.setFont(fontChu1);
                dv1.setBounds(1010, 200, 50, 30);
                JLabel chucnag = new JLabel("Chức năng:");
                chucnag.setBounds(320, 230, 100, 25);
                chucnag.setFont(fontChu1);
                JPanel congcu = new JPanel();
                congcu.setLayout(null);
                congcu.setBorder(BorderFactory.createLineBorder(Color.black));
                congcu.setBounds(320, 270, 500, 100);
                congcu.setBackground(Color.WHITE);

                //công cụ
                btnThemMoi = new JButton("Thêm", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\them.png"));
                btnThemMoi.setBounds(20, 10, 100, 30);
                btnThemMoi.setBackground(Color.YELLOW);
                btnSua = new JButton("Sửa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sua.png"));
                btnSua.setBounds(200, 10, 100, 30);
                btnSua.setBackground(Color.YELLOW);
                btnXoa = new JButton("Xóa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\xoa.png"));
                btnXoa.setBounds(380, 10, 100, 30);
                btnXoa.setBackground(Color.YELLOW);
                btnMoi = new JButton("Mới", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\new.png"));
                btnMoi.setBounds(20, 60, 100, 30);
                btnMoi.setBackground(Color.YELLOW);
                btnIn = new JButton("In", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\in.png"));
                btnIn.setBounds(200, 60, 100, 30);
                btnIn.setBackground(Color.YELLOW);
                btnXong = new JButton("Xong", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\xong.png"));
                btnXong.setBounds(380, 60, 100, 30);
                btnXong.setBackground(Color.YELLOW);

                congcu.add(btnThemMoi);
                congcu.add(btnSua);
                congcu.add(btnXoa);
                congcu.add(btnMoi);
                congcu.add(btnIn);
                congcu.add(btnXong);

                //Bảng thống kê hóa đơn
                scrollHoaDon = new JScrollPane();//tạo ra thanh cuộn
                scrollHoaDon.setBounds(3, 390, 1175, 250);
                BangHoaDon = new JTable();
                BangHoaDon.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null}
                        },
                        new String[]{"Mã hóa đơn","Mã sản phẩm", "Tên sản phẩm", "Đơn giá" ,"Số lượng", "Mã khách hàng", "Thành tiền"}
                ));
                BangHoaDon.setBounds(3, 390, 1175, 250);
                scrollHoaDon.setViewportView(BangHoaDon);

                tab2.add(lblLoaiSanPham);
                tab2.add(cboLoaiSanPham);
                tab2.add(lblTenSP);
                tab2.add(cboTenSanPham);
                tab2.add(lblMaHD);
                tab2.add(txtMaHD);
                tab2.add(lblHinh);
                tab2.add(lblDonGia);
                tab2.add(txtDonGia);
                tab2.add(lblSoluong);
                tab2.add(txtSoLuong);
                tab2.add(lblmaKH);
                tab2.add(txtmaKH);
                tab2.add(lblThanhTien);
                tab2.add(txtThanhTien);
                tab2.add(dv1);
                tab2.add(chucnag);
                tab2.add(congcu);
                tab2.add(scrollHoaDon);

                // Create the JTabbedPane and add tabs
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.add("HÓA ĐƠN", tab2);
                tabbedPane.setFont(fontChu);
                tabbedPane.setBackground(Color.WHITE);
                tabbedPane.setBounds(0, 50, 1185, 663);

                giaoDienCon.add(qlHoaDon);
                giaoDienCon.add(tabbedPane);

                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.YELLOW);
                btnHoadon.setBackground(Color.WHITE);
                btnKhachHang.setBackground(Color.yellow);
                btnNhanvien.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.yellow);
                btnThongke.setBackground(Color.yellow);
                
                btnMoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFormhoadon();
                    }
                });
                btnThemMoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inserthoadon();
                    }
                });
                btnSua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updatehoadon();
                    }

                });
                btnXoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deletehoadon();
                    }

                });
                BangHoaDon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            row = BangHoaDon.getSelectedRow();
                            edithoadon();
                        }
                    }

                });

                btnXong.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }

                });

                inithoadon();
            }
        });
    }

    //trang sản phẩm
    public void Sanpham() {
        btnSanpham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaoDienCon.removeAll();

                lblTDTrang = new JLabel("QUẢN LÍ SẢN PHẨM");
                lblTDTrang.setBounds(490, -20, 250, 100);
                Font qlNV = new Font("Times new roman", Font.BOLD, 20);
                lblTDTrang.setFont(qlNV);
                lblTDTrang.setForeground(Color.BLUE);

                tabCapNhap = new JPanel();
                tabCapNhap.setLayout(null);
                tabCapNhap.setBackground(Color.WHITE);

                Font fontChu1 = new Font("times new roman", Font.BOLD, 17);
                JLabel lblMaSanPham = new JLabel("Mã sản phẩm:");
                lblMaSanPham.setFont(fontChu1);
                lblMaSanPham.setBounds(40, 20, 120, 25);
                txtMaSanPham = new JTextField();
                txtMaSanPham.setFont(fontChu1);
                txtMaSanPham.setForeground(Color.RED);
                txtMaSanPham.setBounds(45, 60, 500, 40);
                JLabel lblTenSP = new JLabel("Tên sản phẩm:");
                lblTenSP.setFont(fontChu1);
                lblTenSP.setBounds(40, 120, 120, 25);
                txtTensanpham = new JTextField();
                txtTensanpham.setBounds(45, 160, 500, 40);
                txtTensanpham.setFont(fontChu1);
                JLabel lblDanhMuc = new JLabel("Danh mục sản phẩm:");
                lblDanhMuc.setFont(fontChu1);
                lblDanhMuc.setBounds(40, 220, 200, 25);
                JLabel lblKichco = new JLabel("Kích cỡ:");
                lblKichco.setFont(fontChu1);
                lblKichco.setBounds(320, 220, 200, 25);
                cbDanhMucSP = new JComboBox();
                cbDanhMucSP.setFont(fontChu1);
                cbDanhMucSP.setBounds(45, 260, 220, 40);
                txtKichco = new JTextField();
                txtKichco.setBounds(320, 260, 225, 40);
                txtKichco.setFont(fontChu1);
                JLabel lblDonGia = new JLabel("Đơn giá:");
                lblDonGia.setFont(fontChu1);
                lblDonGia.setBounds(40, 320, 120, 25);
                txtDonGiaBan = new JTextField();
                txtDonGiaBan.setFont(fontChu1);
                txtDonGiaBan.setBounds(45, 360, 500, 40);
                JLabel lblSoLuong = new JLabel("Số lượng:");
                lblSoLuong.setFont(fontChu1);
                lblSoLuong.setBounds(40, 420, 150, 25);
                txtSoLuongSP = new JTextField();
                txtSoLuongSP.setFont(fontChu1);
                txtSoLuongSP.setBounds(45, 460, 500, 40);
                JLabel thongbao = new JLabel("(*)Lưu ý: Vui lòng nhập đầy đủ thông tin sản phẩm trước khi lưu!");
                thongbao.setBounds(50, 420, 500, 100);
                thongbao.setFont(fontChu1);
                thongbao.setForeground(Color.BLUE);
                JLabel lblGhiChu = new JLabel("Ghi chú:");
                lblGhiChu.setFont(fontChu1);
                lblGhiChu.setBounds(650, 20, 120, 25);
                ghiChuSP = new JTextArea();
                ghiChuSP.setFont(fontChu1);
                ghiChuSP.setBounds(650, 60, 500, 170);
                ghiChuSP.setBorder(new LineBorder(Color.GRAY));
                JLabel lblAnh = new JLabel("Ảnh sản phẩm");
                lblAnh.setFont(fontChu1);
                lblAnh.setBounds(800, 250, 200, 25);
                lblhinhSP = new JLabel();
                lblhinhSP.setBorder(new LineBorder(Color.blue));
                lblhinhSP.setBounds(800, 280, 250, 250);
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Chọn ảnh giày");
                LoaiSpDao lspDao = new LoaiSpDao();
                List<LoaiSp> listsp = lspDao.selectAll();
                for (LoaiSp tenloai : listsp) {
                    cbDanhMucSP.addItem(tenloai.getTenLoai());
                }

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("EduSys - Quản lý chuyên đề");

                 //chức năng 
                Font fontChu = new Font("times new roman", Font.BOLD, 14);
                btnLuu = new JButton("Lưu", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\them.png"));
                btnLuu.setFont(fontChu);
                btnLuu.setBounds(40, 570, 100, 30);
                btnLuu.setBackground(Color.yellow);
                btnXoa = new JButton("Xóa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\xoa.png"));
                btnXoa.setFont(fontChu);
                btnXoa.setBounds(155, 570, 110, 30);
                btnXoa.setBackground(Color.yellow);
                btnSua = new JButton("Sửa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sua.png"));
                btnSua.setFont(fontChu);
                btnSua.setBounds(280, 570, 110, 30);
                btnSua.setBackground(Color.yellow);
                btnMoi = new JButton("Mới", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\new.png"));
                btnMoi.setFont(fontChu);
                btnMoi.setBounds(405, 570, 110, 30);
                btnMoi.setBackground(Color.yellow);

                //nút điều hướng
                btnDau = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dau.png"));
                btnDau.setBounds(800, 570, 50, 40);
                btnDau.setBackground(Color.yellow);
                btnLuiLai = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\truoc.png"));
                btnLuiLai.setBounds(870, 570, 50, 40);
                btnLuiLai.setBackground(Color.yellow);
                btnTiepTheo = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sau.png"));
                btnTiepTheo.setBounds(940, 570, 50, 40);
                btnTiepTheo.setBackground(Color.yellow);
                btnCuoi = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\cuoi.png"));
                btnCuoi.setBounds(1010, 570, 50, 40);
                btnCuoi.setBackground(Color.yellow);

                tabCapNhap.add(lblMaSanPham);
                tabCapNhap.add(txtMaSanPham);
                tabCapNhap.add(lblTenSP);
                tabCapNhap.add(txtTensanpham);
                tabCapNhap.add(lblDanhMuc);
                tabCapNhap.add(lblKichco);
                tabCapNhap.add(cbDanhMucSP);
                tabCapNhap.add(txtKichco);
                tabCapNhap.add(lblDonGia);
                tabCapNhap.add(txtDonGiaBan);
                tabCapNhap.add(thongbao);
                tabCapNhap.add(lblGhiChu);
                tabCapNhap.add(ghiChuSP);
                tabCapNhap.add(lblAnh);
                tabCapNhap.add(lblhinhSP);
                tabCapNhap.add(btnLuu);
                tabCapNhap.add(btnXoa);
                tabCapNhap.add(btnSua);
                tabCapNhap.add(btnMoi);
                tabCapNhap.add(btnDau);
                tabCapNhap.add(btnLuiLai);
                tabCapNhap.add(btnTiepTheo);
                tabCapNhap.add(btnCuoi);

                tabDanhSach = new JPanel();
                tabDanhSach.setLayout(null);
                tabDanhSach.setBackground(Color.white);

                scrollSanPham = new JScrollPane();//tạo ra thanh cuộn
                scrollSanPham.setBounds(0, 0, 1175, 580);
                bangSanPham = new JTable();
                bangSanPham.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null}
                        },
                        new String[]{"Mã sản phẩm", "Tên sản phảm", "Danh mục sản phẩm", "Kích cỡ", "Đơn giá", "Ảnh", "Ghi Chú"}
                ) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }

                }
                );
                bangSanPham.setBounds(0, 0, 1175, 580);
                scrollSanPham.setViewportView(bangSanPham);

                btnXuatExcel = new JButton("Xuất Excel");
                btnXuatExcel.setFont(fontChu1);
                btnXuatExcel.setBounds(1030, 590, 130, 30);
                btnXuatExcel.setBackground(Color.WHITE);
                btnXuatExcel.setForeground(Color.BLUE);

                tabDanhSach.add(scrollSanPham);
                tabDanhSach.add(btnXuatExcel);

                tab = new JTabbedPane();
                tab.setBounds(0, 50, 1185, 663);
                tab.add("CẬP NHẬP", tabCapNhap);
                tab.add("DANH SÁCH SẢN PHẨM", tabDanhSach);

                giaoDienCon.add(lblTDTrang);
                giaoDienCon.add(tab);
                giaoDienCon.add(fileChooser);
                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.YELLOW);
                btnHoadon.setBackground(Color.YELLOW);
                btnKhachHang.setBackground(Color.yellow);
                btnNhanvien.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.WHITE);
                btnThongke.setBackground(Color.yellow);
                lblhinhSP.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        chonAnh();
                    }
                });

                bangSanPham.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            tab.setSelectedIndex(0);
                            row = bangSanPham.getSelectedRow();
                            edit();
                        }
                    }

                });
                btnMoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearForm();
                    }
                });
                btnLuu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validateFormSP()) {
                            insert();
                        }
                    }
                });
                btnSua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validateFormSP()) {
                            update();
                        }
                    }

                });
                btnXoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        delete();
                    }

                });

                btnDau.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        first();
                    }

                });
                btnTiepTheo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        next();
                    }

                });
                btnLuiLai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        prev();
                    }

                });
                btnCuoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        last();
                    }

                });
                btnXuatExcel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteExcelFile("haha");
                       // exportTableToExcel(bangSanPham,"haha");
                    }

                });
                

                init();
            }
        });
    }

    //trang thống kê
    public void thongke() {
        btnThongke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaoDienCon.removeAll();
                JLabel qlthongkr = new JLabel("QUẢN LÍ THỐNG KÊ");
                qlthongkr.setBounds(490, -20, 250, 100);
                Font qlNV = new Font("Times new roman", Font.BOLD, 20);
                qlthongkr.setFont(qlNV);
                qlthongkr.setForeground(Color.BLUE);

                JTabbedPane thongkeJTabbedPane = new JTabbedPane();
                thongkeJTabbedPane.setBounds(0, 100, 1175, 480);

                JPanel thongkeSanPham = new JPanel();
                thongkeSanPham.setLayout(null);
                
                
                scThongKeSanPham = new JScrollPane();//tạo ra thanh cuộn
                scThongKeSanPham.setBounds(0, 10, 1175, 40);
                BangThongKeSanPham = new JTable();
                BangThongKeSanPham.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null}
                        },
                        new String[]{"Mã loại sản phẩm", "Tên sản phảm", "Số lượng sản phẩm"}
                ) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }

                }
                );
                BangThongKeSanPham.setBounds(0, 10, 1175, 480);
                scThongKeSanPham.setViewportView(BangThongKeSanPham);
                
                thongkeSanPham.add(scThongKeSanPham);
 //---------------------------------------------------------------hóa đơn------------------------------------
                JPanel thongkeHoaDon = new JPanel();
                thongkeHoaDon.setLayout(null);
                crThongKeHoaDon = new JScrollPane();//tạo ra thanh cuộn
                crThongKeHoaDon.setBounds(0, 0, 1175, 580);
                BangThongKeHoaDon = new JTable();
                BangThongKeHoaDon.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null},
                            {null, null},
                            {null, null},
                            {null, null}
                        },
                        new String[]{"Mã nhân viên","Số lượng hóa đơn"}
                ) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }

                }
                );
                BangThongKeHoaDon.setBounds(0, 0, 1175, 580);
                crThongKeHoaDon.setViewportView(BangThongKeHoaDon);
                
                thongkeHoaDon.add(crThongKeHoaDon);
                

                thongkeJTabbedPane.add("THỐNG KÊ SẢN PHẨM", thongkeSanPham);
                thongkeJTabbedPane.add("THỐNG KÊ HÓA ĐƠN", thongkeHoaDon);

                Font fon55= new Font("Time new roman",Font.BOLD,15);
                JLabel lblSLThanhVien= new JLabel("SỐ LƯỢNG THÀNH VIÊN:");
                lblSLThanhVien.setBounds(20,600,200,50);
                lblSLThanhVien.setForeground(Color.BLUE);
                lblSLThanhVien.setFont(fon55);
                lblSoLuongThanhVien= new JLabel("11");
                lblSoLuongThanhVien.setBounds(220,600,100,50);
                lblSoLuongThanhVien.setFont(fon55);
                JLabel tongdoanhthu= new JLabel("TỔNG DOANH THU:");
                tongdoanhthu.setBounds(870,615,200,20);
                tongdoanhthu.setForeground(Color.RED);
                tongdoanhthu.setFont(fon55);
                lblTongDoanhThu= new JLabel("2564");
                lblTongDoanhThu.setFont(fon55);
                lblTongDoanhThu.setBounds(1030,600,100,50);
                JLabel dv = new JLabel("VND");
                dv.setFont(fon55);
                dv.setBounds(1120,600,100,50);
                
                
                

                btnXuatExcel = new JButton("Xuất Excel");
                btnXuatExcel.setBounds(1050, 660, 120, 40);
                btnXuatExcel.setBackground(Color.WHITE);
                btnXuatExcel.setForeground(Color.BLUE);

                giaoDienCon.add(qlthongkr);
                giaoDienCon.add(thongkeJTabbedPane);
                giaoDienCon.add(lblSLThanhVien);
                giaoDienCon.add(lblSoLuongThanhVien);
                giaoDienCon.add(tongdoanhthu);
                giaoDienCon.add(lblTongDoanhThu);
                giaoDienCon.add(dv);
                giaoDienCon.add(btnXuatExcel);
                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.YELLOW);
                btnHoadon.setBackground(Color.YELLOW);
                btnKhachHang.setBackground(Color.yellow);
                btnNhanvien.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.YELLOW);
                btnThongke.setBackground(Color.WHITE);
                
                fillTableTKSanPham();
                fillTableTkHoaDon();
                updateLabels();
                btnXuatExcel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MsgBox.alert(container,"Chức năng chưa hoàn thiện");
                    }

                });
            }
            
        });
    }

    //trang khách hàng
    public void khachHang() {
        btnKhachHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 giaoDienCon.removeAll();

                lblTDTrang = new JLabel("QUẢN LÍ KHÁCH HÀNG");
                lblTDTrang.setBounds(490, -20, 250, 100);
                Font qlNV = new Font("Times new roman", Font.BOLD, 20);
                lblTDTrang.setFont(qlNV);
                lblTDTrang.setForeground(Color.BLUE);

                Font fontChu1 = new Font("times new roman", Font.BOLD, 17);
                JLabel lblmaKH = new JLabel("Mã khách hàng:");
                lblmaKH.setBounds(40, 80, 120, 25);
                lblmaKH.setFont(fontChu1);
                txtMaKhachHang = new JTextField();
                txtMaKhachHang.setFont(fontChu1);
                txtMaKhachHang.setBounds(40, 120, 320, 40);
                JLabel lbltenKH = new JLabel("Tên khách hàng:");
                lbltenKH.setFont(fontChu1);
                lbltenKH.setBounds(40, 180, 120, 25);
                txtTenKhachHang = new JTextField();
                txtTenKhachHang.setFont(fontChu1);
                txtTenKhachHang.setBounds(40, 220, 320, 40);
                JLabel lblSDTKH = new JLabel("Số điện thoại:");
                lblSDTKH.setFont(fontChu1);
                lblSDTKH.setBounds(40, 280, 120, 25);
                txtSoDienThoaiKhachHang = new JTextField();
                txtSoDienThoaiKhachHang.setFont(fontChu1);
                txtSoDienThoaiKhachHang.setBounds(40, 320, 320, 40);
                JLabel lbldiaChiKH = new JLabel("Địa chỉ:");
                lbldiaChiKH.setFont(fontChu1);
                lbldiaChiKH.setBounds(680, 80, 120, 25);
                txtDiaChiKhachHang = new JTextField();
                txtDiaChiKhachHang.setFont(fontChu1);
                txtDiaChiKhachHang.setBounds(680, 120, 320, 40);
                JLabel lblemailKH = new JLabel("Email:");
                lblemailKH.setBounds(680, 170, 120, 25);
                lblemailKH.setFont(fontChu1);
                txtEmailKhachHang = new JTextField();
                txtEmailKhachHang.setFont(fontChu1);
                txtEmailKhachHang.setBounds(680, 200, 320, 35);
                JLabel lblthanhVien = new JLabel("Thành viên:");
                lblthanhVien.setFont(fontChu1);
                lblthanhVien.setBounds(680, 250, 120, 25);
                rdoCo = new JRadioButton("Thành Viên");
                rdoKhong = new JRadioButton("Không Thành Viên ");
                rdoCo.setFont(fontChu1);
                rdoKhong.setFont(fontChu1);
                rdoCo.setBounds(680, 270, 120, 40);
                rdoKhong.setBounds(840, 270, 200, 40);
                rdoCo.setBackground(Color.WHITE);
                rdoKhong.setBackground(Color.WHITE);
                rdoCo.setForeground(Color.BLUE);
                rdoKhong.setForeground(Color.BLUE);
                group1 = new ButtonGroup();
                group1.add(rdoCo);
                group1.add(rdoKhong);
                rdoKhong.setSelected(true);
                JLabel lblTimKiemKH = new JLabel("Tìm kiếm khách hàng");
                lblTimKiemKH.setFont(fontChu1);
                lblTimKiemKH.setBounds(680, 320, 200, 25);
                JPanel timkiem = new JPanel();
                timkiem.setLayout(null);
                timkiem.setBorder(new LineBorder(Color.WHITE));
                timkiem.setBackground(Color.WHITE);
                timkiem.setBounds(680, 360, 320, 50);
                txtTimKiemKhachHang = new JTextField();
                txtTimKiemKhachHang.setFont(fontChu1);
                txtTimKiemKhachHang.setBounds(5, 5, 230, 40);
                btntimKiem = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\timkiem.png"));
                btntimKiem.setBounds(250, 5, 60, 40);
                btntimKiem.setBackground(Color.CYAN);
                timkiem.add(txtTimKiemKhachHang);
                timkiem.add(btntimKiem);
                JLabel lblDanhSachKh = new JLabel("Danh sách khách hàng:");
                lblDanhSachKh.setFont(fontChu1);
                lblDanhSachKh.setBounds(40, 400, 200, 25);
                lblDanhSachKh.setForeground(Color.BLUE);

                scrollKhachHang = new JScrollPane();//tạo ra thanh cuộn
                scrollKhachHang.setBounds(5, 440, 1175, 200);
                bangKhachHang = new JTable();

                bangKhachHang.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null}
                        },
                        new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Email", "Thành viên"}
                ) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }

                });

                bangKhachHang.setBounds(5, 440, 1175, 200);
                scrollKhachHang.setViewportView(bangKhachHang);

                //các nút button
                btnThemMoi = new JButton("Thêm Mới", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\them.png"));
                btnThemMoi.setBounds(15, 660, 120, 40);
                btnThemMoi.setBackground(Color.yellow);
                btnXoa = new JButton("Xóa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\xoa.png"));
                btnXoa.setBounds(145, 660, 120, 40);
                btnXoa.setBackground(Color.yellow);
                btnLuu = new JButton("Lưu", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\luu.png"));
                btnLuu.setBounds(275, 660, 120, 40);
                btnLuu.setBackground(Color.yellow);
                btnThoat = new JButton("Thoát", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\thoat.png"));
                btnThoat.setBounds(405, 660, 120, 40);
                btnThoat.setBackground(Color.yellow);
                btnSua = new JButton("Sửa", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sua.png"));
                btnSua.setBounds(535, 660, 120, 40);
                btnSua.setBackground(Color.yellow);

                //thanh điều hướng
                btnDau = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dau.png"));
                btnDau.setBounds(900, 660, 50, 40);
                btnDau.setBackground(Color.yellow);
                btnLuiLai = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\truoc.png"));
                btnLuiLai.setBounds(970, 660, 50, 40);
                btnLuiLai.setBackground(Color.yellow);
                btnTiepTheo = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\sau.png"));
                btnTiepTheo.setBounds(1040, 660, 50, 40);
                btnTiepTheo.setBackground(Color.yellow);
                btnCuoi = new JButton(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\cuoi.png"));
                btnCuoi.setBounds(1110, 660, 50, 40);
                btnCuoi.setBackground(Color.yellow);

                //giaoDienCon.add(qlKhachHang);
                giaoDienCon.add(lblmaKH);
                giaoDienCon.add(txtMaKhachHang);
                giaoDienCon.add(lbltenKH);
                giaoDienCon.add(txtTenKhachHang);
                giaoDienCon.add(lblSDTKH);
                giaoDienCon.add(txtSoDienThoaiKhachHang);
                giaoDienCon.add(lbldiaChiKH);
                giaoDienCon.add(txtDiaChiKhachHang);
                giaoDienCon.add(lblemailKH);
                giaoDienCon.add(txtEmailKhachHang);
                giaoDienCon.add(lblthanhVien);
                giaoDienCon.add(rdoCo);
                giaoDienCon.add(rdoKhong);
                giaoDienCon.add(lblTimKiemKH);
                giaoDienCon.add(timkiem);
                giaoDienCon.add(lblDanhSachKh);
                giaoDienCon.add(scrollKhachHang);
                giaoDienCon.add(btnThemMoi);
                giaoDienCon.add(btnXoa);
                giaoDienCon.add(btnLuu);
                giaoDienCon.add(btnThoat);
                giaoDienCon.add(btnSua);
                giaoDienCon.add(btnDau);
                giaoDienCon.add(btnTiepTheo);
                giaoDienCon.add(btnLuiLai);
                giaoDienCon.add(btnCuoi);

                giaoDienCon.validate();
                giaoDienCon.repaint();

                btnTrangchu.setBackground(Color.YELLOW);
                btnHoadon.setBackground(Color.YELLOW);
                btnKhachHang.setBackground(Color.WHITE);
                btnNhanvien.setBackground(Color.yellow);
                btnSanpham.setBackground(Color.yellow);
                btnThongke.setBackground(Color.yellow);

                //---------------------------------- chức năng-------------------------------------
                btnThemMoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearForm();
                    }
                });
                btnLuu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validateFormKH()) {
                            insert();
                        }
                    }
                });
                btnSua.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validateFormKH()) {
                            update();
                        }
                    }

                });
                btnXoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        delete();
                    }

                });
                bangKhachHang.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            row = bangKhachHang.getSelectedRow();
                            edit();
                        }
                    }

                });
                btnDau.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        first();
                    }

                });
                btnTiepTheo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        next();
                    }

                });
                btnLuiLai.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        prev();
                    }

                });
                btnCuoi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        last();
                    }

                });
                btnThoat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        trangchu();
                    }

                });
                btntimKiem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchKH();
                    }

                });

                init();
            }
        });
    }

    private void updateClock() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss a");
        clock.setText(dateFormat.format(new Date()));
    }

    private void updateClockContinuously() {
        while (true) {
            updateClock();
            try {
                //cập nhập thời gian mỗi giây
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //---------------------------------------------------chức năng code tại đây-----------------------------------
    public void chucnang() {
        lbldoiMK.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                doiMatKhau doimk = new doiMatKhau();
                doimk.setVisible(true);
            }
        });
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dangnhap dn = new dangnhap();
                dn.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String check[] = {"Có", "Không"};
                int confirm = JOptionPane.showOptionDialog(btnExit, "Bạn có muốn thoát chương trình ?", "Thông báo", 0, 0, null, check, check[1]);
                if (confirm == 0) {
                    JOptionPane.showMessageDialog(btnExit, "Xin chào và hẹn gặp lại!");
                    System.exit(0);
                }
            }
        });
        btnDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Auth.clear();
                dispose();
                dangnhap dn = new dangnhap();
                if (Auth.checkLogin() == true) {
                    dn.setVisible(true);
                }
            }
        });
    }

    //----------------------------chức năng nhân viên-----------------------------------------
    public void fillToTableNhanVien() {
        DefaultTableModel model = (DefaultTableModel) BangNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = nvDAO.selectAll();
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getMatKhau(),
                    nv.getTenNV(),
                    nv.isGioiTinh() ? "Nữ" : "Nam",
                    nv.getNgaySinh(),
                    nv.isVaiTro() ? "Quản lí" : "Nhân viên",
                    nv.getEmail()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(container, "Lỗi dữ liệu nhân viên");
        }

    }

    void CapNhapTrangThaiNhanVien() {
        boolean edit = (this.row >= 0);
        boolean fist = (this.row == 0);
        boolean last = (this.row == BangNhanVien.getRowCount() - 1);

        //trạng thái form
        txtMaNhanVien.setEnabled(!edit);
        //btnThemMoi.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

        //trạng thái thanh điều hướng
        btnDau.setEnabled(edit && !fist);
        btnLuiLai.setEnabled(edit && !fist);
        btnTiepTheo.setEnabled(edit && !last);
        btnCuoi.setEnabled(edit && !last);
    }

    void editNhanVien() {
        String manv = (String) BangNhanVien.getValueAt(this.row, 0);
        NhanVien nv = nvDAO.selectById(manv);
        setformNhanvien(nv);
        CapNhapTrangThaiNhanVien();

    }

    NhanVien getFormNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNhanVien.getText());
        nv.setTenNV(txtTenNV.getText());
        nv.setMatKhau(String.valueOf(matkhau.getPassword()));
        //nv.setGioiTinh(rdoNu.isSelected());
        nv.setGioiTinh(rdoNam.isSelected());
        nv.setGioiTinh(rdoNu.isSelected());
        nv.setNgaySinh(XDate.toDate(txtNgaySinh.getText(), "dd/MM/yyyy"));
        nv.setVaiTro(rdoNhanVien.isSelected());
        nv.setVaiTro(rdoQuanLi.isSelected());
        nv.setEmail(txtSDTNhanVien.getText());

        return nv;
    }

    void setformNhanvien(NhanVien nv) {
        txtMaNhanVien.setText(nv.getMaNV());
        txtTenNV.setText(nv.getTenNV());
        matkhau.setText(String.valueOf(nv.getMatKhau()));
        if (nv.getNgaySinh() == null) {
            String date = "1/1/2000";
            txtNgaySinh.setText(XDate.toString(new Date(date), "dd/MM/yyyy"));
        } else {
            txtNgaySinh.setText(XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"));
        }

        if (nv.isGioiTinh()) {
            rdoNu.setSelected(true);

        } else {
            rdoNam.setSelected(true);
        }

        if (nv.isVaiTro()) {
            rdoQuanLi.setSelected(true);
        } else {
            rdoNhanVien.setSelected(true);
        }
        txtSDTNhanVien.setText(nv.getEmail());
    }

    void deleteNhanVien() {
        String manv = txtMaNhanVien.getText();
        try {
            nvDAO.delete(manv);
            fillToTableNhanVien();
            clearFormNhanVien();
            MsgBox.alert(container, "Xóa nhân viên thành công!");
        } catch (Exception e) {
            MsgBox.alert(container, "Xóa nhân viên thất bại");
            e.printStackTrace();
        }
    }

    void insertNhanvien() {
        NhanVien nv = getFormNhanVien();

        try {
            nvDAO.insert(nv);
            fillToTableNhanVien();
            clearFormNhanVien();
            MsgBox.alert(container, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(container, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void updateNhanVien() {
        NhanVien nv = getFormNhanVien();
        try {
            nvDAO.update(nv);
            fillToTableNhanVien();
            MsgBox.alert(container, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(container, "Cập nhật thất bại");
        }
    }

    public void clearFormNhanVien() {
        NhanVien nv = new NhanVien();
        setformNhanvien(nv);
        row = -1;
        CapNhapTrangThaiNhanVien();
    }

    public boolean validateFormNhanVien() {
        if (txtMaNhanVien.getText().isEmpty()) {
            MsgBox.alert(container, "Chưa nhập mã nhân viên");
            txtMaNhanVien.requestFocus();
            return false;
        } else if (txtTenNV.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập tên nhân viên!");
            txtTenNV.requestFocus();
            return false;

        } else if (matkhau.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập mật khẩu!");
            matkhau.requestFocus();
            return false;

        } else if (txtNgaySinh.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập ngày sinh!");
            txtNgaySinh.requestFocus();
            return false;

        } else if (txtSDTNhanVien.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập email khách hàng!");
            txtSDTNhanVien.requestFocus();
            return false;

        }

        if (rdoNam.isSelected()) {
            MsgBox.alert(this, "Nhân viên là nam");

        } else {
            //rdoNu.requestFocus();
            //return false;
            MsgBox.alert(this, "Nhân viên là nữ");

        }
        if (rdoQuanLi.isSelected()) {
            MsgBox.alert(this, "Bạn là quản lí!");

        } else {
            //rdoNhanVien.requestFocus();
            //return false;
            MsgBox.alert(this, "Nhân viên là Nhân viên");

        }
        return true;
    }

    void firstNhanVien() {
        this.row = 0;
        this.editNhanVien();
    }

    void nextNhanVien() {
        if (this.row < BangNhanVien.getRowCount() - 1) {
            this.row++;
            this.editNhanVien();
        }
    }

    void lastNhanVien() {
        this.row = BangNhanVien.getRowCount() - 1;
        this.editNhanVien();
    }

    void prevNhanVien() {
        if (this.row > 0) {
            this.row--;
            this.editNhanVien();
        }
    }
    //-----------------------------------------------chức năng khách hàng---------------------------------------------
    // Chuc Nang FormKhachHang
    SanPhamDAo SpDao = new SanPhamDAo();
    KhachHangDAO khDao = new KhachHangDAO();
    //public int row = -1;

    void init() {
        this.fillTable(); // đổ dữ liệu nhân viên vào bảng
        this.updateStatus(); // cập nhật trạng thái form
    }

    void first() {
        this.row = 0;
        this.edit();
    }

    void next() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            nextKh();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            nextSP();
        }
    }

    void nextKh() {
        if (this.row < bangKhachHang.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void nextSP() {
        if (this.row < bangSanPham.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            lastKh();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            lastSp();
        }
    }

    void lastKh() {
        this.row = bangKhachHang.getRowCount() - 1;
        this.edit();
    }

    void lastSp() {
        this.row = bangSanPham.getRowCount() - 1;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void updateStatus() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            statusKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            statusSP();
        }
    }

    void statusKH() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == bangKhachHang.getRowCount() - 1);
        // Trạng thái form
        txtMaKhachHang.setEditable(!edit);
//        btnThemMoi.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

        // Trạng thái điều hướng
        btnDau.setEnabled(edit && !first);
        btnLuiLai.setEnabled(edit && !first);
        btnTiepTheo.setEnabled(edit && !last);
        btnCuoi.setEnabled(edit && !last);
    }

    void statusSP() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == bangSanPham.getRowCount() - 1);
        // Trạng thái form
        txtMaSanPham.setEditable(!edit);
//        btnMoi.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

        // Trạng thái điều hướng
        btnDau.setEnabled(edit && !first);
        btnLuiLai.setEnabled(edit && !first);
        btnTiepTheo.setEnabled(edit && !last);
        btnCuoi.setEnabled(edit && !last);
    }

    void searchKH() {
        if (isTrungMa()) {
            KhachHang kh = khDao.selectById(txtTimKiemKhachHang.getText());
            MsgBox.alert(this, "Đã tìm thấy khách hàng có mã: " + "'" + kh.getMaKH() + "'");
            this.setFormKhachHang(kh);
        } else {
            MsgBox.alert(this, "Không tìm thấy khách hàng có mã: " + "'" + txtTimKiemKhachHang.getText() + "'");
        }

    }

    boolean isTrungMa() {
        DefaultTableModel md = (DefaultTableModel) bangKhachHang.getModel();
        int rows = md.getRowCount();
        Object[] dataF = new Object[rows];
        for (int i = 0; i < rows; i++) {
            dataF[i] = md.getValueAt(i, 0);
        }
        for (Object ob : dataF) {
            if (txtTimKiemKhachHang.getText().equals(ob)) {
                return true;
            }
        }
        return false;
    }

    void edit() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            editKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            editSP();
        }
    }

    void editKH() {
        String maKh = (String) bangKhachHang.getValueAt(this.row, 0);
        KhachHang kh = khDao.selectById(maKh);
        this.setFormKhachHang(kh);
        this.updateStatus();
    }

    void editSP() {
        String masp = (String) bangSanPham.getValueAt(this.row, 0);
        SanPham sp = SpDao.selectById(masp);
        this.setFormSanPham(sp);
        this.updateStatus();
    }

    void fillTable() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            fillTableKhachHang();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            System.out.println(lblTDTrang.getText());
            fillTableSanPham();
        }

    }

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file); // lưu hình vào thư mục logos
            ImageIcon iconN = XImage.read(file.getName()); // đọc hình từ logos
            Image img= iconN.getImage().getScaledInstance(lblhinhSP.getWidth(), lblhinhSP.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon= new ImageIcon(img);
            lblhinhSP.setIcon(icon);
            lblhinhSP.setToolTipText(file.getName()); // giữ tên hình trong tooltip
        }
    }

    void fillTableKhachHang() {
        DefaultTableModel model = (DefaultTableModel) bangKhachHang.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = khDao.selectAll();
            for (KhachHang KH : list) {
                Object[] row = {
                    KH.getMaKH(),
                    KH.getTenKH(),
                    KH.getDiaChi(),
                    KH.getEmail(),
                    KH.getThanhVien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void fillTableSanPham() {
        DefaultTableModel model = (DefaultTableModel) bangSanPham.getModel();
        model.setRowCount(0);
        try {
            System.out.println("alo");

            List<SanPham> list = SpDao.selectAll();
            for (SanPham sp : list) {
                Object[] row = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getTenLoai(),
                    sp.getKichThuoc(),
                    sp.getGiaBan(),
                    sp.getImage(),
                    sp.getChuThich()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    KhachHang getFormKH() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKhachHang.getText());
        kh.setTenKH(txtTenKhachHang.getText());
        kh.setDiaChi(txtDiaChiKhachHang.getText());
        kh.setSDT(Integer.parseInt(txtSoDienThoaiKhachHang.getText()));
        kh.setEmail(txtEmailKhachHang.getText());
        if (rdoCo.isSelected()) {
            kh.setThanhVien("Có");

        } else {
            kh.setThanhVien("Không");
        }
        return kh;
    }

    SanPham getFormSP() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSanPham.getText());
        sp.setTenSP(txtTensanpham.getText());
        sp.setKichThuoc(Integer.valueOf(txtKichco.getText()));
        sp.setGiaBan(Double.valueOf(txtDonGiaBan.getText()));
        sp.setChuThich(ghiChuSP.getText());
        sp.setImage(lblhinhSP.getToolTipText());
        sp.setTenLoai(cbDanhMucSP.getSelectedItem().toString());
        return sp;
    }

    void delete() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            xoaKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            xoaSP();
        }
    }

    void xoaKH() {
        String makh = txtMaKhachHang.getText();

        try {
            khDao.delete(makh);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Xóa khách hàng thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại!");
        }
    }

    void xoaSP() {
        String masp = txtMaSanPham.getText();

        try {
            SpDao.delete(masp);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Xóa sản phẩm đó thành công!");
        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Xóa thất bại!");
        }
    }

    void setFormKhachHang(KhachHang kh) {
        txtMaKhachHang.setText(kh.getMaKH());
        txtTenKhachHang.setText(kh.getTenKH());
        txtDiaChiKhachHang.setText(kh.getDiaChi());
        txtSoDienThoaiKhachHang.setText(String.valueOf(kh.getSDT()));
        if (kh.getThanhVien() == null) {
            rdoKhong.setSelected(true);
        } else {
            rdoCo.setSelected(kh.getThanhVien().equalsIgnoreCase("Có"));
            rdoKhong.setSelected(kh.getThanhVien().equalsIgnoreCase("Không"));

        }
        txtEmailKhachHang.setText(kh.getEmail());
    }

    void setFormSanPham(SanPham sp) {
        txtMaSanPham.setText(sp.getMaSP());
        txtTensanpham.setText(sp.getTenSP());
        txtKichco.setText(String.valueOf(sp.getKichThuoc()));
        txtDonGiaBan.setText(String.valueOf(sp.getGiaBan()));
        ghiChuSP.setText(sp.getChuThich());
        if (sp.getImage() != null) {
            lblhinhSP.setToolTipText(sp.getImage());
            ImageIcon iconN = XImage.read(sp.getImage());
            Image img = iconN.getImage().getScaledInstance(lblhinhSP.getWidth(), lblhinhSP.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblhinhSP.setIcon(icon);
        }
        else{
            lblhinhSP.setIcon(null);
        }
        String tenloai = sp.getTenLoai();
        for (int i = 0; i < cbDanhMucSP.getItemCount(); i++) {
            String item = (String) cbDanhMucSP.getItemAt(i);
            if (item != null && item.equals(tenloai)) {
                cbDanhMucSP.setSelectedItem(item);
                return;
            }
        }

    }

    void insert() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            themKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            themSP();
        }
    }

    void themKH() {
        KhachHang kh = this.getFormKH();
        try {
            khDao.insert(kh); // thêm mới
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void themSP() {
        SanPham sp = this.getFormSP();
        try {
            SpDao.insert(sp); // thêm mới
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            suaKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            suaSP();
        }
    }

    void suaKH() {
        KhachHang kh = this.getFormKH();

        try {
            khDao.update(kh); // cập nhật
            this.fillTable(); // đổ lại bảng
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }
//    void exportTableToExcel(JTable tb, String filePath) {
//        try (Workbook workB = new XSSFWorkbook()) {
//            CellStyle styleTieuDe = workB.createCellStyle();
//            styleTieuDe.setBorderBottom(BorderStyle.HAIR);
//            styleTieuDe.setBorderLeft(BorderStyle.HAIR);
//            styleTieuDe.setBorderTop(BorderStyle.HAIR);
//            styleTieuDe.setBorderRight(BorderStyle.HAIR);
//            styleTieuDe.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
//            styleTieuDe.setAlignment(HorizontalAlignment.CENTER);
//            styleTieuDe.setVerticalAlignment(VerticalAlignment.CENTER);
//            styleTieuDe.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//            //
//            CellStyle styleNoiD = workB.createCellStyle();
//            styleNoiD.setBorderBottom(BorderStyle.MEDIUM);
//            styleNoiD.setBorderLeft(BorderStyle.MEDIUM);
//            styleNoiD.setBorderTop(BorderStyle.MEDIUM);
//            styleNoiD.setBorderRight(BorderStyle.MEDIUM);
//            styleNoiD.setAlignment(HorizontalAlignment.CENTER);
//            styleNoiD.setVerticalAlignment(VerticalAlignment.CENTER);
//            Sheet sheet = workB.createSheet("Sheet 1");
//            //
//            Row headerR = sheet.createRow(0);
//            for (int i = 0; i < tb.getColumnCount(); i++) {
//                sheet.setColumnWidth(i, 5500);
//
//                Cell cell = headerR.createCell(i);
//                cell.setCellValue(tb.getColumnName(i));
//                cell.setCellStyle(styleTieuDe);
//            }
//            //
//            for (int i = 0; i < tb.getRowCount(); i++) {
//                Row row = sheet.createRow(i + 1);
//
//                for (int j = 0; j < tb.getColumnCount(); j++) {
//                    Cell cell = row.createCell(j);
//                    cell.setCellValue(String.valueOf(tb.getValueAt(i, j)));
//                    cell.setCellStyle(styleNoiD);
//                }
//            }
//            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
//                workB.write(outputStream);
//                MsgBox.alert(this, "Xuất file Excell thành công!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    void deleteExcelFile(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
//                MsgBox.alert(this, "File Excel đã được xóa thành công!");
            } else {
                MsgBox.alert(this, "File Excel Đang mở!");

            }
        } else {
            MsgBox.alert(this, "File Excel không tồn tại.");
        }
    }

    void suaSP() {
        SanPham sp = this.getFormSP();

        try {
            SpDao.update(sp); // cập nhật
            this.fillTable(); // đổ lại bảng
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            System.out.println(e);
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    public void clearForm() {
        if (lblTDTrang.getText().equals("QUẢN LÍ KHÁCH HÀNG")) {
            xoaFKH();
        } else if (lblTDTrang.getText().equals("QUẢN LÍ SẢN PHẨM")) {
            xoaFSP();
        }
    }

    void xoaFKH() {
        KhachHang kh = new KhachHang();
        this.setFormKhachHang(kh);
        this.row = -1;
        this.updateStatus();
    }

    void xoaFSP() {
        SanPham sp = new SanPham();
        this.setFormSanPham(sp);
        this.row = -1;
        this.updateStatus();
    }

    public boolean validateFormSP() {
        if (txtMaSanPham.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập mã sản phẩm!");
            txtMaSanPham.requestFocus();
            return false;

        } else if (txtTensanpham.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập tên sản phẩm!");
            txtTensanpham.requestFocus();
            return false;
        } else if (txtKichco.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập size sản phẩm!");
            txtKichco.requestFocus();
            return false;
        } else if (txtDonGiaBan.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập giá sản phẩm!");
            txtDonGiaBan.requestFocus();
            return false;
        } else if (txtKichco.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập size sản phẩm!");
            txtKichco.requestFocus();
            return false;
        } else if (lblhinhSP.getIcon() == null) {
            MsgBox.alert(this, "Chưa chọn ảnh sản phẩm!");
            lblhinhSP.requestFocus();
            return false;
        }

        return true;
    }

    public boolean validateFormKH() {
        if (txtMaKhachHang.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập mã khách hàng!");
            txtMaKhachHang.requestFocus();
            return false;

        } else if (txtTenKhachHang.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập tên khách hàng!");
            txtTenKhachHang.requestFocus();
            return false;

        } else if (txtSoDienThoaiKhachHang.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập số điện thoại khách hàng!");
            txtSoDienThoaiKhachHang.requestFocus();
            return false;

        } else if (txtDiaChiKhachHang.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập địa chỉ khách hàng!");
            txtDiaChiKhachHang.requestFocus();
            return false;

        } else if (txtEmailKhachHang.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập email khách hàng!");
            txtEmailKhachHang.requestFocus();
            return false;

        }

        if (rdoCo.isSelected()) {
            MsgBox.alert(this, "Bạn có chắc chắc khách hàng này làm thành viên!");

        } else {
            rdoKhong.requestFocus();
            return false;

        }
        return true;
    }
// END Chuc Nang FormKhachHang


    //----------------------------chức năng hóa đơn---------------------------------
    HoaDonDAO hdDao = new HoaDonDAO();

    void inithoadon() {
        this.fillTablehoadon();// đổ dữ liệu nhân viên vào bảng
        this.updateStatushoadon();// cập nhật trạng thái form
    }


    void updateStatushoadon() {
        boolean edithd = (this.row >= 0);
        // Trạng thái form
        txtMaHD.setEditable(!edithd);
        btnThemMoi.setEnabled(!edithd);
        btnSua.setEnabled(edithd);
        btnXoa.setEnabled(edithd);

    }
    
    void edithoadon() {
        String MaHD = (String) BangHoaDon.getValueAt(this.row, 0);
        HoaDon hd = hdDao.selectById(MaHD);
        this.setFormhoadon(hd);
        this.updateStatushoadon();
    }

    void fillTablehoadon() {
        DefaultTableModel model = (DefaultTableModel) BangHoaDon.getModel();
        model.setRowCount(0);
        try {
            List<HoaDon> list = hdDao.selectAll();
            for (HoaDon hd : list) {
                Object[] row = {
                    hd.getMaHD(),
                    hd.getMaSP(),
                    hd.getTenSP(),
                    hd.getDonGia(),
                    hd.getSoLuong(),
                    hd.getMaKH(),
                    hd.getThanhTien()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    HoaDon getFormhoadon() {
        HoaDon hd = new HoaDon();
        hd.setMaHD(txtMaHD.getText());
        hd.setMaSP(cboLoaiSanPham.getSelectedItem().toString());
        hd.setTenSP(cboTenSanPham.getSelectedItem().toString());
        hd.setDonGia(Double.parseDouble(txtDonGia.getText()));
        hd.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        hd.setMaKH(txtmaKH.getText());
        hd.setThanhTien(Double.parseDouble(txtThanhTien.getText()));
        
        return hd;
    }

    void deletehoadon() {

        String Mahd = txtMaHD.getText();

        try {
            hdDao.delete(Mahd);
            this.fillTablehoadon();
            this.clearFormhoadon();
            MsgBox.alert(this, "Xóa khách hàng thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại!");
        }

    }

//    void setFormhoadon(HoaDon hd) {
//        txtMaHD.setText(hd.getMaHD());
//        cboLoaiSanPham.setSelectedItem(hd.getMaSP());
//        cboTenSanPham.setSelectedItem(hd.getTenSP());
//        txtDonGia.setText(String.valueOf(hd.getDonGia()));
//        txtSoLuong.setText(Integer.toString(hd.getSoLuong()));
//        txtmaKH.setText(hd.getMaKH());
//        txtThanhTien.setText(String.valueOf(hd.getThanhTien()));
//    }
    void setFormhoadon(HoaDon hd) {
        txtMaHD.setText(hd.getMaHD());
        cboLoaiSanPham.setSelectedItem(hd.getMaSP());
        cboTenSanPham.setSelectedItem(hd.getTenSP());

        // Lắng nghe sự kiện thay đổi số lượng
        txtSoLuong.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateThanhTien();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateThanhTien();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateThanhTien();
            }
        });
        // Lắng nghe sự kiện thay đổi đơn giá
        txtDonGia.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateThanhTien();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateThanhTien();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateThanhTien();
            }
        });
        txtDonGia.setText(String.valueOf(hd.getDonGia()));
        txtSoLuong.setText(Integer.toString(hd.getSoLuong()));
        txtmaKH.setText(hd.getMaKH());
        txtThanhTien.setText(String.valueOf(hd.getThanhTien()));
    }

// Phương thức cập nhật giá trị thành tiền
    void updateThanhTien() {
        String strDonGia = txtDonGia.getText();
        String strSoLuong = txtSoLuong.getText();

        if (!strDonGia.isEmpty() && !strSoLuong.isEmpty()) {
            double donGia = Double.parseDouble(strDonGia);
            int soLuong = Integer.parseInt(strSoLuong);

            double thanhTien = donGia * soLuong;
            txtThanhTien.setText(String.valueOf(thanhTien));
        }
    }
    
    void inserthoadon() {
        HoaDon hd = this.getFormhoadon();

        try {
            hdDao.insert(hd); // thêm mới
            this.fillTablehoadon();// đỗ lại bảng
            this.clearFormhoadon();// xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }

    }

    void updatehoadon() {
        HoaDon hd = this.getFormhoadon();

        try {
            hdDao.update(hd); // cập nhật
            this.fillTablehoadon();// đổ lại bảng
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }

    }

    public void clearFormhoadon() {
//        HoaDon hd = this.getFormhoadon();
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtMaHD.setText("");
        txtmaKH.setText("");
        txtThanhTien.setText("");
        
//        this.setFormhoadon(hd);
//        this.row = -1;
//        this.updateStatushoadon();
        boolean edithd = (this.row >= 0);
        txtMaHD.setEditable(edithd);
        btnThemMoi.setEnabled(edithd);
        btnSua.setEnabled(!edithd);
        btnXoa.setEnabled(!edithd);
    }
    
    //--------------------------thống kê doanh thu------------------------------
    private void fillTableTKSanPham()
    {
        DefaultTableModel model= (DefaultTableModel) BangThongKeSanPham.getModel();
        model.setRowCount(0);
        List<Object[]> list= tkDao.getSanPhamTheoLoai();
        for (Object[] rows : list) {
            model.addRow(rows);
        }
    }
    
    private void fillTableTkHoaDon()
    {
        DefaultTableModel model= (DefaultTableModel) BangThongKeHoaDon.getModel();
        model.setRowCount(0);
        List<Object[]> list= tkDao.getThongKe_HoaDonTheoNhanVien();
        for (Object[] objects : list) {
            model.addRow(objects);
        }
    }
    
    
    // Trong class thongKeDAO
public void updateLabels() {
    try {
        // Giả sử getThongKe_KhachHangThanhVien và getThongKe_TongDoanhThu trả về giá trị mong muốn từ DB
        List<Object[]> resultSoLuongThanhVien = tkDao.getThongKe_KhachHangThanhVien();
        List<Object[]> resultTongDoanhThu = tkDao.getThongKe_TongDoanhThu();

        // Xác định index của cột chứa dữ liệu mong muốn trong kết quả
        int indexSoLuongThanhVien = 0; // Ví dụ cột soluongthanhvien
        int indexTongDoanhThu = 0; // Ví dụ cột tongdoanhthu

        // Lấy dữ liệu từ kết quả và cập nhật lên các nhãn
        if (resultSoLuongThanhVien != null && !resultSoLuongThanhVien.isEmpty()) {
            Object[] dataSoLuongThanhVien = resultSoLuongThanhVien.get(0); // Giả sử chỉ có một dòng trả về
            if (dataSoLuongThanhVien.length > indexSoLuongThanhVien) {
                lblSoLuongThanhVien.setText(String.valueOf(dataSoLuongThanhVien[indexSoLuongThanhVien]));
            }
        }

        if (resultTongDoanhThu != null && !resultTongDoanhThu.isEmpty()) {
            Object[] dataTongDoanhThu = resultTongDoanhThu.get(0); // Giả sử chỉ có một dòng trả về
            if (dataTongDoanhThu.length > indexTongDoanhThu) {
                lblTongDoanhThu.setText(String.valueOf(dataTongDoanhThu[indexTongDoanhThu]));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        trangchu tt = new trangchu();
//        dangnhap dn = new dangnhap();
//        dn.setVisible(true);
    }

    
}
