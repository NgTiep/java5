package com.example.btvn13.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tai_khoan_ngan_hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanNganHang {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ho_ten_chu_tai_khoan")
    private String ten;

    @Column(name = "so_tai_khoan")
    private String soTaiKhoan;

    @Column(name = "ten_ngan_hang")
    private String tenNganHang;

    @Column(name = "ten_chi_nhanh")
    private String tenChiNhanh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_sua")
    private String ngaySua;


}
