package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, String> {
//
//    @Query(value = "select * from PhieuGiamGia where NgayBatDau= ?1 or NgayKetThuc= ?2 and NguoiSoHuu like ?3", nativeQuery = true)
//    Page<PhieuGiamGia> search(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable);
//

    @Query(value = "select * from PhieuGiamGia where NgayBatDau=?1 or NgayKetThuc= ?2 and NguoiSoHuu like ?3",nativeQuery = true)
    Page<PhieuGiamGia> search(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable);
}
