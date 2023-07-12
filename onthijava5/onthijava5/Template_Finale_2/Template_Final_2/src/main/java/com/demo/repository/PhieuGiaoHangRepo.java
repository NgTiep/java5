package com.demo.repository;

import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {
}
