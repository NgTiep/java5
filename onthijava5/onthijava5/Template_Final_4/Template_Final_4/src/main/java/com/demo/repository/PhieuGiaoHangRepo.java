package com.demo.repository;

import com.demo.entity.DiaChi;
import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = " select * from PhieuGiaoHang where (NguoiNhan like ?1 or SdtNhan like ?1) and DiaChiGiao= ?2",nativeQuery = true)
    Page<PhieuGiaoHang> search(String nhapGiaTri, DiaChi diaChi, Pageable pageable);
}
