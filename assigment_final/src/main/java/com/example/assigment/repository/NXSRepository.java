package com.example.assigment.repository;

import com.example.assigment.entity.NXS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NXSRepository extends JpaRepository<NXS, UUID> {
}
