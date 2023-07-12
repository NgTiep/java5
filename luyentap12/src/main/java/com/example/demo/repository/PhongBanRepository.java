package com.example.demo.repository;

import com.example.demo.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, UUID> {

    @Query(value = "SELECT * FROM phong_ban WHERE phong_ban.ten LIKE ?1", nativeQuery = true)
    Page<PhongBan> searchTen(String ten, Pageable pageable);

    @Query(value = "SELECT * FROM phong_ban WHERE phong_ban.so_luong_phong_ban between ?1 and ?2", nativeQuery = true)
    Page<PhongBan> minMax(int min, int max, Pageable pageable);

    @Query(value = "SELECT * FROM phong_ban order by phong_ban.so_luong_nhan_vien desc", nativeQuery = true)
    Page<PhongBan> sapXep(Pageable pageable);

    @Query(value = "SELECT * FROM phong_ban WHERE phong_ban.trang_thai='0'", nativeQuery = true)
    Page<PhongBan> hoatDong(Pageable pageable);


}
