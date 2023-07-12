package com.demo.service.impl;

import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import com.demo.repository.TheThanhVienRepo;
import com.demo.service.TheThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TheThanhVienServiceImpl implements TheThanhVienService {

    @Autowired
    TheThanhVienRepo theThanhVienRepo;

    @Override
    public Page<TheThanhVien> getAll(Pageable pageable) {
        return theThanhVienRepo.findAll(pageable);
    }

    @Override
    public TheThanhVien getOne(String maThe) {
        return theThanhVienRepo.findById(maThe).get();
    }

    @Override
    public void save(TheThanhVien theThanhVien) {
        theThanhVienRepo.save(theThanhVien);
    }

    @Override
    public void delete(String maThe) {
        theThanhVienRepo.deleteById(maThe);
    }

    @Override
    public Page<TheThanhVien> search(String ngayPhatHanh, String ngayHuy, KhachHang khachHang, Pageable pageable) {
        return theThanhVienRepo.search("%" + ngayPhatHanh + "%", "%" + ngayHuy + "%", khachHang, pageable);
    }
}
