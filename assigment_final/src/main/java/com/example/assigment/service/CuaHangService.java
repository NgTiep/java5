package com.example.assigment.service;

import com.example.assigment.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CuaHangService {

    Page<CuaHang> getAll(Pageable pageable);

    CuaHang getOne(UUID id);

    void add(CuaHang cuaHang);

    void update(CuaHang cuaHang);

    void delete(UUID id);
}
