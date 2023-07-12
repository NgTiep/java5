package com.example.assigment.service.impl;

import com.example.assigment.entity.CuaHang;
import com.example.assigment.repository.CuaHangRepository;
import com.example.assigment.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    CuaHangRepository cuaHangRepository;

    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.findById(id).get();
    }

    @Override
    public void add(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void delete(UUID id) {
        cuaHangRepository.deleteById(id);
    }
}
