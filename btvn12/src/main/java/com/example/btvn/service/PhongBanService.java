package com.example.btvn.service;

import com.example.btvn.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PhongBanService {

    Page<PhongBan> getAll(Pageable pageable);

    PhongBan getOne(UUID id);

    void add(PhongBan phongBan);

    void update(PhongBan phongBan);

    void delete(UUID id);
}
