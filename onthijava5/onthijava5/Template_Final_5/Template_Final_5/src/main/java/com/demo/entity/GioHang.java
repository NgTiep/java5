package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "giohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHang {

    @Id
    @Column(name = "magiohang")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID maGioHang;

    @NotBlank(message = "Không để trống trường")
    @Column(name = "ngaytao")
    private String ngayTao;

    @NotBlank(message = "Không để trống trường")
    @Column(name = "ngaycapnhap")
    private String ngayCapNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    @NotBlank(message = "Không để trống trường")
    @Column(name = "ghichu")
    private String ghiChu;

    @NotNull(message = "Không để trống trường")
    @Column(name = "trangthai")
    private int trangThai;

}
