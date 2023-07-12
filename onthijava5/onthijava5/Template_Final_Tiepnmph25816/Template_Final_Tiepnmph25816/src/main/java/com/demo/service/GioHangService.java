package com.demo.service;

import com.demo.entity.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface GioHangService {

    Page<GioHang> getAll(Pageable pageable);

    GioHang getOne(UUID maGioHang);

    void save(GioHang gioHang);

    void delete(UUID maGioHang);
}
