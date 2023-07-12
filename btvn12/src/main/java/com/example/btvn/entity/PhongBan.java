package com.example.btvn.entity;

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
@Table(name = "phong_ban")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loai_phong_ban_id", referencedColumnName = "id")
    private LoaiPhongBan loaiPhongBan;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "khong de trong truong")
    @Column(name = "so_luong_phong_ban")
    private Integer soLuongPhongBan;

    @NotNull(message = "khong de trong truong")
    @Column(name = "so_luong_nhan_vien")
    private Integer soLuongNhanVien;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @NotNull(message = "khong de trong truong")
    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_chinh_sua")
    private String ngayChinhSua;
}
