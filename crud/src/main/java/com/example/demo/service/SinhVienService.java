package com.example.demo.service;

import com.example.demo.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> getAll();

    List<SinhVien> search(List<SinhVien> list, String ten);

    List<SinhVien> giangVienNu(List<SinhVien> list, boolean gioiTinh);

    List<SinhVien> sortTuoi(List<SinhVien> list);

}
