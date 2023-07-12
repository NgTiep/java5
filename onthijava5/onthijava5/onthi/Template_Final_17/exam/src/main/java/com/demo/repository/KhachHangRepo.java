package com.demo.repository;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Query(value = " select * from KhachHang where (TenKhachHang like ?1 or SoDienThoai like ?1) and HangKhachHang =?2", nativeQuery = true)
    Page<KhachHang> search(String giaTri, HangKhachHang hangKhachHang, Pageable pageable);
}
