package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    void add(SanPham sanPham);

    SanPham detail(int id);

    void delete(int id);

    List<SanPham> searchTen(List<SanPham> list, String ten);

    List<SanPham> nam(List<SanPham> list, boolean gioiTinh);

    void sapXep(List<SanPham> list);

    int viTri(List<SanPham>list, int id);

    SanPham update(List<SanPham>list, int id);
}
