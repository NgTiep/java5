package com.demo.service;

import com.demo.entity.DanhSachYeuThich;
import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DanhSachYeuThichService {

    Page<DanhSachYeuThich> getAll(Pageable pageable);

    DanhSachYeuThich getOne(UUID maDanhSach);

    void save(DanhSachYeuThich danhSachYeuThich);

    void delete(UUID maDanhSach);

    Page<DanhSachYeuThich> search(String ngayTao, String ngayCapNhap, KhachHang khachHang, Pageable pageable);

}
