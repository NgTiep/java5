package com.example.demo.service;

import com.example.demo.entity.CoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CoSoService {

    Page<CoSo> getAll(Pageable pageable);

    CoSo getOne(UUID id);

    void add(CoSo coSo);

    void update(CoSo coSo);

    void delete(UUID id);
}
