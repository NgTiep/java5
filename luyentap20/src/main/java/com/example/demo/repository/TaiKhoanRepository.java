package com.example.demo.repository;

import com.example.demo.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, UUID> {

    @Query(value = "select * from tai_khoan where ngay_sinh between ?1 and ?2",nativeQuery = true)
    Page<TaiKhoan> search(String toDate, String endDate, Pageable pageable);
}
