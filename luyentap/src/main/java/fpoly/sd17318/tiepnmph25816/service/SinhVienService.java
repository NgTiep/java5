package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> getAll();

    int viTri(List<SinhVien> list, int id);

    SinhVien detail(List<SinhVien> list, int id);

    void delete(List<SinhVien> list, int id);

    void add(SinhVien sinhVien);

    List<SinhVien> searchTen(List<SinhVien> list, String ten);

    List<SinhVien> sinhVienNu(List<SinhVien> list, boolean gioiTinh);

    void sapXep(List<SinhVien> list);

    SinhVien update(List<SinhVien> list, int id);
}
