package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "phieugiamgia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiamGia {

    @Id
    @Column(name = "maphieu")
    @NotBlank(message = "Nhập thông tin đầy đủ")
    private String maPhieu;

    @Column(name = "tenphieu")
    @NotBlank(message = "Nhập thông tin đầy đủ")
    private String tenPhieu;

    @Column(name = "giatrigiam")
    @NotNull(message = "Nhập thông tin đầy đủ")
    private BigDecimal giaTriGiam;

    @Column(name = "giatrigiamtoida")
    @NotNull(message = "Nhập thông tin đầy đủ")
    private BigDecimal giaTriGiamToiDa;

    @Column(name = "trangthai")
    private int trangThai;

    @Column(name = "ngaybatdau")
    @NotBlank(message = "Nhập thông tin đầy đủ")
    private String ngayBatDau;

    @Column(name = "ngayketthuc")
    @NotBlank(message = "Nhập thông tin đầy đủ")
    private String ngayKetThuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

}
