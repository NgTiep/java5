package com.demo.repository;

import com.demo.entity.DiaChi;
import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = " select * from PhieuGiaoHang where NgayGiao>= ?1 and NgayGiao<= ?2 and DiaChiGiao =?3", nativeQuery = true)
    Page<PhieuGiaoHang> search(String tuNgay, String denNgay, DiaChi diaChi, Pageable pageable);

    @Query(value = " select * from PhieuGiaoHang where DiaChiGiao =?1", nativeQuery = true)
    Page<PhieuGiaoHang> searchCBB(DiaChi diaChi, Pageable pageable);
}
