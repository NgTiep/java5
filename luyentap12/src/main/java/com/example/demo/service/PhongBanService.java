package com.example.demo.service;

import com.example.demo.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PhongBanService {

    Page<PhongBan> getAll(Pageable pageable);

    PhongBan getOne(UUID id);

    void add(PhongBan phongBan);

    void delete(UUID id);

    void update(PhongBan phongBan);

    Page<PhongBan> searchTen(String ten, Pageable pageable);

    Page<PhongBan> minMax(int min, int max, Pageable pageable);

    Page<PhongBan> sapXep(Pageable pageable);

    Page<PhongBan> hoatDong(Pageable pageable);


}
