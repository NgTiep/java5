package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phieugiamgia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiamGia {

    @Id
    @Column(name = "maphieu")
    @NotBlank(message = "Không được để trống")
    private String maPhieu;

    @Column(name = "tenphieu")
    @NotBlank(message = "Không được để trống")
    private String tenPhieu;

    @Column(name = "ngaybatdau")
    @NotBlank(message = "Không được để trống")
    private String ngayBatDau;

    @Column(name = "ngayketthuc")
    @NotBlank(message = "Không được để trống")
    private String ngayKetThuc;

    @Column(name = "giatrigiam")
    @NotNull(message = "Không được để trống")
    private double giaTriGiam;

    @Column(name = "giatrigiamtoida")
    @NotNull(message = "Không được để trống")
    private double giaTriGiamToiDa;

    @Column(name = "trangthai")
    private int trangThai;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}
