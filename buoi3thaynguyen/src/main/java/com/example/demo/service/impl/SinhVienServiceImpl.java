package com.example.demo.service.impl;

import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {
    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien(1, "a", 21, "thai binh"));
        listSinhVien.add(new SinhVien(2, "a", 21, "thai binh"));
        listSinhVien.add(new SinhVien(3, "a", 21, "thai binh"));
        listSinhVien.add(new SinhVien(4, "a", 21, "thai binh"));
        return listSinhVien;
    }

    public int viTri(List<SinhVien> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
