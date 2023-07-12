package com.example.btvn13.service;

import com.example.btvn13.entity.CoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CoSoService {

    Page<CoSo> getAll(Pageable pageable);

    CoSo getOne(UUID id);

    void delete(UUID id);

    void add(CoSo coSo);

    void update(CoSo coSo);
}
