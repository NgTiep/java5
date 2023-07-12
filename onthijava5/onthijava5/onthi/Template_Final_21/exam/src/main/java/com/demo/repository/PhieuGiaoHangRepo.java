package com.demo.repository;

import com.demo.entity.HoaDon;
import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = " select * from PhieuGiaoHang where  NgayGiao>= ?1 and NgayNhan<= ?2 and HoaDonGiao =?3", nativeQuery = true)
    Page<PhieuGiaoHang> searchAll(String ngayGiao, String ngayNhan, HoaDon hoaDon, Pageable pageable);

    @Query(value = " select * from PhieuGiaoHang where  HoaDonGiao =?1", nativeQuery = true)
    Page<PhieuGiaoHang> searchCBB(HoaDon hoaDon, Pageable pageable);


}
