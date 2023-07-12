package com.example.assigment.service;

import com.example.assigment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MauSacService {

    Page<MauSac> getAll(Pageable pageable);

    MauSac getOne(UUID id);

    void add(MauSac mauSac);

    void update(MauSac mauSac);

    void delete(UUID id);
}
