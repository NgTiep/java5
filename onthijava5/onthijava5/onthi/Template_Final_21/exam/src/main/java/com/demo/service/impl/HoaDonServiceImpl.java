package com.demo.service.impl;

import com.demo.entity.HoaDon;
import com.demo.repository.HoaDonRepo;
import com.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepo.findAll();
    }
}
