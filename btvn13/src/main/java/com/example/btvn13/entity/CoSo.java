package com.example.btvn13.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

import java.util.UUID;


@Entity
@Table(name = "co_so")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoSo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tai_khoan_ngan_hang_id", referencedColumnName = "id")
    private TaiKhoanNganHang taiKhoanNganHang;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_co_so")
    private String tenCoSo;

    @Column(name = "ho_ten_nguoi_dai_dien")
    private String hoTenNguoiDaiDien;

    @Column(name = "ma_so_thue")
    private String maSoThue;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "ten_tinh")
    private String tenTinh;

    @Column(name = "ten_thanh_pho")
    private String tenThanhPho;

    @Column(name = "ten_quan_huyen")
    private String tenQuanHuyen;

    @NotNull(message = "khong de trong truong")
    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_chinh_sua")
    private String ngayChinhSua;
}
