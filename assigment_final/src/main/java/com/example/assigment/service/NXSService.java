package com.example.assigment.service;

import com.example.assigment.entity.NXS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NXSService {

    Page<NXS> getAll(Pageable pageable);

    NXS getOne(UUID id);

    void add(NXS nxs);

    void update(NXS nxs);

    void delete(UUID id);
}
