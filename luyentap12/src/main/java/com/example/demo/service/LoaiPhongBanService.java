package com.example.demo.service;

import com.example.demo.entity.LoaiPhongBan;

import java.util.List;
import java.util.UUID;

public interface LoaiPhongBanService {

    List<LoaiPhongBan> getAll();

    LoaiPhongBan getOne(UUID id);
}
