package com.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NotBlank(message = "Không để trống trường")
    private String maphieu;

    @Column(name = "tenphieu")
    @NotBlank(message = "Không để trống trường")
    private String tenphieu;

    @Column(name = "ngaybatdau")
    @NotBlank(message = "Không để trống trường")
    private String ngaybatdau;

    @Column(name = "ngayketthuc")
    @NotBlank(message = "Không để trống trường")
    private String ngayketthuc;

    @Column(name = "giatrigiam")
    @NotNull(message = "Không để trống trường")
    private double giatrigiam;

    @Column(name = "giatrigiamtoida")
    @NotNull(message = "Không để trống trường")
    private double giatrigiamtoida;

    @Column(name = "trangthai")
    private int trangthai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu",referencedColumnName = "makhachhang")
    private KhachHang khachhang;
}
