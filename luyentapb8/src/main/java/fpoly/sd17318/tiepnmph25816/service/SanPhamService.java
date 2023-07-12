package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham detail(int id);

    void add(SanPham sanPham);

    void delete(int id);

    int viTri(List<SanPham>list, int id);

    SanPham update(List<SanPham>list, int id);
}

