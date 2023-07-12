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

@Entity
@Table(name = "khachhang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

    @Id
    @Column(name = "makhachhang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKhachHang;

    @Column(name = "tenkhachhang")
    @NotBlank(message = "Không để trống trường")
    private String tenKhachHang;

    @Column(name = "sodienthoai")
    @NotBlank(message = "Không để trống trường")
    private String soDienThoai;

    @Column(name = "gioitinh")
    @NotNull(message = "Không để trống trường")
    private boolean gioiTinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hangkhachhang", referencedColumnName = "maHang")
    private HangKhachHang hangKhachHang;

}
