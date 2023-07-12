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
@Table(name = "thethanhvien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheThanhVien {

    @Id
    @Column(name = "mathe")
    @NotBlank(message = "Không để trốn trường")
    private String maThe;

    @Column(name = "mauthe")
    @NotBlank(message = "Không để trốn trường")
    private String mauThe;

    @Column(name = "loaithe")
    private String loaiThe;

    @Column(name = "ngayphathanh")
    @NotBlank(message = "Không để trốn trường")
    private String ngayPhatHanh;

    @Column(name = "ngayhuy")
    @NotBlank(message = "Không để trốn trường")
    private String ngayHuy;

    @Column(name = "trangthai")
    @NotNull(message = "Không để trốn trường")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoisohuu", referencedColumnName = "maKhachHang")
    private KhachHang khachHang;
}
