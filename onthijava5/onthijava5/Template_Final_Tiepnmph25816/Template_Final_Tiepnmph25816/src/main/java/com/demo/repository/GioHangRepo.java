package com.demo.repository;

import com.demo.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepo extends JpaRepository<GioHang, UUID> {
}
