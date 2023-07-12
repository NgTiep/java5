package com.example.demo.service.impl;

import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {
    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        list.add(new SinhVien("mssv1", "a", 20, true, "thai binh"));
        list.add(new SinhVien("mssv2", "b", 21, false, "thai binh"));
        list.add(new SinhVien("mssv3", "c", 22, true, "thai binh"));
        list.add(new SinhVien("mssv4", "d", 23, false, "thai binh"));
        return list;
    }

    @Override
    public List<SinhVien> search(List<SinhVien> list, String ten) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(ten)) {
                listSinhVien.add(list.get(i));
            }
        }
        return listSinhVien;
    }

    @Override
    public List<SinhVien> giangVienNu(List<SinhVien> list, boolean gioiTinh) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isGioiTinh() == false) {
                listSinhVien.add(list.get(i));
            }
        }
        return listSinhVien;
    }

    @Override
    public List<SinhVien> sortTuoi(List<SinhVien> list) {
        list.sort((o1, o2) -> o2.getTuoi() - o1.getTuoi());
        return list;
    }
}
