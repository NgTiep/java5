package com.example.demo.service.impl;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.TaiKhoanService;
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
    public void update(TaiKhoan taiKhoan) {
        taiKhoanRepository.save(taiKhoan);

    }

    @Override
    public void delete(UUID id) {
        taiKhoanRepository.deleteById(id);

    }

    @Override
    public Page<TaiKhoan> search(String tenTaiKhoan, Pageable pageable) {
        return taiKhoanRepository.search("%" + tenTaiKhoan + "%", pageable);
    }
}
