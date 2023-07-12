package com.example.btvn.repository;

import com.example.btvn.entity.LoaiPhongBan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoaiPhongBanRepository extends JpaRepository<LoaiPhongBan, UUID> {
}
