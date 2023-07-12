package com.example.btvn15.service.impl;

import com.example.btvn15.entity.TaiKhoan;
import com.example.btvn15.repository.TaiKhoanRepository;
import com.example.btvn15.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Override
    public Page<TaiKhoan> getAll(Pageable pageable) {
        return taiKhoanRepository.findAll(pageable);
    }

    @Override
    public TaiKhoan getOne(UUID id) {
        return taiKhoanRepository.findById(id).get();
    }

    @Override
    public void add(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public void delete(UUID id) {
        taiKhoanRepository.deleteById(id);
    }

    @Override
    public void update(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);
    }

    @Override
    public Page<TaiKhoan> search(String ten, Pageable pageable) {
        return taiKhoanRepository.search("%" + ten + "%", pageable);
    }

    @Override
    public Page<TaiKhoan> hoaDong(Pageable pageable) {
        return taiKhoanRepository.hoaDong(pageable);
    }

    @Override
    public Page<TaiKhoan> sapXep(Pageable pageable) {
        return taiKhoanRepository.sapXep(pageable);
    }
}
