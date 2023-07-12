package com.demo.service;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {

    Page<KhachHang> getAll(Pageable pageable);

    KhachHang getOne(Long maKH);

    void add(KhachHang khachHang);

    void update(KhachHang khachHang);

    void delete(Long maKH);

    Page<KhachHang> search(String nhapGiaTri, HangKhachHang hangKhachHang, Pageable pageable);

}
