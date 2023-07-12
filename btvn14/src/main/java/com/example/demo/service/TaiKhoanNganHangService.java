package com.example.demo.service;

import com.example.demo.entity.TaiKhoanNganHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TaiKhoanNganHangService {

    Page<TaiKhoanNganHang> getAll(Pageable pageable);

    TaiKhoanNganHang getOne(UUID id);
}
