package com.example.demo.service.impl;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepo;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    TaiKhoanRepo taiKhoanRepo;

    @Override
    public Page<TaiKhoan> getAll(Pageable pageable) {
        return taiKhoanRepo.findAll(pageable);
    }

    @Override
    public void add(TaiKhoan taiKhoan) {
        taiKhoanRepo.save(taiKhoan);
    }

    @Override
    public void update(TaiKhoan taiKhoan) {
        taiKhoanRepo.save(taiKhoan);
    }

    @Override
    public void delete(UUID id) {
        taiKhoanRepo.deleteById(id);
    }

    @Override
    public TaiKhoan getOne(UUID id) {
        return taiKhoanRepo.findById(id).get();
    }
}
