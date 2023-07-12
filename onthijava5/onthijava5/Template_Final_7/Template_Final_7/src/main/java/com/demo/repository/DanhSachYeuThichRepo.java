package com.demo.repository;

import com.demo.entity.DanhSachYeuThich;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DanhSachYeuThichRepo extends JpaRepository<DanhSachYeuThich, UUID> {

    @Query(value = " select * from DanhSachYeuThich  Where (NgayTao like ?1 or NgayCapNhap like ?2) and NguoiSoHuu =?3",nativeQuery = true)
    Page<DanhSachYeuThich> search(String ngayTao, String ngayCapNhap, KhachHang khachHang, Pageable pageable);
}
