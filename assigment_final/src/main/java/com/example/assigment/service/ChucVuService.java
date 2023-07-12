package com.example.assigment.service;


import com.example.assigment.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ChucVuService {

    Page<ChucVu> getAll(Pageable pageable);

    ChucVu getOne(UUID id);

    void add(ChucVu chucVu);

    void update(ChucVu chucVu);

    void delete(UUID id);
}
