package com.example.demo.repository;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Query(value = "select * from khachhang where(tenkhachhang=?1 or sodienthoai=?1 or makhachhang=?1 ) and HangKhachHang=?2", nativeQuery = true)
    Page<KhachHang> search( String timKiem, HangKhachHang hangKhachHang, Pageable pageable);
}
