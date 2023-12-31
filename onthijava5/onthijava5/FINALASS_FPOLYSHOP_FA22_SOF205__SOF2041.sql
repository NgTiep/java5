﻿CREATE DATABASE FINALASS_FPOLYSHOP_SOF3021
GO
USE FINALASS_FPOLYSHOP_SOF3021
GO
-- ChucVu
CREATE TABLE ChucVu(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL
)
GO
-- CuaHang
CREATE TABLE CuaHang(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL
)
GO
-- NhanVien
CREATE TABLE NhanVien(-------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30) DEFAULT NULL,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
GioiTinh NVARCHAR(10) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL,
IdCH UNIQUEIDENTIFIER,
IdCV UNIQUEIDENTIFIER,
IdGuiBC UNIQUEIDENTIFIER,
TrangThai INT DEFAULT 0
)
GO
-- KhachHang
CREATE TABLE KhachHang(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL
)
GO
--HoaDon
CREATE TABLE HoaDon(------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
NgayShip DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
TinhTrang INT DEFAULT 0,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
)
GO
CREATE TABLE GioHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
TinhTrang INT DEFAULT 0
)
GO
-- SanPham
CREATE TABLE SanPham(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- NSX
CREATE TABLE NSX(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- MauSac
CREATE TABLE MauSac(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- DongSP
CREATE TABLE DongSP(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
GO
-- ChiTietSP
CREATE TABLE ChiTietSP(------------------------------------------------------------------------
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdSP UNIQUEIDENTIFIER,
IdNsx UNIQUEIDENTIFIER,
IdMauSac UNIQUEIDENTIFIER,
IdDongSP UNIQUEIDENTIFIER,
NamBH INT DEFAULT NULL,
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
)

GO
-- HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(-----------------------------------------------------------
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_HoaDonCT PRIMARY KEY (IdHoaDon,IdChiTietSP),
CONSTRAINT FK1 FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id) ,
CONSTRAINT FK2 FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
-- GioHangChiTiet
CREATE TABLE GioHangChiTiet(
IdGioHang UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_GioHangCT PRIMARY KEY (IdGioHang,IdChiTietSP),
CONSTRAINT FK1_IdGioHang FOREIGN KEY(IdGioHang) REFERENCES GioHang(Id),
CONSTRAINT FK2_IdChiTietSP FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - CuaHang
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCH) REFERENCES CuaHang(Id)
--NhanVien - ChucVu
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)
--NhanVien - GuiBaoCao
ALTER TABLE NhanVien ADD FOREIGN KEY (IdGuiBC) REFERENCES NhanVien(Id)
-- HoaDon - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- GioHang - KhachHang
ALTER TABLE GioHang ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id)
-- ChiTietSP - SanPham
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdSP) REFERENCES SanPham(Id)
-- ChiTietSP - NSX
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdNsx) REFERENCES Nsx(Id)
-- ChiTietSP - MauSac
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
-- ChiTietSP - DongSP
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdDongSP) REFERENCES DongSP(Id)




SELECT * FROM SanPham
INSERT INTO SanPham (Id,Ma, Ten) VALUES ('18FD440B-1FC8-4825-99F1-0A05F5D0B128','SP1', 'IPhone 11');
INSERT INTO SanPham (Id,Ma, Ten) VALUES ('738E10B3-EC05-4678-950E-4742B0447A1D','SP2', 'SamSung Galaxy S22');
INSERT INTO SanPham (Id,Ma, Ten) VALUES ('785FE540-053E-45F6-A412-50C5D85DF97A','SP3', 'Oppo Neo 3');
INSERT INTO SanPham (Id,Ma, Ten) VALUES ('CEC1FABA-AE32-44CD-96F2-6E139E84BDF6','SP4', 'Xiaomi Redmi note 11');


SELECT * FROM ChucVu
INSERT INTO ChucVu (Id,Ma, Ten) VALUES ('968860A9-22A1-484D-B61C-3E7E178B4EEA','CV1', N'Giám đốc');
INSERT INTO ChucVu (Id,Ma, Ten) VALUES ('44B65F74-23C0-405D-8AD7-7213C67FDC38','CV2', N'Nhân Viên Quèn');
INSERT INTO ChucVu (Id,Ma, Ten) VALUES ('87F9593A-E08B-4943-8719-73B1B9BE7D6E','CV3', N'Lao công');
INSERT INTO ChucVu (Id,Ma, Ten) VALUES ('379E01D1-0068-478C-BEC9-F5CBA24E819B','CV4', N'Thư kí');



