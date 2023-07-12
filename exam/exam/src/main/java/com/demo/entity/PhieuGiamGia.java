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
    @NotBlank(message = "Không để trống trường")
    private String maPhieu;

    @Column(name = "tenphieu")
    @NotBlank(message = "Không để trống trường")
    private String tenPhieu;

    @Column(name = "ngaybatdau")
    @NotBlank(message = "Không để trống trường")
    private String ngayBatDau;

    @Column(name = "ngayketthuc")
    @NotBlank(message = "Không để trống trường")
    private String ngayKetThuc;

    @Column(name = "giatrigiam")
    @NotNull(message = "Không để trống trường")
    private BigDecimal giaTriGiam;

    @Column(name = "giatrigiamtoida")
    @NotNull(message = "Không để trống trường")
    private BigDecimal giaTriGiamToiDa;

    @Column(name = "trangthai")
    @NotNull(message = "Không để trống trường")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}
