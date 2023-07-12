package com.example.demo.service.impl;

import com.example.demo.entity.CoSo;
import com.example.demo.repository.CoSoRepo;
import com.example.demo.service.CoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoSoServiceImpl implements CoSoService {

    @Autowired
    CoSoRepo coSoRepo;


    @Override
    public Page<CoSo> getAll(Pageable pageable) {
        return coSoRepo.findAll(pageable);
    }

    @Override
    public CoSo getOne(UUID id) {
        return coSoRepo.findById(id).get();
    }

    @Override
    public void add(CoSo coSo) {
        coSoRepo.save(coSo);
    }

    @Override
    public void update(CoSo coSo) {
        coSoRepo.save(coSo);
    }

    @Override
    public void delete(UUID id) {
        coSoRepo.deleteById(id);
    }
}
