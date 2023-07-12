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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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


    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "nguoinhan")
    private String nguoiNhan;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "sdtnhan")
    private String soDienThoai;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ngaygiao")
    private String ngayGiao;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ngaynhan")
    private String ngayNhan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoadongiao", referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;

    @NotNull(message = "Không để trống thông tin")
    @Column(name = "trangthai")
    private int trangThai;

}
