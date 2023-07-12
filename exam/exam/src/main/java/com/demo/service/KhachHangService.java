package com.demo.service;

import com.demo.entity.KhachHang;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(Long maKhachHang);
}
