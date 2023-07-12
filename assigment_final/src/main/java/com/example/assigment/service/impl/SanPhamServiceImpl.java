package com.example.assigment.service.impl;

import com.example.assigment.entity.SanPham;
import com.example.assigment.repository.SanPhamRepository;
import com.example.assigment.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);

    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);

    }
}
