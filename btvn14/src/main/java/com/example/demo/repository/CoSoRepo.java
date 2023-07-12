package com.example.demo.repository;

import com.example.demo.entity.CoSo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoSoRepo extends JpaRepository<CoSo, UUID> {
}
