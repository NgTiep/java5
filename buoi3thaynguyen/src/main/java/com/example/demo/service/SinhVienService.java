package com.example.demo.service;

import com.example.demo.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> getAll();

    int viTri(List<SinhVien> list, int id);
}
