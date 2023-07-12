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
import java.util.UUID;

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiaoHang {

    @Id
    @Column(name = "maphieugiao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID maPhieuGiao;

    @Column(name = "nguoinhan")
    @NotBlank(message = "Không để trống thông tin")
    private String nguoiNhan;

    @Column(name = "sdtnhan")
    @NotBlank(message = "Không để trống thông tin")
    private String soDienThoai;

    @Column(name = "ngaygiao")
    @NotBlank(message = "Không để trống thông tin")
    private String ngayGiao;

    @Column(name = "ngaynhan")
    @NotBlank(message = "Không để trống thông tin")
    private String ngayNhan;

    @Column(name = "trangthai")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoadongiao", referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;

}
