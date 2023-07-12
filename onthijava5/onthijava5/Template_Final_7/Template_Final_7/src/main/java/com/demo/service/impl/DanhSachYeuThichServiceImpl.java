package com.demo.service.impl;

import com.demo.entity.DanhSachYeuThich;
import com.demo.entity.KhachHang;
import com.demo.repository.DanhSachYeuThichRepo;
import com.demo.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DanhSachYeuThichServiceImpl implements DanhSachYeuThichService {

    @Autowired
    DanhSachYeuThichRepo danhSachYeuThichRepo;

    @Override
    public Page<DanhSachYeuThich> getAll(Pageable pageable) {
        return danhSachYeuThichRepo.findAll(pageable);
    }

    @Override
    public DanhSachYeuThich getOne(UUID maDanhSach) {
        return danhSachYeuThichRepo.findById(maDanhSach).get();
    }

    @Override
    public void save(DanhSachYeuThich danhSachYeuThich) {
        danhSachYeuThichRepo.save(danhSachYeuThich);
    }

    @Override
    public void delete(UUID maDanhSach) {
        danhSachYeuThichRepo.deleteById(maDanhSach);
    }

    @Override
    public Page<DanhSachYeuThich> search(String ngayTao, String ngayCapNhap, KhachHang khachHang, Pageable pageable) {
        return danhSachYeuThichRepo.search("%"+ngayTao+"%","%"+ngayCapNhap+"%",khachHang,pageable);
    }
}
