package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangRepository extends JpaRepository<Hang, Long> {
}
