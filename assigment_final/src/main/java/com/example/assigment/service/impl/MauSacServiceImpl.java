package com.example.assigment.service.impl;

import com.example.assigment.entity.MauSac;
import com.example.assigment.repository.MauSacRepository;
import com.example.assigment.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.findById(id).get();
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void update(MauSac mauSac) {
        mauSacRepository.save(mauSac);

    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);

    }
}
