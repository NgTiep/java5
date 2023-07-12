package com.example.assigment.repository;

import com.example.assigment.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
