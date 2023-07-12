CREATE DATABASE PTPM_FINALLY_JAVA_SOF3021_DEMO
USE [PTPM_FINALLY_JAVA_SOF3021_DEMO]
GO

CREATE TABLE [dbo].[chi_tiet_hoa_don](
	[id] [uniqueidentifier] NOT NULL,
	[hoa_don_id] [uniqueidentifier] NULL,
	[phong_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ngay_gio_nhan_phong] [date] NULL,
	[ngay_gio_tra_phong] [date] NULL,
	[thoi_gian_thue] [int] NULL,
	[gia_phong] [decimal](20, 0) NULL,
	[qua_gio] [float] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [chi_tiet_hoa_don_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chuc_vu]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chuc_vu](
	[id] [uniqueidentifier] NOT NULL,
	[phong_ban_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[ngay_bat_dau] [date] NULL,
	[ngay_ap_dung] [date] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [chuc_vu_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[co_so]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[co_so](
	[id] [uniqueidentifier] NOT NULL,
	[tai_khoan_ngan_hang_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten_co_so] [nvarchar](50) NULL,
	[ho_ten_nguoi_dai_dien] [nvarchar](50) NULL,
	[ma_so_thue] [varchar](20) NULL,
	[so_dien_thoai] [varchar](20) NULL,
	[email] [varchar](50) NULL,
	[ghi_chu] [nvarchar](100) NULL,
	[ten_tinh] [nvarchar](50) NULL,
	[ten_thanh_pho] [nvarchar](50) NULL,
	[ten_quan_huyen] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [co_so_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dat_phong]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dat_phong](
	[id] [uniqueidentifier] NOT NULL,
	[khach_hang_id] [uniqueidentifier] NULL,
	[loai_phong_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[ngay_gio_dat] [date] NULL,
	[so_luong_khach] [int] NULL,
	[so_luong_phong_dat] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [dat_phong_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dich_vu]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dich_vu](
	[id] [uniqueidentifier] NOT NULL,
	[loai_dich_vu_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[don_vi_tinh] [nvarchar](30) NULL,
	[don_gia] [decimal](20, 0) NULL,
	[mo_ta] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [dich_vu_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dich_vu_su_dung]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dich_vu_su_dung](
	[id] [uniqueidentifier] NOT NULL,
	[dich_vu_id] [uniqueidentifier] NULL,
	[chi_tiet_hoa_don_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[so_luong] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [dich_vu_su_dung_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[giao_dich]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giao_dich](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[hinh_thuc_thanh_toan] [int] NULL,
	[ngay_thanh_toan] [date] NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_sua] [date] NULL,
 CONSTRAINT [giao_dich_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[giao_han]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[giao_han](
	[id] [uniqueidentifier] NOT NULL,
	[tai_khoan_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[thoi_diem_bat_dau] [date] NULL,
	[thoi_diem_ket_thuc] [date] NULL,
	[so_tien_dau_ngay] [decimal](20, 0) NULL,
	[tong_tien_hoa_don] [decimal](20, 0) NULL,
	[tong_tien_tam_tinh] [decimal](20, 0) NULL,
	[tong_tien_thu_thue] [decimal](20, 0) NULL,
	[tong_tien_chenh_lech] [decimal](20, 0) NULL,
	[tong_tien_phat_sinh] [decimal](20, 0) NULL,
	[don_vi_tinh] [nvarchar](30) NULL,
	[trang_thai_thu_tien] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [giao_han_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don](
	[id] [uniqueidentifier] NOT NULL,
	[khach_hang_id] [uniqueidentifier] NULL,
	[tai_khoan_id] [uniqueidentifier] NULL,
	[giao_dich_id] [uniqueidentifier] NULL,
	[dat_phong_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[tien_khach_dua] [decimal](20, 0) NULL,
	[tien_tra_lai] [decimal](20, 0) NULL,
	[tien_coc] [decimal](20, 0) NULL,
	[phu_thu] [decimal](20, 0) NULL,
	[thue] [decimal](20, 0) NULL,
	[giam_gia] [decimal](20, 0) NULL,
	[tong_tien] [decimal](20, 0) NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [hoa_don_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ho] [nvarchar](20) NULL,
	[ten_dem] [nvarchar](20) NULL,
	[ten] [nvarchar](20) NULL,
	[gioi_tinh] [bit] NULL,
	[ngay_sinh] [date] NULL,
	[email] [varchar](50) NULL,
	[sdt] [varchar](11) NULL,
	[dia_chi] [nvarchar](100) NULL,
	[quoc_tich] [nvarchar](100) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [khach_hang_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lau]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lau](
	[id] [uniqueidentifier] NOT NULL,
	[co_so_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[so_luong] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [lau_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loai_dich_vu]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loai_dich_vu](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[mo_ta] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_sua] [date] NULL,
 CONSTRAINT [loai_dich_vu_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loai_phong]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loai_phong](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[don_gia_theo_gio] [decimal](20, 0) NULL,
	[don_gia_qua_ngay] [decimal](20, 0) NULL,
	[don_gia_qua_dem] [decimal](20, 0) NULL,
	[so_nguoi] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[tien_qua_gio] [decimal](20, 0) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [loai_phong_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[loai_phong_ban]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loai_phong_ban](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[so_luong] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_sua] [date] NULL,
 CONSTRAINT [loai_phong_ban_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phong](
	[id] [uniqueidentifier] NOT NULL,
	[loai_phong_id] [uniqueidentifier] NULL,
	[co_so_id] [uniqueidentifier] NULL,
	[lau_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [varchar](50) NOT NULL,
	[so_luong] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [phong_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phong_ban]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phong_ban](
	[id] [uniqueidentifier] NOT NULL,
	[loai_phong_ban_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[so_luong_phong_ban] [int] NULL,
	[so_luong_nhan_vien] [int] NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [phong_ban_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[quyen_han]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[quyen_han](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ten] [nvarchar](30) NULL,
	[mo_ta] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_sua] [date] NULL,
 CONSTRAINT [quyen_han_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan](
	[id] [uniqueidentifier] NOT NULL,
	[co_so_id] [uniqueidentifier] NULL,
	[phong_ban_id] [uniqueidentifier] NULL,
	[chuc_vu_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[ten_tai_khoan] [varchar](50) NOT NULL,
	[mat_khau] [varchar](65) NULL,
	[ho] [nvarchar](20) NULL,
	[ten_dem] [nvarchar](20) NULL,
	[ten] [nvarchar](20) NULL,
	[gioi_tinh] [bit] NULL,
	[ngay_sinh] [date] NULL,
	[email] [varchar](50) NULL,
	[sdt] [varchar](11) NULL,
	[cmnd] [varchar](20) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [tai_khoan_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan_ngan_hang]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan_ngan_hang](
	[id] [uniqueidentifier] NOT NULL,
	[ma] [varchar](20) NOT NULL,
	[ho_ten_chu_tai_khoan] [varchar](50) NULL,
	[so_tai_khoan] [varchar](50) NULL,
	[ten_ngan_hang] [nvarchar](50) NULL,
	[ten_chi_nhanh] [nvarchar](50) NULL,
	[dia_chi] [nvarchar](50) NULL,
	[ghi_chu] [nvarchar](50) NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_sua] [date] NULL,
 CONSTRAINT [tai_khoan_ngan_hang_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan_quyen_han]    Script Date: 4/27/2023 11:58:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan_quyen_han](
	[id] [uniqueidentifier] NOT NULL,
	[tai_khoan_id] [uniqueidentifier] NULL,
	[quyen_han_id] [uniqueidentifier] NULL,
	[ma] [varchar](20) NOT NULL,
	[mo_ta] [nvarchar](50) NOT NULL,
	[trang_thai] [int] NULL,
	[ngay_tao] [date] NULL,
	[ngay_chinh_sua] [date] NULL,
 CONSTRAINT [tai_khoan_quyen_han_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[chi_tiet_hoa_don] ([id], [hoa_don_id], [phong_id], [ma], [ngay_gio_nhan_phong], [ngay_gio_tra_phong], [thoi_gian_thue], [gia_phong], [qua_gio], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'fdf4c1db-f60e-4177-833d-1c25733ec646', N'6bbeafec-9e94-4a5a-98b8-08b40bdc5e43', N'e26e6a59-2090-488b-86f6-2e3b33e2e28d', N'CTHD998', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), 9, CAST(202 AS Decimal(20, 0)), 0, N'Khach hang du gio', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[chi_tiet_hoa_don] ([id], [hoa_don_id], [phong_id], [ma], [ngay_gio_nhan_phong], [ngay_gio_tra_phong], [thoi_gian_thue], [gia_phong], [qua_gio], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'9bf56702-fe6c-4108-800a-955b46745062', N'6bbeafec-9e94-4a5a-98b8-08b40bdc5e43', N'e26e6a59-2090-488b-86f6-2e3b33e2e28d', N'CTHD999', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), 7, CAST(102 AS Decimal(20, 0)), 1, N'Khach hang qua gio 1 tieng', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[chi_tiet_hoa_don] ([id], [hoa_don_id], [phong_id], [ma], [ngay_gio_nhan_phong], [ngay_gio_tra_phong], [thoi_gian_thue], [gia_phong], [qua_gio], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'd243285e-aff4-4178-a9f5-e673cc46abde', N'6bbeafec-9e94-4a5a-98b8-08b40bdc5e43', N'e26e6a59-2090-488b-86f6-2e3b33e2e28d', N'CTHD997', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), 10, CAST(302 AS Decimal(20, 0)), 3, N'Khach hang qua gio 3 tieng', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[chuc_vu] ([id], [phong_ban_id], [ma], [ten], [ngay_bat_dau], [ngay_ap_dung], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'e7a3952d-9947-4581-b3b9-33ef1c0a57d1', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'PB2', N'Phong ban Kinh te', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), N'Truong phong ban Kinh te', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[chuc_vu] ([id], [phong_ban_id], [ma], [ten], [ngay_bat_dau], [ngay_ap_dung], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'd6c36ebf-9fd6-4a54-9c7b-78dff2e28583', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'PB3', N'Phong ban thiet ke do hoa', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), N'Truong phong ban thiet ke do hoa', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[chuc_vu] ([id], [phong_ban_id], [ma], [ten], [ngay_bat_dau], [ngay_ap_dung], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'769ef5cd-1886-41ad-8c1f-d5cd58d59cdd', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'PB1', N'Phong ban CNTT', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), N'Truong phong ban CNTT', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[co_so] ([id], [tai_khoan_ngan_hang_id], [ma], [ten_co_so], [ho_ten_nguoi_dai_dien], [ma_so_thue], [so_dien_thoai], [email], [ghi_chu], [ten_tinh], [ten_thanh_pho], [ten_quan_huyen], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'7369ab46-5746-4b9f-914a-090c96d5b634', N'30312aba-bd7b-407c-8b3d-3da9bb4c9c99', N'CS3', N'Ha Nam', N'Nguyen Van C', N'GD3', N'0339211409', N'nguyenvanc@gmail.com', N'Co so Ha Nam', N'Ha Nam', N'Thanh pho Ha Nam', N'Le Hong Phong', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[co_so] ([id], [tai_khoan_ngan_hang_id], [ma], [ten_co_so], [ho_ten_nguoi_dai_dien], [ma_so_thue], [so_dien_thoai], [email], [ghi_chu], [ten_tinh], [ten_thanh_pho], [ten_quan_huyen], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'dba536ad-50bb-47cd-9e0b-caad8d932ae8', N'01532db6-64c2-4d85-94c4-7ffdc4274c30', N'CS2', N'Thai Binh', N'Nguyen Van B', N'GD2', N'0968089275', N'nguyenvanb@gmail.com', N'Co so Thai Binh', N'Thai Binh', N'Thanh pho Thai Binh', N'Vu Thu', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[co_so] ([id], [tai_khoan_ngan_hang_id], [ma], [ten_co_so], [ho_ten_nguoi_dai_dien], [ma_so_thue], [so_dien_thoai], [email], [ghi_chu], [ten_tinh], [ten_thanh_pho], [ten_quan_huyen], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'de299e7c-f191-4712-864f-da5f6ff62f3d', N'e808f993-3bed-487a-8d27-913ac9df5676', N'CS1', N'Ha Noi', N'Nguyen Van A', N'GD1', N'0339876543', N'nguyenvana@gmail.com', N'Co so Ha noi', N'Ha Noi', N'Thanh pho Ha Noi', N'Nam Tu Liem', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[dat_phong] ([id], [khach_hang_id], [loai_phong_id], [ma], [ten], [ngay_gio_dat], [so_luong_khach], [so_luong_phong_dat], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'9fa517a4-623f-4e01-b317-0151a41f84a3', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'DP2', N'Dat phong 202', CAST(N'2023-04-27' AS Date), 10, 2, N'Phong da dat coc tien', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dat_phong] ([id], [khach_hang_id], [loai_phong_id], [ma], [ten], [ngay_gio_dat], [so_luong_khach], [so_luong_phong_dat], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'a9dab71f-d58a-4970-9ac8-a963e978e43f', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'DP1', N'Dat phong 102', CAST(N'2023-04-27' AS Date), 15, 1, N'Phong da co nguoi dat', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dat_phong] ([id], [khach_hang_id], [loai_phong_id], [ma], [ten], [ngay_gio_dat], [so_luong_khach], [so_luong_phong_dat], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'7c86b89d-7d14-4379-8bce-cfb0f33b596c', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'DP3', N'Dat phong 302', CAST(N'2023-04-27' AS Date), 5, 1, N'Phong dat theo gio', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[dich_vu] ([id], [loai_dich_vu_id], [ma], [ten], [don_vi_tinh], [don_gia], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'fbe31121-2b0c-433e-8054-275627cfc16a', N'4ea684fa-f2df-4157-a5e7-35f8e1179a18', N'DV2', N'Dich vu thuong', N'FPT Tay Nguyen', CAST(8000000 AS Decimal(20, 0)), N'Dich vu thuong ', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dich_vu] ([id], [loai_dich_vu_id], [ma], [ten], [don_vi_tinh], [don_gia], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'5947ea03-da6f-4b08-92e9-a0289a5f1581', N'4ea684fa-f2df-4157-a5e7-35f8e1179a18', N'DV3', N'Dich vu cao cap', N'FPT Ha Nam', CAST(1000000 AS Decimal(20, 0)), N'Dich vu cao cap ', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dich_vu] ([id], [loai_dich_vu_id], [ma], [ten], [don_vi_tinh], [don_gia], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'5e8221bd-1dd2-4da9-a79f-ba14b1c5ece5', N'4ea684fa-f2df-4157-a5e7-35f8e1179a18', N'DV1', N'Dich vu vip', N'FPT Ha Noi', CAST(9000000 AS Decimal(20, 0)), N'Dich vu vip 1', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[dich_vu_su_dung] ([id], [dich_vu_id], [chi_tiet_hoa_don_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'c149cdd4-1faa-4329-aa7e-045f9e3d2dd6', N'fbe31121-2b0c-433e-8054-275627cfc16a', N'fdf4c1db-f60e-4177-833d-1c25733ec646', N'DVSD1', N'Dich vu loai 1', 100, N'Dich vu hang thuong gia', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dich_vu_su_dung] ([id], [dich_vu_id], [chi_tiet_hoa_don_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'1f6107d5-b1fb-4940-bcf6-b20baca62083', N'fbe31121-2b0c-433e-8054-275627cfc16a', N'fdf4c1db-f60e-4177-833d-1c25733ec646', N'DVSD3', N'Dich vu loai 2', 200, N'Dich vu hang binh dan', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[dich_vu_su_dung] ([id], [dich_vu_id], [chi_tiet_hoa_don_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'9a921781-f345-4d60-a525-dce5fbf2c259', N'fbe31121-2b0c-433e-8054-275627cfc16a', N'fdf4c1db-f60e-4177-833d-1c25733ec646', N'DVSD2', N'Dich vu loai 2', 50, N'Dich vu hang trung binh', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[giao_dich] ([id], [ma], [hinh_thuc_thanh_toan], [ngay_thanh_toan], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'15283969-a5fe-4839-8c87-31461f799f5f', N'GD3', 3, CAST(N'2023-04-27' AS Date), 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[giao_dich] ([id], [ma], [hinh_thuc_thanh_toan], [ngay_thanh_toan], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'c4fdbc15-839d-4120-be2b-af465806f6b3', N'GD2', 2, CAST(N'2023-04-27' AS Date), 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[giao_dich] ([id], [ma], [hinh_thuc_thanh_toan], [ngay_thanh_toan], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'e6d95d1a-10f7-4fb5-aed2-cc01dff9112f', N'GD1', 1, CAST(N'2023-04-27' AS Date), 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[giao_han] ([id], [tai_khoan_id], [ma], [ten], [thoi_diem_bat_dau], [thoi_diem_ket_thuc], [so_tien_dau_ngay], [tong_tien_hoa_don], [tong_tien_tam_tinh], [tong_tien_thu_thue], [tong_tien_chenh_lech], [tong_tien_phat_sinh], [don_vi_tinh], [trang_thai_thu_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b7a2fb36-08d5-42d1-8ccf-3d81db73d468', N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'GH1', N'Giao han 1', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), CAST(10000000 AS Decimal(20, 0)), CAST(3000000 AS Decimal(20, 0)), CAST(20000000 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(2000000 AS Decimal(20, 0)), N'VND', 0, N'Gian han 1, chua tinh lai', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[giao_han] ([id], [tai_khoan_id], [ma], [ten], [thoi_diem_bat_dau], [thoi_diem_ket_thuc], [so_tien_dau_ngay], [tong_tien_hoa_don], [tong_tien_tam_tinh], [tong_tien_thu_thue], [tong_tien_chenh_lech], [tong_tien_phat_sinh], [don_vi_tinh], [trang_thai_thu_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'd7e38c6b-422e-4096-86a7-66445508f700', N'b4077dfd-015b-453f-a748-e13e19970a30', N'GH2', N'Giao han 2', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), CAST(20000000 AS Decimal(20, 0)), CAST(2000000 AS Decimal(20, 0)), CAST(10000000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(2000000 AS Decimal(20, 0)), N'VND', 1, N'Gian han 2, da tinh lai', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[giao_han] ([id], [tai_khoan_id], [ma], [ten], [thoi_diem_bat_dau], [thoi_diem_ket_thuc], [so_tien_dau_ngay], [tong_tien_hoa_don], [tong_tien_tam_tinh], [tong_tien_thu_thue], [tong_tien_chenh_lech], [tong_tien_phat_sinh], [don_vi_tinh], [trang_thai_thu_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'48bf7050-bd2d-46ed-8fab-7917c1498677', N'36fb4c96-644c-451e-9a7b-fb7e14fb184f', N'GH3', N'Giao han 2', CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date), CAST(30000000 AS Decimal(20, 0)), CAST(1000000 AS Decimal(20, 0)), CAST(30000000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(2000000 AS Decimal(20, 0)), N'VND', 0, N'Gian han 3, chua tinh lai', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[hoa_don] ([id], [khach_hang_id], [tai_khoan_id], [giao_dich_id], [dat_phong_id], [ma], [tien_khach_dua], [tien_tra_lai], [tien_coc], [phu_thu], [thue], [giam_gia], [tong_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'6bbeafec-9e94-4a5a-98b8-08b40bdc5e43', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'15283969-a5fe-4839-8c87-31461f799f5f', N'9fa517a4-623f-4e01-b317-0151a41f84a3', N'HD999', CAST(3000000 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(50000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(3700000 AS Decimal(20, 0)), N'Da hoan thanh xong tien phong', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[hoa_don] ([id], [khach_hang_id], [tai_khoan_id], [giao_dich_id], [dat_phong_id], [ma], [tien_khach_dua], [tien_tra_lai], [tien_coc], [phu_thu], [thue], [giam_gia], [tong_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b0be02d7-41cd-452b-b449-8bb715254d88', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'15283969-a5fe-4839-8c87-31461f799f5f', N'9fa517a4-623f-4e01-b317-0151a41f84a3', N'HD998', CAST(4000000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), CAST(200000 AS Decimal(20, 0)), CAST(40000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(4700000 AS Decimal(20, 0)), N'Da hoan thanh xong tien phong', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[hoa_don] ([id], [khach_hang_id], [tai_khoan_id], [giao_dich_id], [dat_phong_id], [ma], [tien_khach_dua], [tien_tra_lai], [tien_coc], [phu_thu], [thue], [giam_gia], [tong_tien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b353440f-8adf-4836-bab6-fae7a314981d', N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'15283969-a5fe-4839-8c87-31461f799f5f', N'9fa517a4-623f-4e01-b317-0151a41f84a3', N'HD997', CAST(5000000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), CAST(30000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(5700000 AS Decimal(20, 0)), N'Da hoan thanh xong tien phong', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[khach_hang] ([id], [ma], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [dia_chi], [quoc_tich], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'527d7d25-c806-4a82-8ebf-81d9168291f3', N'KH1', N'Chu', N'Thi', N'Ngan', 1, CAST(N'1998-12-12' AS Date), N'nganct@gmail.com', N'096789123', N'Ha noi', N'Viet nam', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[khach_hang] ([id], [ma], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [dia_chi], [quoc_tich], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'a02dcca2-6957-4071-9db2-ae5ba42ed08d', N'KH3', N'Dang', N'Quang', N'Minh', 0, CAST(N'1985-12-12' AS Date), N'minhdq8@gmail.com', N'035789123', N'Ha noi', N'Viet nam', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[khach_hang] ([id], [ma], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [dia_chi], [quoc_tich], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'1c75b2b4-08cc-4bb7-a25c-fb89543e3c09', N'KH2', N'Nguyen', N'Khanh', N'Huyen', 1, CAST(N'1999-12-12' AS Date), N'huyenk@gmail.com', N'036789123', N'Ha noi', N'Viet nam', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[lau] ([id], [co_so_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b57bc2ac-89e5-472c-9a48-4bb0ee9fe28c', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'L2', N'Lau 1 - P', 13, N'Tai toa P', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[lau] ([id], [co_so_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b786e361-4468-4d1e-98ba-8b73ca9f5e19', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'L1', N'Lau 1 - F', 12, N'Tai toa F', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[lau] ([id], [co_so_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'836495ba-cb25-4bf4-b26a-dd0eb3e8e8f1', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'L3', N'Lau 1 - T', 13, N'Tai toa T', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[loai_dich_vu] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'4ea684fa-f2df-4157-a5e7-35f8e1179a18', N'LDV3', N'Loai dich vu 3', N'Loai 3', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_dich_vu] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'cb399082-c782-4934-a17d-73fce194e0e9', N'LDV2', N'Loai dich vu 2', N'Loai 2', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_dich_vu] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'd121b858-0c31-4efc-b2cf-b16e51a0d265', N'LDV1', N'Loai dich vu 1', N'Loai 1', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[loai_phong] ([id], [ma], [ten], [don_gia_theo_gio], [don_gia_qua_ngay], [don_gia_qua_dem], [so_nguoi], [ghi_chu], [tien_qua_gio], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'Type3', N'Phong loai 3', CAST(50000 AS Decimal(20, 0)), CAST(1000000 AS Decimal(20, 0)), CAST(150000 AS Decimal(20, 0)), 9, N'Khach thue du lich', CAST(350000 AS Decimal(20, 0)), 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_phong] ([id], [ma], [ten], [don_gia_theo_gio], [don_gia_qua_ngay], [don_gia_qua_dem], [so_nguoi], [ghi_chu], [tien_qua_gio], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'1dbd7e13-9635-48a6-a023-99f2747675fc', N'Type1', N'Phong loai 1', CAST(200000 AS Decimal(20, 0)), CAST(3000000 AS Decimal(20, 0)), CAST(250000 AS Decimal(20, 0)), 10, N'Khach thue du lich', CAST(250000 AS Decimal(20, 0)), 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_phong] ([id], [ma], [ten], [don_gia_theo_gio], [don_gia_qua_ngay], [don_gia_qua_dem], [so_nguoi], [ghi_chu], [tien_qua_gio], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'c2290ebc-fb60-434b-9d3d-b0cd975c3a47', N'Type2', N'Phong loai 2', CAST(100000 AS Decimal(20, 0)), CAST(1000000 AS Decimal(20, 0)), CAST(150000 AS Decimal(20, 0)), 8, N'Khach thue ca nhan', CAST(300000 AS Decimal(20, 0)), 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[loai_phong_ban] ([id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'd26c8598-6d5b-4b10-bc82-0a736e5122e2', N'PB3', N'TKW', 1, N'Thiet ke web', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_phong_ban] ([id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'7b2224f1-4f23-4d71-b223-73777428c171', N'PB2', N'MKT', 10, N'Digital Marketing', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[loai_phong_ban] ([id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'd27c37d7-b825-478a-abc2-7f4df3d34e1f', N'PB1', N'CNTT', 1, N'Cong nghe thong tin', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[phong] ([id], [loai_phong_id], [co_so_id], [lau_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'e26e6a59-2090-488b-86f6-2e3b33e2e28d', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'b57bc2ac-89e5-472c-9a48-4bb0ee9fe28c', N'P2', N'Phong 202', 1, N'Tanng 5', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[phong] ([id], [loai_phong_id], [co_so_id], [lau_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'6690ce45-7272-4f99-89ed-c158bc629bac', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'b57bc2ac-89e5-472c-9a48-4bb0ee9fe28c', N'P3', N'Phong 302', 1, N'Tanng 4', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[phong] ([id], [loai_phong_id], [co_so_id], [lau_id], [ma], [ten], [so_luong], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'0c05496d-0a55-4ee3-a9f7-f031736b1421', N'ea01f75a-bd61-40f4-9630-66fe90e631ed', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'b57bc2ac-89e5-472c-9a48-4bb0ee9fe28c', N'P1', N'Phong 102', 1, N'Tanng 3', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[phong_ban] ([id], [loai_phong_ban_id], [ma], [ten], [so_luong_phong_ban], [so_luong_nhan_vien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'd26c8598-6d5b-4b10-bc82-0a736e5122e2', N'PBCN', N'Phong ban CNTT', 1, 15, N'Toa P - FPoly', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[phong_ban] ([id], [loai_phong_ban_id], [ma], [ten], [so_luong_phong_ban], [so_luong_nhan_vien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'0fa03aee-6377-4890-a977-3d0c3875e166', N'd26c8598-6d5b-4b10-bc82-0a736e5122e2', N'PBKT', N'Phong ban Kinh te', 1, 20, N'Toa D - FPoly', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[phong_ban] ([id], [loai_phong_ban_id], [ma], [ten], [so_luong_phong_ban], [so_luong_nhan_vien], [ghi_chu], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'59313f17-7a7d-4032-a3ed-c7911e535a89', N'd26c8598-6d5b-4b10-bc82-0a736e5122e2', N'PBTKDH', N'Phong ban thiet ke do hoa', 1, 25, N'Toa L - FPoly', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[quyen_han] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'243c657a-2e23-4efc-bd49-4676a465ca1f', N'QH2', N'Quyen han 2', N'Loai QH 2', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[quyen_han] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'fe56c1f1-8954-423e-82eb-541354b38bdc', N'QH3', N'Quyen han 3', N'Loai QH 3', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[quyen_han] ([id], [ma], [ten], [mo_ta], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'1a5a317f-f962-4d66-92ae-df4bf9df4678', N'QH1', N'Quyen han 1', N'Loai QH 1', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[tai_khoan] ([id], [co_so_id], [phong_ban_id], [chuc_vu_id], [ma], [ten_tai_khoan], [mat_khau], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [cmnd], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'e7a3952d-9947-4581-b3b9-33ef1c0a57d1', N'TK2', N'Vu Van Nguyen', N'123@123', N'Vu', N'Van', N'Nguyen', 0, CAST(N'1998-01-01' AS Date), N'nguyennv4@gmail.com', N'03463922211', N'98765432', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan] ([id], [co_so_id], [phong_ban_id], [chuc_vu_id], [ma], [ten_tai_khoan], [mat_khau], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [cmnd], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'b4077dfd-015b-453f-a748-e13e19970a30', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'e7a3952d-9947-4581-b3b9-33ef1c0a57d1', N'TK1', N'Nguyen Thuy Hang', N'123@123', N'Nguyen', N'Thuy', N'Hang', 1, CAST(N'1999-01-01' AS Date), N'hangnt@gmail.com', N'0968089275', N'1234567890', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan] ([id], [co_so_id], [phong_ban_id], [chuc_vu_id], [ma], [ten_tai_khoan], [mat_khau], [ho], [ten_dem], [ten], [gioi_tinh], [ngay_sinh], [email], [sdt], [cmnd], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'36fb4c96-644c-451e-9a7b-fb7e14fb184f', N'7369ab46-5746-4b9f-914a-090c96d5b634', N'90eee8f9-7de6-4b6c-8506-12c906eb2b17', N'e7a3952d-9947-4581-b3b9-33ef1c0a57d1', N'TK3', N'Nguyen Anh Dung', N'123@123', N'Nguyen', N'Anh', N'Dung', 0, CAST(N'1988-01-01' AS Date), N'dungna29@gmail.com', N'0345678901', N'876543219', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[tai_khoan_ngan_hang] ([id], [ma], [ho_ten_chu_tai_khoan], [so_tai_khoan], [ten_ngan_hang], [ten_chi_nhanh], [dia_chi], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'30312aba-bd7b-407c-8b3d-3da9bb4c9c99', N'TKNH3', N'DungNA29', N'123456789', N'Techcombank', N'Chi nhanh  Ha Nam', N'Thanh Liem, Ha Nam', N'Ghi chu 3', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan_ngan_hang] ([id], [ma], [ho_ten_chu_tai_khoan], [so_tai_khoan], [ten_ngan_hang], [ten_chi_nhanh], [dia_chi], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'01532db6-64c2-4d85-94c4-7ffdc4274c30', N'TKNH2', N'NguyenNV4', N'0987654321', N'MB Bank', N'Chi nhanh Thai Binh', N'Kien Xuong, Thai Binh', N'Ghi chu 2', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan_ngan_hang] ([id], [ma], [ho_ten_chu_tai_khoan], [so_tai_khoan], [ten_ngan_hang], [ten_chi_nhanh], [dia_chi], [ghi_chu], [trang_thai], [ngay_tao], [ngay_sua]) VALUES (N'e808f993-3bed-487a-8d27-913ac9df5676', N'TKNH1', N'HangNT69', N'012345678', N'TP Bank', N'Chi nhanh Ha Noi', N'Nam Tu Liem, Ha Noi', N'Ghi chu 1', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
INSERT [dbo].[tai_khoan_quyen_han] ([id], [tai_khoan_id], [quyen_han_id], [ma], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'f4ab0606-6644-4dfc-a028-266ad4000e0a', N'6f5818bb-5707-4b40-8521-276c21f72c3d', N'243c657a-2e23-4efc-bd49-4676a465ca1f', N'TKQH2', N'Tai khoan quyen han 2', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan_quyen_han] ([id], [tai_khoan_id], [quyen_han_id], [ma], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'5301c4ad-92d7-4500-a7ce-27a5aa5fd12e', N'b4077dfd-015b-453f-a748-e13e19970a30', N'243c657a-2e23-4efc-bd49-4676a465ca1f', N'TKQH1', N'Tai khoan quyen han 1', 1, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
INSERT [dbo].[tai_khoan_quyen_han] ([id], [tai_khoan_id], [quyen_han_id], [ma], [mo_ta], [trang_thai], [ngay_tao], [ngay_chinh_sua]) VALUES (N'e9a21867-ad68-4aa9-96b4-fa7f09159a2f', N'36fb4c96-644c-451e-9a7b-fb7e14fb184f', N'243c657a-2e23-4efc-bd49-4676a465ca1f', N'TKQH3', N'Tai khoan quyen han 3', 0, CAST(N'2023-04-27' AS Date), CAST(N'2023-04-27' AS Date))
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [chi_tiet_hoa_don_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  CONSTRAINT [chi_tiet_hoa_don_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [chuc_vu_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[chuc_vu] ADD  CONSTRAINT [chuc_vu_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [co_so_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[co_so] ADD  CONSTRAINT [co_so_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [dat_phong_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[dat_phong] ADD  CONSTRAINT [dat_phong_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [dich_vu_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[dich_vu] ADD  CONSTRAINT [dich_vu_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [dich_vu_su_dung_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  CONSTRAINT [dich_vu_su_dung_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [giao_dich_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[giao_dich] ADD  CONSTRAINT [giao_dich_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [giao_han_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[giao_han] ADD  CONSTRAINT [giao_han_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [hoa_don_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[hoa_don] ADD  CONSTRAINT [hoa_don_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [khach_hang_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[khach_hang] ADD  CONSTRAINT [khach_hang_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [lau_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[lau] ADD  CONSTRAINT [lau_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [loai_dich_vu_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[loai_dich_vu] ADD  CONSTRAINT [loai_dich_vu_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [loai_phong_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[loai_phong] ADD  CONSTRAINT [loai_phong_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [loai_phong_ban_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[loai_phong_ban] ADD  CONSTRAINT [loai_phong_ban_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [phong_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[phong] ADD  CONSTRAINT [phong_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [phong_ban_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[phong_ban] ADD  CONSTRAINT [phong_ban_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [quyen_han_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[quyen_han] ADD  CONSTRAINT [quyen_han_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [tai_khoan_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[tai_khoan] ADD  CONSTRAINT [tai_khoan_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [tai_khoan_UN1]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[tai_khoan] ADD  CONSTRAINT [tai_khoan_UN1] UNIQUE NONCLUSTERED 
(
	[ten_tai_khoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [tai_khoan_ngan_hang_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[tai_khoan_ngan_hang] ADD  CONSTRAINT [tai_khoan_ngan_hang_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [tai_khoan_quyen_han_UN]    Script Date: 4/27/2023 11:58:28 PM ******/
ALTER TABLE [dbo].[tai_khoan_quyen_han] ADD  CONSTRAINT [tai_khoan_quyen_han_UN] UNIQUE NONCLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_gio_nhan_phong]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_gio_tra_phong]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT ((1)) FOR [thoi_gian_thue]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (getdate()) FOR [ngay_bat_dau]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (getdate()) FOR [ngay_ap_dung]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[chuc_vu] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[co_so] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[co_so] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[co_so] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[co_so] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT (getdate()) FOR [ngay_gio_dat]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT ((0)) FOR [so_luong_khach]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT ((0)) FOR [so_luong_phong_dat]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[dat_phong] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[dich_vu] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[dich_vu] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[dich_vu] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[dich_vu] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  DEFAULT ((0)) FOR [so_luong]
GO
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[dich_vu_su_dung] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT ((1)) FOR [hinh_thuc_thanh_toan]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT (getdate()) FOR [ngay_thanh_toan]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[giao_dich] ADD  DEFAULT (getdate()) FOR [ngay_sua]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT (getdate()) FOR [thoi_diem_bat_dau]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT (getdate()) FOR [thoi_diem_ket_thuc]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT ((0)) FOR [trang_thai_thu_tien]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[giao_han] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[hoa_don] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT ((0)) FOR [gioi_tinh]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[khach_hang] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[lau] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[lau] ADD  DEFAULT ((0)) FOR [so_luong]
GO
ALTER TABLE [dbo].[lau] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[lau] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[lau] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[loai_dich_vu] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[loai_dich_vu] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[loai_dich_vu] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[loai_dich_vu] ADD  DEFAULT (getdate()) FOR [ngay_sua]
GO
ALTER TABLE [dbo].[loai_phong] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[loai_phong] ADD  DEFAULT ((0)) FOR [so_nguoi]
GO
ALTER TABLE [dbo].[loai_phong] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[loai_phong] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[loai_phong] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[loai_phong_ban] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[loai_phong_ban] ADD  DEFAULT ((0)) FOR [so_luong]
GO
ALTER TABLE [dbo].[loai_phong_ban] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[loai_phong_ban] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[loai_phong_ban] ADD  DEFAULT (getdate()) FOR [ngay_sua]
GO
ALTER TABLE [dbo].[phong] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[phong] ADD  DEFAULT ((0)) FOR [so_luong]
GO
ALTER TABLE [dbo].[phong] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[phong] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[phong] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT ((0)) FOR [so_luong_phong_ban]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT ((0)) FOR [so_luong_nhan_vien]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[phong_ban] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[quyen_han] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[quyen_han] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[quyen_han] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[quyen_han] ADD  DEFAULT (getdate()) FOR [ngay_sua]
GO
ALTER TABLE [dbo].[tai_khoan] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[tai_khoan] ADD  DEFAULT ((0)) FOR [gioi_tinh]
GO
ALTER TABLE [dbo].[tai_khoan] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[tai_khoan] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[tai_khoan] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[tai_khoan_ngan_hang] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[tai_khoan_ngan_hang] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[tai_khoan_ngan_hang] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[tai_khoan_ngan_hang] ADD  DEFAULT (getdate()) FOR [ngay_sua]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] ADD  DEFAULT ((1)) FOR [trang_thai]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] ADD  DEFAULT (getdate()) FOR [ngay_tao]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] ADD  DEFAULT (getdate()) FOR [ngay_chinh_sua]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don]  WITH CHECK ADD  CONSTRAINT [chi_tiet_hoa_don_FK] FOREIGN KEY([hoa_don_id])
REFERENCES [dbo].[hoa_don] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] CHECK CONSTRAINT [chi_tiet_hoa_don_FK]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don]  WITH CHECK ADD  CONSTRAINT [chi_tiet_hoa_don_FK1] FOREIGN KEY([phong_id])
REFERENCES [dbo].[phong] ([id])
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] CHECK CONSTRAINT [chi_tiet_hoa_don_FK1]
GO
ALTER TABLE [dbo].[chuc_vu]  WITH CHECK ADD  CONSTRAINT [chuc_vu_FK] FOREIGN KEY([phong_ban_id])
REFERENCES [dbo].[phong_ban] ([id])
GO
ALTER TABLE [dbo].[chuc_vu] CHECK CONSTRAINT [chuc_vu_FK]
GO
ALTER TABLE [dbo].[co_so]  WITH CHECK ADD  CONSTRAINT [co_so_FK] FOREIGN KEY([tai_khoan_ngan_hang_id])
REFERENCES [dbo].[tai_khoan_ngan_hang] ([id])
GO
ALTER TABLE [dbo].[co_so] CHECK CONSTRAINT [co_so_FK]
GO
ALTER TABLE [dbo].[dat_phong]  WITH CHECK ADD  CONSTRAINT [dat_phong_FK] FOREIGN KEY([khach_hang_id])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[dat_phong] CHECK CONSTRAINT [dat_phong_FK]
GO
ALTER TABLE [dbo].[dat_phong]  WITH CHECK ADD  CONSTRAINT [dat_phong_FK1] FOREIGN KEY([loai_phong_id])
REFERENCES [dbo].[loai_phong] ([id])
GO
ALTER TABLE [dbo].[dat_phong] CHECK CONSTRAINT [dat_phong_FK1]
GO
ALTER TABLE [dbo].[dich_vu]  WITH CHECK ADD  CONSTRAINT [dich_vu_FK] FOREIGN KEY([loai_dich_vu_id])
REFERENCES [dbo].[loai_dich_vu] ([id])
GO
ALTER TABLE [dbo].[dich_vu] CHECK CONSTRAINT [dich_vu_FK]
GO
ALTER TABLE [dbo].[dich_vu_su_dung]  WITH CHECK ADD  CONSTRAINT [dich_vu_su_dung_FK] FOREIGN KEY([dich_vu_id])
REFERENCES [dbo].[dich_vu] ([id])
GO
ALTER TABLE [dbo].[dich_vu_su_dung] CHECK CONSTRAINT [dich_vu_su_dung_FK]
GO
ALTER TABLE [dbo].[dich_vu_su_dung]  WITH CHECK ADD  CONSTRAINT [dich_vu_su_dung_FK1] FOREIGN KEY([chi_tiet_hoa_don_id])
REFERENCES [dbo].[chi_tiet_hoa_don] ([id])
GO
ALTER TABLE [dbo].[dich_vu_su_dung] CHECK CONSTRAINT [dich_vu_su_dung_FK1]
GO
ALTER TABLE [dbo].[giao_han]  WITH CHECK ADD  CONSTRAINT [giao_han_FK] FOREIGN KEY([tai_khoan_id])
REFERENCES [dbo].[tai_khoan] ([id])
GO
ALTER TABLE [dbo].[giao_han] CHECK CONSTRAINT [giao_han_FK]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [hoa_don_FK] FOREIGN KEY([khach_hang_id])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [hoa_don_FK]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [hoa_don_FK1] FOREIGN KEY([tai_khoan_id])
REFERENCES [dbo].[tai_khoan] ([id])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [hoa_don_FK1]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [hoa_don_FK2] FOREIGN KEY([giao_dich_id])
REFERENCES [dbo].[giao_dich] ([id])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [hoa_don_FK2]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [hoa_don_FK3] FOREIGN KEY([dat_phong_id])
REFERENCES [dbo].[dat_phong] ([id])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [hoa_don_FK3]
GO
ALTER TABLE [dbo].[lau]  WITH CHECK ADD  CONSTRAINT [lau_FK] FOREIGN KEY([co_so_id])
REFERENCES [dbo].[co_so] ([id])
GO
ALTER TABLE [dbo].[lau] CHECK CONSTRAINT [lau_FK]
GO
ALTER TABLE [dbo].[phong]  WITH CHECK ADD  CONSTRAINT [phong_FK] FOREIGN KEY([loai_phong_id])
REFERENCES [dbo].[loai_phong] ([id])
GO
ALTER TABLE [dbo].[phong] CHECK CONSTRAINT [phong_FK]
GO
ALTER TABLE [dbo].[phong]  WITH CHECK ADD  CONSTRAINT [phong_FK1] FOREIGN KEY([co_so_id])
REFERENCES [dbo].[co_so] ([id])
GO
ALTER TABLE [dbo].[phong] CHECK CONSTRAINT [phong_FK1]
GO
ALTER TABLE [dbo].[phong]  WITH CHECK ADD  CONSTRAINT [phong_FK2] FOREIGN KEY([lau_id])
REFERENCES [dbo].[lau] ([id])
GO
ALTER TABLE [dbo].[phong] CHECK CONSTRAINT [phong_FK2]
GO
ALTER TABLE [dbo].[phong_ban]  WITH CHECK ADD  CONSTRAINT [phong_ban_FK] FOREIGN KEY([loai_phong_ban_id])
REFERENCES [dbo].[loai_phong_ban] ([id])
GO
ALTER TABLE [dbo].[phong_ban] CHECK CONSTRAINT [phong_ban_FK]
GO
ALTER TABLE [dbo].[tai_khoan]  WITH CHECK ADD  CONSTRAINT [tai_khoan_FK] FOREIGN KEY([co_so_id])
REFERENCES [dbo].[co_so] ([id])
GO
ALTER TABLE [dbo].[tai_khoan] CHECK CONSTRAINT [tai_khoan_FK]
GO
ALTER TABLE [dbo].[tai_khoan]  WITH CHECK ADD  CONSTRAINT [tai_khoan_FK1] FOREIGN KEY([phong_ban_id])
REFERENCES [dbo].[phong_ban] ([id])
GO
ALTER TABLE [dbo].[tai_khoan] CHECK CONSTRAINT [tai_khoan_FK1]
GO
ALTER TABLE [dbo].[tai_khoan]  WITH CHECK ADD  CONSTRAINT [tai_khoan_FK2] FOREIGN KEY([chuc_vu_id])
REFERENCES [dbo].[chuc_vu] ([id])
GO
ALTER TABLE [dbo].[tai_khoan] CHECK CONSTRAINT [tai_khoan_FK2]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han]  WITH CHECK ADD  CONSTRAINT [tai_khoan_quyen_han_FK] FOREIGN KEY([tai_khoan_id])
REFERENCES [dbo].[tai_khoan] ([id])
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] CHECK CONSTRAINT [tai_khoan_quyen_han_FK]
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han]  WITH CHECK ADD  CONSTRAINT [tai_khoan_quyen_han_FK1] FOREIGN KEY([quyen_han_id])
REFERENCES [dbo].[quyen_han] ([id])
GO
ALTER TABLE [dbo].[tai_khoan_quyen_han] CHECK CONSTRAINT [tai_khoan_quyen_han_FK1]
GO
