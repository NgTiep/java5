package com.demo.repository;

import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TheThanhVienRepo extends JpaRepository<TheThanhVien, String> {

    @Query(value = " select * from TheThanhVien where (NgayPhatHanh like ?1 or NgayHuy like ?2) and NguoiSoHuu =?3",nativeQuery = true)
    Page<TheThanhVien> search(String ngayPhatHanh, String ngayHuy, KhachHang khachHang, Pageable pageable);
}
