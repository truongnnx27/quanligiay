CREATE DATABASE DuAn1_Polyy;
GO
USE DuAn1_Polyy;
GO
CREATE TABLE NhanVien (
  MaNV NVARCHAR(20) PRIMARY KEY,
  TenNV NVARCHAR(50),
  MatKhau NVARCHAR(50),
  GioiTinh BIT,
  NgaySinh DATE,
  VaiTro BIT,
  Email NVARCHAR(50),
  GhiChu NVARCHAR(50)
);

-- Tạo bảng Khách hàng
CREATE TABLE KhachHang (
  MaKH NVARCHAR(20) PRIMARY KEY,
  TenKH NVARCHAR(50),
  DiaChi NVARCHAR(50),
  SDT NVARCHAR(20),
  Email NVARCHAR(50),
  ThanhVien BIT
);

CREATE TABLE LoaiSanPham (
  MaLoaiSP NVARCHAR(20) PRIMARY KEY,
  TenLoaiSanPham NVARCHAR(50)
);

-- Tạo bảng Sản phẩm
CREATE TABLE SanPham (
  MaSP NVARCHAR(20) PRIMARY KEY,
  TenSP NVARCHAR(50),
  MaLoaiSP NVARCHAR(20),
  Size NVARCHAR(20),
  GiaBan DECIMAL(10, 2),
  HinhAnh NVARCHAR(50),
  GhiChu nvarchar(50)
  FOREIGN KEY (MaLoaiSP) REFERENCES LoaiSanPham(MaLoaiSP)
);

