package com.demo.repository;

import com.demo.entity.GioHang;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GioHangRepo extends JpaRepository<GioHang, UUID> {
    @Query(value = " select * from GioHang where NgayTao >=?1 and NgayCapNhap<=?2 and NguoiSoHuu= ?3",nativeQuery = true)
    Page<GioHang> searchAll(String ngayTao, String ngayCapNhap, KhachHang khachHang, Pageable pageable);


    @Query(value = " select * from GioHang where  NguoiSoHuu= ?1",nativeQuery = true)
    Page<GioHang> searchKH(KhachHang khachHang, Pageable pageable);
}
