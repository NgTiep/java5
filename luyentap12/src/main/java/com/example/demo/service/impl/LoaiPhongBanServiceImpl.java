package com.example.demo.service.impl;

import com.example.demo.entity.LoaiPhongBan;
import com.example.demo.repository.LoaiPhongBanRepository;
import com.example.demo.service.LoaiPhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoaiPhongBanServiceImpl implements LoaiPhongBanService {

    @Autowired
    LoaiPhongBanRepository loaiPhongBanRepository;

    @Override
    public List<LoaiPhongBan> getAll() {
        return loaiPhongBanRepository.findAll();
    }

    @Override
    public LoaiPhongBan getOne(UUID id) {
        return loaiPhongBanRepository.findById(id).get();
    }
}
