package com.example.btvn.service.impl;

import com.example.btvn.entity.LoaiPhongBan;
import com.example.btvn.repository.LoaiPhongBanRepository;
import com.example.btvn.service.LoaiPhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoaiPhongBanServiceImpl implements LoaiPhongBanService {

    @Autowired
    LoaiPhongBanRepository phongBanRepository;

    @Override
    public List<LoaiPhongBan> getAll() {
        return phongBanRepository.findAll();
    }

    @Override
    public LoaiPhongBan getOne(UUID id) {
        return phongBanRepository.findById(id).get();
    }
}
