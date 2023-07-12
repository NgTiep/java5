package com.example.btvn13.repository;

import com.example.btvn13.entity.CoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CoSoRepository extends JpaRepository<CoSo, UUID> {
}