-- Tạo bảng Hóa đơn
CREATE TABLE HoaDon (
  MaHD NVARCHAR(20) PRIMARY KEY,
  MaNV NVARCHAR(20),
  MaKH NVARCHAR(20),
  MaSP NVARCHAR(20),
  TenSP NVARCHAR(50),
  DonGia  DECIMAL(10, 2),
  Soluong INT,
  ThanhTien DECIMAL(10, 2),
  HinhAnh NVARCHAR(50),
  FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
  FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
--  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

INSERT INTO HoaDon (MaHD, manv, MaKH, MaSP, TenSP, DonGia, Soluong, ThanhTien, HinhAnh)
VALUES
--('HD001', 'NV001', 'KH001', 'SP001', N'Giày thể thao nam', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
('HD002', 'NV002', 'KH002', 'SP002', N'Giày thể thao nữ', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
('HD003', 'NV003', 'KH003', 'SP003', N'Giày thể thao học sinh', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
('HD004', 'NV004', 'KH004', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
('HD005', 'NV005', 'KH005', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg'),
('HD006', 'NV006', 'KH006', 'SP001', N'Giày nike', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
('HD007', 'NV002', 'KH007', 'SP002', N'Giày adisdas', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
('HD008', 'NV007', 'KH008', 'SP003', N'Giày thể duc', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
('HD009', 'NV004', 'KH009', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
('HD010', 'NV005', 'KH010', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg'),
('HD011', 'NV001', 'KH011', 'SP001', N'Giày thể thao nam', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
('HD012', 'NV002', 'KH012', 'SP002', N'Giày thể thao nữ', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
('HD013', 'NV003', 'KH013', 'SP003', N'Giày thể thao học sinh', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
('HD014', 'NV004', 'KH014', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
('HD015', 'NV005', 'KH015', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg');

select * from hoadon

DELETE FROM HoaDon WHERE MaHD='?';
-- Kiểm tra và thêm MaNV vào bảng NhanVien nếu không tồn tại
IF NOT EXISTS (SELECT 1 FROM NhanVien WHERE MaNV = 'NV001')
BEGIN
    INSERT INTO NhanVien (MaNV, TenNV, MatKhau, GioiTinh, NgaySinh, VaiTro, Email, GhiChu)
    VALUES 
	(N'NV001', 'Admin', '123456', 0, '2003-01-01', 1, N'Admin@gmail.com', N'Quản lý'),
    (N'NV002', 'Nunv', '654321', 1, '2004-05-10', 1, N'nu@gmail.com', N'Quản lý'),
    (N'NV003', 'Baonv', 'abcdef', 0, '2002-03-15', 0, N'bao@gmail.com', N'Nhân viên '),
    (N'NV004', 'Truongnv', 'xyz123',0, '1994-07-20', 0, N'truong@gmail.com', N'Nhân viên '),
    (N'NV005', 'Khangnv', 'qwerty',0, '1991-12-05', 0, N'khang@gmail.com', N'Nhân viên '),
    (N'NV006', 'Tinnv', 'password', 0, '1993-08-30', 0, N'tin@gmail.com', N'Nhân viên '),
    (N'NV007', 'Hoangnv', 'abc123', 0, '1996-06-25', 0, N'hoang@gmail.com', N'Nhân viên ')
END;

-- Kiểm tra và thêm MaKH vào bảng KhachHang nếu không tồn tại
IF NOT EXISTS (SELECT 1 FROM KhachHang WHERE MaKH = 'KH001')
BEGIN
    INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SDT, Email, ThanhVien)
    VALUES 
	  ('KH001', N'Phạm văn Đồng',   N'Ha Noi', '0123456789', N'acb@gmail.com', 1),
	  ('KH002', N'Nguyễn Xuân Hoa',   N'Ho Chi Minh', '0987654321',N'Akk@gmail.com', 0),
	  ('KH003', N'Đại Thất Bé',   N'Da Nang', '0123456789', N'min@gmail.com', 1),
	  ('KH004', N'Phan Như Ngọc ',   N'Hai Phong', '0987654321', N'uin@gmail.com', 1),
	  ('KH005', N'Hoàng Lưu Trung',   N'Can Tho', '0123456789', N'bvn@gmail.com', 1),
	  ('KH006', N'Võ Hoa Đào',   N'Hue', '0987654321', N'asn@gmail.com', 1),
	  ('KH007', N'Trương Văn Bích',   N'Quang Ninh', '0123456789',N'cc@gmail.com', 0),
	  ('KH008', N'Ngô Hà Thi',   N'Bac Giang', '0987654321',N'vlc@gmail.com', 1),
	  ('KH009', N'Đăng Nhất Bảng',   N'Vinh Phuc', '0123456789', N'ghs@gmail.com', 1),
	  ('KH010', N'Bùi Hữu Duyên',   N'Yen Bai', '0987654321', N'ren@gmail.com', 1),
	  ('KH011', N'Lê Văn Lợi',   N'Lang Son', '0123456789', N'ksj@gmail.com', 0),
	  ('KH012', N'Nguyễn Thị Tuyết',  N'Phu Tho', '0987654321', N'asn@gmail.com',1),
	  ('KH013', N'Trần Hoàng Hồ',   N'Thai Nguyen', '0123456789', N'rrmin@gmail.com',1),
	  ('KH014', N'Lê Thị Mai', N'Nam Dinh', '0987654321',N'ooin@gmail.com', 1),
	  ('KH015', N'Nguyễn Như Ngọc',   N'Thanh Hoa', '0123456789',N'yyn@gmail.com', 1);
END;

-- Kiểm tra và thêm MaSP vào bảng SanPham nếu không tồn tại
IF NOT EXISTS (SELECT 1 FROM SanPham WHERE MaSP = 'SP001')
BEGIN
    INSERT INTO SanPham (MaSP, TenSP, MaLoaiSP, Size, GiaBan, HinhAnh, GhiChu)
	VALUES 
		('SP001', N'Giày thể thao nam', N'LSP001', '34', 300000,'dalo.jpg','Có'),
		('SP002', N'Giày thể thao nữ', N'LSP001', '44', 150000, N'giay_thethao_nu.jpg','Có'),
		('SP003', N'Giày thể thao học sinh', N'LSP001', '35', 150000, N'giay_thethao_hs.jpg', 'Có'),
		('SP004', N'Giày Penny Loafer', N'LSP002', '41', 150000, N'giay_Penny_Loafer.jpg', 'Có'),
		('SP005', N'Giày Tassel Loafer', N'LSP002', '40', 200000,  N'giay_Tassel_Loafer.jpg','Có'),
		('SP006', N'Giày Horsebit Loafer', N'LSP002', '30', 450000, N'giay_Horsebit_Loafer.jpg','Có'),
		('SP007', N'Giày Slipper Loafer', N'LSP002', '45', 250000, N'giay_Slipper_Loafer.jpg', 'Có'),
		('SP008', N'Giày Sneaker High – top', N'LSP003', '34', 750000, N'giay_Sneaker_High_top.jpg', 'Có'),
		('SP009', N'Giày Sneaker Mule', N'LSP003', '33', 220000, N'giay_Sneaker_Mule.jpg', 'Có'),
		('SP0010', N'Giày Sneaker Low – top', N'LSP003', '44', 550000, N'giay_Sneaker_Low_top.jpg', 'Có');
END;

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaHD, MaNV, MaKH, MaSP, TenSP, DonGia, Soluong, ThanhTien, HinhAnh)
VALUES 
	('HD001', 'NV001', 'KH001', 'SP001', N'Giày thể thao nam', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
	('HD002', 'NV002', 'KH002', 'SP002', N'Giày thể thao nữ', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
	('HD003', 'NV003', 'KH003', 'SP003', N'Giày thể thao học sinh', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
	('HD004', 'NV004', 'KH004', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
	('HD005', 'NV005', 'KH005', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg'),
	('HD006', 'NV001', 'KH006', 'SP001', N'Giày nike', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
	('HD007', 'NV002', 'KH007', 'SP002', N'Giày adisdas', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
	('HD008', 'NV003', 'KH008', 'SP003', N'Giày thể duc', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
	('HD009', 'NV004', 'KH009', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
	('HD010', 'NV005', 'KH010', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg'),
	('HD011', 'NV001', 'KH011', 'SP001', N'Giày thể thao nam', 300000, 1, 300000, N'giay_thethao_nam.jpg'),
	('HD012', 'NV002', 'KH012', 'SP002', N'Giày thể thao nữ', 150000, 2, 300000, N'giay_thethao_nu.jpg'),
	('HD013', 'NV003', 'KH013', 'SP003', N'Giày thể thao học sinh', 150000, 1, 150000, N'giay_thethao_hs.jpg'),
	('HD014', 'NV004', 'KH014', 'SP004', N'Giày Penny Loafer', 150000, 1, 150000, N'giay_Penny_Loafer.jpg'),
	('HD015', 'NV005', 'KH015', 'SP005', N'Giày Tassel Loafer', 200000, 1, 200000, N'giay_Tassel_Loafer.jpg');

	-- thêm dữ liệu cho bảng Loại sản phẩm 
INSERT INTO LoaiSanPham (MaLoaiSP, TenLoaiSanPham) VALUES
(N'LSP001',N'Giày thể thao '),
(N'LSP002',N'Giày Loafer'),
(N'LSP003',N'Giày Seaker'),
(N'LSP004',N'Giày cao gót'),
(N'LSP005',N'Giày Sandal nữ'),
(N'LSP006',N'Giày đi trong nhà')

--thống kê sản phẩm theo loại
CREATE PROC ThongKe_SanPhamTheoLoai
AS
BEGIN
    SELECT MaLoaiSP, TenSP, COUNT(*) AS SoLuongSanPham
    FROM SanPham
    GROUP BY MaLoaiSP,TenSP
END;

--thống kê hóa đơn theo nhân viên 
CREATE PROC ThongKe_HoaDonTheoNhanVien
AS
BEGIN
    SELECT MaNV, COUNT(*) AS SoLuongHoaDon
    FROM HoaDon
    GROUP BY MaNV
END;


--thống kê khách hàng thành viên
CREATE PROC ThongKe_KhachHangThanhVien
AS
BEGIN
    SELECT COUNT(*) AS SoLuongThanhVien
    FROM KhachHang
    WHERE ThanhVien = 1
END;

--tổng doanh thu 
CREATE PROC ThongKe_TongDoanhThu
AS
BEGIN
    SELECT SUM(ThanhTien) AS TongDoanhThu
    FROM HoaDon
END;

select* from hoadon