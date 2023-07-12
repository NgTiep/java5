package com.poly.hangnt169.B3_CRUDListFixCung.service;

import com.poly.hangnt169.B3_CRUDListFixCung.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien>getAll();

    void addSinhVien(SinhVien sinhVien);

    SinhVien detailSinhVien(String ma);

    void deleteSinhVien(String ma);

}
