package com.demo.service.impl;

import com.demo.entity.DiaChi;
import com.demo.repository.DiaChiRepo;
import com.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaChiServiceImpl implements DiaChiService {

    @Autowired
    DiaChiRepo diaChiRepo;

    @Override
    public List<DiaChi> getAll() {
        return diaChiRepo.findAll();
    }
}
