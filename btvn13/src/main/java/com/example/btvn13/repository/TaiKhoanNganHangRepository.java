package com.example.btvn13.repository;

import com.example.btvn13.entity.TaiKhoanNganHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TaiKhoanNganHangRepository extends JpaRepository<TaiKhoanNganHang, UUID> {
}
