package com.example.btvn13.service;

import com.example.btvn13.entity.TaiKhoanNganHang;

import java.util.List;
import java.util.UUID;

public interface TaiKhoanNganHangService {

    List<TaiKhoanNganHang> getAll();

    TaiKhoanNganHang getOne(UUID id);
}
