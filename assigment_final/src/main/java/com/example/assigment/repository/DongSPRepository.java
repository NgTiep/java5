package com.example.assigment.repository;

import com.example.assigment.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
}
