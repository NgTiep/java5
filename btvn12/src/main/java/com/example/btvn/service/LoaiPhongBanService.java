package com.example.btvn.service;

import com.example.btvn.entity.LoaiPhongBan;

import java.util.List;
import java.util.UUID;

public interface LoaiPhongBanService{

    List<LoaiPhongBan> getAll();

    LoaiPhongBan getOne(UUID id);
}
