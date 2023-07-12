package com.example.btvn15.repository;

import com.example.btvn15.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, UUID> {

    @Query(value = "select * from tai_khoan where ten like ?1",nativeQuery = true)
    Page<TaiKhoan> search(String ten,Pageable pageable);

    @Query(value = "select * from tai_khoan where trang_thai='0'",nativeQuery = true)
    Page<TaiKhoan> hoaDong(Pageable pageable);

    @Query(value = "select * from tai_khoan order by ten asc",nativeQuery = true)
    Page<TaiKhoan> sapXep(Pageable pageable);
}
