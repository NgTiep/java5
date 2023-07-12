package com.example.assigment.service;

import com.example.assigment.entity.DongSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DongSPService {

    Page<DongSP> getAll(Pageable pageable);

    DongSP getOne(UUID id);

    void add(DongSP dongSP);

    void update(DongSP dongSP);

    void delete(UUID id);
}