SELECT * FROM CuaHang
INSERT INTO CuaHang (Id,Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES ('DCFCBB35-8F2D-47B7-A25F-7F2253649786','CH1','Legend of legue', N'FPT Polytechnic', N'Thái Bình', N'Việt Nam');
INSERT INTO CuaHang (Id,Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES ('421DDDF5-6803-47FC-BECC-95BD5A2CD641','CH2','Fifa online 4', N'FPT Polytechnic', N'Hà Nội', N'Việt Nam');
INSERT INTO CuaHang (Id,Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES ('66AEC142-B680-4393-ABCE-B896EA37BE69','CH3','PUBG', N'FPT Polytechnic', N'Thanh Hóa', N'Việt Nam');
INSERT INTO CuaHang (Id,Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES ('1F17733C-94A8-47D4-A3A2-FE01F042FDA5','CH4','Clas of clan', N'FPT Polytechnic', N'Thái Nguyên', N'Việt Nam');


SELECT * FROM MauSac
INSERT INTO MauSac (Id,Ma, Ten) VALUES ('24164B54-B76C-40BE-BE9F-0440740884F5','M1', N'Đỏ');
INSERT INTO MauSac (Id,Ma, Ten) VALUES ('45059119-12B1-4C2A-BC35-3B2DFD966359','M2', N'Vàng');
INSERT INTO MauSac (Id,Ma, Ten) VALUES ('69C99618-E4C8-4230-95CA-69DB85CF5244','M3', N'Xanh');
INSERT INTO MauSac (Id,Ma, Ten) VALUES ('6CFF1FFE-74D8-430B-B47B-B80B3CC13D6C','M4', N'Đen');


SELECT * FROM KhachHang
INSERT INTO KhachHang (Id,Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) VALUES ('7D303DDF-EC98-4253-AEB1-30C6577C41EE','KH1', N'Hoàng', N'Văn', N'Nguyễn', '05/20/1999', '0123456789', N'FPOLY', N'Tây Nguyên', N'Việt Nam', '123456');
INSERT INTO KhachHang (Id,Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) VALUES ('4E30C3E9-117A-4E89-B9F9-6A8B5DF547BD','KH2', N'Linh', N'Hải', N'Bùi', '05/20/1999', '0123456789', N'FPOLY', N'Thái Bình', N'Việt Nam', '123456');
INSERT INTO KhachHang (Id,Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) VALUES ('FE59A120-FEB6-4F85-A165-BF24F3591211','KH3', N'Huy', N'Quang', N'Trần', '05/20/1999', '0123456789', N'FPOLY', N'Hà Nội', N'Việt Nam', '123456');
INSERT INTO KhachHang (Id,Ma, Ten, TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau) VALUES ('55AF3F9F-06DB-411B-BFE4-C9D546708C10','KH4', N'Minh', N'Quang', N'Phạm', '05/20/1999', '0123456789', N'FPOLY', N'Bắc Ninh', N'Việt Nam', '123456');


SELECT * FROM DongSP
INSERT INTO DongSP (Id,Ma, Ten) VALUES ('5818BC6B-C6B9-460C-A33C-76A9B52A100F','DSP1', N'APPLE');
INSERT INTO DongSP (Id,Ma, Ten) VALUES ('FCCEF9D8-6BD5-4878-987C-DB2797CEBEEC','DSP2', N'SamSung');
INSERT INTO DongSP (Id,Ma, Ten) VALUES ('A816D882-2467-49FF-8AE6-E08BE58432BC','DSP3', N'Xiaomi');
INSERT INTO DongSP (Id,Ma, Ten) VALUES ('F92E69EB-FAB8-44B1-A1EC-FD9572DFE0D8','DSP4', N'BlackBerry');



SELECT * FROM NSX
INSERT INTO NSX (Id,Ma, Ten) VALUES ('7C1FA148-64E1-4F42-AEAF-24D7D9141360','NSX1', N'Alan Waker');
INSERT INTO NSX (Id,Ma, Ten) VALUES ('2E68A792-5F84-48BD-8847-480BC2C72131','NSX2', N'Martin Garrix');
INSERT INTO NSX (Id,Ma, Ten) VALUES ('DC074647-D962-4936-998A-5D3C233BC906','NSX3', N'DJ Snake');
INSERT INTO NSX (Id,Ma, Ten) VALUES ('EB23CE57-AB91-4A3A-8EB9-AF1F0F7B6FE9','NSX4', N'Onionn');




SELECT * FROM NhanVien
INSERT INTO NhanVien (Id,Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) VALUES ('63583E7E-A66A-4B0B-AE11-5ADCD28EB1E2','NV1',N'Tùng', N'Thanh', N'Trần', 'Nam', '06/09/2003',N'Thái Bình','0943670235', '123456', 'DCFCBB35-8F2D-47B7-A25F-7F2253649786', '968860A9-22A1-484D-B61C-3E7E178B4EEA', 1);
INSERT INTO NhanVien (Id,Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) VALUES ('789EED3F-0F00-479C-95B9-6F3FB36127F2','NV2',N'Hoàng', N'Huy', N'Nguyễn', 'Nam', '06/19/2003',N'Hà Nội','0943234434', '123456', '421DDDF5-6803-47FC-BECC-95BD5A2CD641', '44B65F74-23C0-405D-8AD7-7213C67FDC38', 0);
INSERT INTO NhanVien (Id,Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) VALUES ('D99E208E-7B04-4EFC-9C0F-93542C3D6821','NV3',N'Minh', N'Bình', N'Đinh', 'Nam', '06/09/1999',N'Nghệ An','0943622222', '123456', '66AEC142-B680-4393-ABCE-B896EA37BE69', '87F9593A-E08B-4943-8719-73B1B9BE7D6E', 1);
INSERT INTO NhanVien (Id,Ma, Ten, TenDem, Ho, GioiTinh, NgaySinh, DiaChi, Sdt, MatKhau, IdCH, IdCV, TrangThai) VALUES ('517A2ABE-C7CE-45FA-9DCF-951DD72AC5D3','NV4',N'Long', N'Hoàng', N'Vũ', 'Nam', '10/09/2000',N'Quảng Ninh','1234310235', '123456', '1F17733C-94A8-47D4-A3A2-FE01F042FDA5', '379E01D1-0068-478C-BEC9-F5CBA24E819B', 0);



SELECT * FROM GioHang
INSERT INTO GioHang (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) VALUES ('D8445DAE-BF63-425C-8B84-757854859D6B','7D303DDF-EC98-4253-AEB1-30C6577C41EE', '63583E7E-A66A-4B0B-AE11-5ADCD28EB1E2', 'GH1', '12/12/2022', '12/12/2022', N'Nguyên', N'Thái Bình', '0123456787', 1);
INSERT INTO GioHang (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) VALUES ('AD86C1DE-494A-4687-972F-79D4C5011DD8','4E30C3E9-117A-4E89-B9F9-6A8B5DF547BD', '789EED3F-0F00-479C-95B9-6F3FB36127F2', 'GH2', '12/12/2022', '12/13/2022', N'Thái', N'Nha Trang', '0456756787', 0);
INSERT INTO GioHang (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) VALUES ('0108F630-E4F4-4B3A-901E-BC5FC27B6171','FE59A120-FEB6-4F85-A165-BF24F3591211', 'D99E208E-7B04-4EFC-9C0F-93542C3D6821', 'GH3', '12/12/2022', '12/12/2022', N'Dương', N'Yên Bái', '0333336787', 1);
INSERT INTO GioHang (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, TenNguoiNhan, DiaChi, Sdt, TinhTrang) VALUES ('9797FD0E-00EF-44CA-B2C4-EEC847B750A2','55AF3F9F-06DB-411B-BFE4-C9D546708C10', '517A2ABE-C7CE-45FA-9DCF-951DD72AC5D3', 'GH4', '12/12/2022', '12/15/2022', N'Hương', N'TP Hồ Chí Minh', '0213454587', 0);



SELECT * FROM ChiTietSP
INSERT INTO ChiTietSP (Id,IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) VALUES ('323420F7-DA4E-4613-A09E-4871F15AE8E7','18FD440B-1FC8-4825-99F1-0A05F5D0B128', '7C1FA148-64E1-4F42-AEAF-24D7D9141360', '24164B54-B76C-40BE-BE9F-0440740884F5', '5818BC6B-C6B9-460C-A33C-76A9B52A100F', 4, N'Sản phẩm không phải là thuốc', 20, 200, 400);
INSERT INTO ChiTietSP (Id,IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) VALUES ('2365469E-D3A8-4A32-9F4A-55A5056CA6D1','738E10B3-EC05-4678-950E-4742B0447A1D', '2E68A792-5F84-48BD-8847-480BC2C72131', '45059119-12B1-4C2A-BC35-3B2DFD966359', 'FCCEF9D8-6BD5-4878-987C-DB2797CEBEEC', 5, N'Sản phẩm được sản xuất bởi những người nghiện', 40, 100, 200);
INSERT INTO ChiTietSP (Id,IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) VALUES ('DB34DB7F-083B-4D95-8F31-8AF30A6A21B0','785FE540-053E-45F6-A412-50C5D85DF97A', 'DC074647-D962-4936-998A-5D3C233BC906', '69C99618-E4C8-4230-95CA-69DB85CF5244', 'A816D882-2467-49FF-8AE6-E08BE58432BC', 5, N'Sản phẩm được tái chế từ rác', 40, 70, 180);
INSERT INTO ChiTietSP (Id,IdSP, IdNsx, IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan) VALUES ('57DEFD95-30D9-4B7D-B484-AEDEBC8FA6C7','CEC1FABA-AE32-44CD-96F2-6E139E84BDF6', 'EB23CE57-AB91-4A3A-8EB9-AF1F0F7B6FE9', '6CFF1FFE-74D8-430B-B47B-B80B3CC13D6C', 'F92E69EB-FAB8-44B1-A1EC-FD9572DFE0D8', 3, N'Sản phẩm được sản xuất bởi những người nghiện', 30, 200, 300);




INSERT INTO HoaDon (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt) VALUES ('ECCA0BC2-7BE5-4E57-83E0-091F7E558631','7D303DDF-EC98-4253-AEB1-30C6577C41EE','63583E7E-A66A-4B0B-AE11-5ADCD28EB1E2', 'HD1', '04/04/2022','04/05/2022','04/06/2022', '04/07/2022', 1, N'Khải', N'Vĩnh Phúc', '09876543212');
INSERT INTO HoaDon (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt) VALUES ('A80A1FFB-3F73-4854-9148-9527DE0176AE','4E30C3E9-117A-4E89-B9F9-6A8B5DF547BD','789EED3F-0F00-479C-95B9-6F3FB36127F2', 'HD2', '04/04/2022','04/05/2022','04/06/2022', '04/07/2022', 0, N'Nhi', N'Quảng Trị', '09874444412');
INSERT INTO HoaDon (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt) VALUES ('83456459-46F6-49EB-965E-A535C43D0A7B','FE59A120-FEB6-4F85-A165-BF24F3591211','D99E208E-7B04-4EFC-9C0F-93542C3D6821', 'HD3', '04/04/2022','04/05/2022','04/06/2022', '04/07/2022', 1, N'Tuấn', N'Sài Gòn', '09876333332');
INSERT INTO HoaDon (Id,IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan, TinhTrang, TenNguoiNhan, DiaChi, Sdt) VALUES ('946789E1-1303-4BA8-A229-AB4D6B03A360','55AF3F9F-06DB-411B-BFE4-C9D546708C10','517A2ABE-C7CE-45FA-9DCF-951DD72AC5D3', 'HD4', '04/04/2022','04/05/2022','04/06/2022', '04/07/2022', 0, N'Thảo', N'Tam Đảo', '09876555552');
select * from HoaDon


INSERT INTO HoaDonChiTiet (IdHoaDon, IdChiTietSP, SoLuong, DonGia) VALUES ('ECCA0BC2-7BE5-4E57-83E0-091F7E558631', '323420F7-DA4E-4613-A09E-4871F15AE8E7', 6, 100);
INSERT INTO HoaDonChiTiet (IdHoaDon, IdChiTietSP, SoLuong, DonGia) VALUES ('A80A1FFB-3F73-4854-9148-9527DE0176AE', '2365469E-D3A8-4A32-9F4A-55A5056CA6D1', 7, 200);
INSERT INTO HoaDonChiTiet (IdHoaDon, IdChiTietSP, SoLuong, DonGia) VALUES ('83456459-46F6-49EB-965E-A535C43D0A7B', 'DB34DB7F-083B-4D95-8F31-8AF30A6A21B0', 5, 300);
INSERT INTO HoaDonChiTiet (IdHoaDon, IdChiTietSP, SoLuong, DonGia) VALUES ('946789E1-1303-4BA8-A229-AB4D6B03A360', '57DEFD95-30D9-4B7D-B484-AEDEBC8FA6C7', 8, 400);
select * from HoaDonChiTiet


INSERT INTO GioHangChiTiet (IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES ('D8445DAE-BF63-425C-8B84-757854859D6B', '323420F7-DA4E-4613-A09E-4871F15AE8E7', 5, 300, 200);
INSERT INTO GioHangChiTiet (IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES ('AD86C1DE-494A-4687-972F-79D4C5011DD8', '2365469E-D3A8-4A32-9F4A-55A5056CA6D1', 4, 200, 180);
INSERT INTO GioHangChiTiet (IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES ('0108F630-E4F4-4B3A-901E-BC5FC27B6171', 'DB34DB7F-083B-4D95-8F31-8AF30A6A21B0', 5, 300, 150);
INSERT INTO GioHangChiTiet (IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam) VALUES ('9797FD0E-00EF-44CA-B2C4-EEC847B750A2', '57DEFD95-30D9-4B7D-B484-AEDEBC8FA6C7', 6, 400, 200);
select * from GioHangChiTiet


