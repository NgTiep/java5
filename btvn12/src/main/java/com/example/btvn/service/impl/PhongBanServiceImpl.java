package com.example.btvn.service.impl;

import com.example.btvn.entity.PhongBan;
import com.example.btvn.repository.PhongBanRepository;
import com.example.btvn.service.PhongBanService;
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
    public void update(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    @Override
    public void delete(UUID id) {
        phongBanRepository.deleteById(id);
    }
}
