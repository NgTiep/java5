package com.demo.service;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {

    Page<KhachHang> getAll(Pageable pageable);

    KhachHang getOne(Long maKhachHang);

    void save(KhachHang khachHang);

    void delete(Long maKhachHang);

    Page<KhachHang> search(String nhapGiaTri, HangKhachHang hangKhachHang, Pageable pageable);

}
