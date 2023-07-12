package com.demo.service;

import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TheThanhVienService {

    Page<TheThanhVien> getAll(Pageable pageable);

    TheThanhVien getOne(String maThe);

    void save(TheThanhVien theThanhVien);

    void delete(String maThe);

    Page<TheThanhVien> search(String ngayPhatHanh, String ngayHuy, KhachHang khachHang, Pageable pageable);

}
