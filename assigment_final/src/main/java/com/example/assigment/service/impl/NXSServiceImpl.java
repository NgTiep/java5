package com.example.assigment.service.impl;

import com.example.assigment.entity.NXS;
import com.example.assigment.repository.NXSRepository;
import com.example.assigment.service.NXSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NXSServiceImpl implements NXSService {

    @Autowired
    NXSRepository nxsRepository;

    @Override
    public Page<NXS> getAll(Pageable pageable) {
        return nxsRepository.findAll(pageable);
    }

    @Override
    public NXS getOne(UUID id) {
        return nxsRepository.findById(id).get();
    }

    @Override
    public void add(NXS nxs) {
        nxsRepository.save(nxs);
    }

    @Override
    public void update(NXS nxs) {
        nxsRepository.save(nxs);

    }

    @Override
    public void delete(UUID id) {
        nxsRepository.deleteById(id);

    }
}
