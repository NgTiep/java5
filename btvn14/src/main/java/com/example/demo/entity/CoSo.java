package com.example.demo.entity;

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

    @NotBlank(message = "khong de trong truong")
    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @NotBlank(message = "khong de trong truong")
    @Column(name = "ghi_chu")
    private String ghiChu;

    @NotNull(message = "khong de trong truong")
    @Column(name = "trang_thai")
    private Integer trangThai;

}
