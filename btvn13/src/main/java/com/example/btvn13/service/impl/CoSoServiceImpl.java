package com.example.btvn13.service.impl;

import com.example.btvn13.entity.CoSo;
import com.example.btvn13.repository.CoSoRepository;
import com.example.btvn13.service.CoSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoSoServiceImpl implements CoSoService {
    @Autowired
    CoSoRepository coSoRepository;

    @Override
    public Page<CoSo> getAll(Pageable pageable) {
        return coSoRepository.findAll(pageable);
    }

    @Override
    public CoSo getOne(UUID id) {
        return coSoRepository.findById(id).get();
    }

    @Override
    public void delete(UUID id) {
        coSoRepository.deleteById(id);
    }

    @Override
    public void add(CoSo coSo) {
        coSoRepository.save(coSo);
    }

    @Override
    public void update(CoSo coSo) {
        coSoRepository.save(coSo);
    }
}
