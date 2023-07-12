package fpoly.sd17318.lab4.service;

import fpoly.sd17318.lab4.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham detail(int id);

    void add(SanPham sanPham);

    SanPham update(List<SanPham> list, int id);

    int viTri(List<SanPham> list, int id);

    void delete(int id);

    void clear();
}
