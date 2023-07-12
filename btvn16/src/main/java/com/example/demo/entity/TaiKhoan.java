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
@Table(name = "tai_khoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chuc_vu_id", referencedColumnName = "id")
    private ChucVu chucVu;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ten_tai_khoan")
    private String tenTaiKhoan;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ho")
    private String ho;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ten_dem")
    private String tenDem;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Không để trống thông tin")
    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @NotNull(message = "Không để trống thông tin")
    @Column(name = "trang_thai")
    private int trangThai;

}
