package com.example.demo.service.impl;

import com.example.demo.entity.PhongBan;
import com.example.demo.repository.PhongBanRepository;
import com.example.demo.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhongBanServiceImpl implements PhongBanService {

    @Autowired
    PhongBanRepository phongBanRepository;


    @Override
    public Page<PhongBan> getAll(Pageable pageable) {
        return phongBanRepository.findAll(pageable);
    }

    @Override
    public PhongBan getOne(UUID id) {
        return phongBanRepository.findById(id).get();
    }

    @Override
    public void add(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    @Override
    public void delete(UUID id) {
        phongBanRepository.deleteById(id);
    }

    @Override
    public void update(PhongBan phongBan) {
        phongBanRepository.save(phongBan);

    }

    @Override
    public Page<PhongBan> searchTen(String ten, Pageable pageable) {
        return phongBanRepository.searchTen("%" + ten + "%", pageable);
    }

    @Override
    public Page<PhongBan> minMax(int min, int max, Pageable pageable) {
        return phongBanRepository.minMax(min, max, pageable);
    }

    @Override
    public Page<PhongBan> sapXep(Pageable pageable) {
        return phongBanRepository.sapXep(pageable);
    }

    @Override
    public Page<PhongBan> hoatDong(Pageable pageable) {
        return phongBanRepository.hoatDong(pageable);
    }
}
