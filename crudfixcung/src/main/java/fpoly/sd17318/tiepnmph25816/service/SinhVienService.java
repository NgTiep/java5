package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> getAll();

    List<SinhVien> searchSinhVien(List<SinhVien> list, String ten);

    List<SinhVien> sinhVienNam(List<SinhVien> list, boolean gioiTinh);

    List<SinhVien> sortSinhVien(List<SinhVien> list);

    void delete(List<SinhVien> list, int id);

    SinhVien detail(List<SinhVien> list, int id);

    void add(SinhVien sinhVien);

    SinhVien update(List<SinhVien> list, int id);

    int viTri(List<SinhVien> list, int id);

}
