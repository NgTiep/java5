package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    void add(SanPham sanPham);

    SanPham detail(int id);

    void sapXep(List<SanPham> list);

    List<SanPham> search(List<SanPham> list, String ten);

    List<SanPham> loai1(List<SanPham> list, String loai);

    void delete(int id);

    int viTri(List<SanPham>list, int id);

    SanPham update(List<SanPham>list, int id);
}
