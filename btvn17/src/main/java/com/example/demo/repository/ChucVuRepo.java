package com.example.demo.repository;

import com.example.demo.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRepo extends JpaRepository<ChucVu, UUID> {
}
