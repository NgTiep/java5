package com.demo.repository;

import com.demo.entity.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GioHangRepo extends JpaRepository<GioHang, UUID> {

    @Query(value = "select * from GioHang order by NgayTao DESC , NguoiSoHuu ASC",nativeQuery = true)
    Page<GioHang> sort(Pageable pageable);
}
