package com.demo.repository;

import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, String> {

    @Query(value = " select * from PhieuGiamGia where NgayBatDau >= ?1 and NgayKetThuc <= ?2 and NguoiSoHuu =?3", nativeQuery = true)
    Page<PhieuGiamGia> searchAll(String ngayBatDau, String ngayKetThuc, KhachHang khachHang, Pageable pageable);

    @Query(value = " select * from PhieuGiamGia where NguoiSoHuu =?1", nativeQuery = true)
    Page<PhieuGiamGia> searchCBB(KhachHang khachHang, Pageable pageable);
}
