package com.example.assigment.repository;

import com.example.assigment.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
}
