package com.example.assigment.service.impl;

import com.example.assigment.entity.DongSP;
import com.example.assigment.repository.DongSPRepository;
import com.example.assigment.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {

    @Autowired
    DongSPRepository dongSPRepository;

    @Override
    public Page<DongSP> getAll(Pageable pageable) {
        return dongSPRepository.findAll(pageable);
    }

    @Override
    public DongSP getOne(UUID id) {
        return dongSPRepository.findById(id).get();
    }

    @Override
    public void add(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void update(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void delete(UUID id) {
        dongSPRepository.deleteById(id);
    }
}
