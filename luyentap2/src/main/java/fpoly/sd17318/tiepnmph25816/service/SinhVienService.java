package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> getAll();

    List<SinhVien> search(List<SinhVien> list, String ten);

    List<SinhVien> sinhVienNam(List<SinhVien> list, boolean gioiTinh);

    void sapXep(List<SinhVien> list);

    int viTri(List<SinhVien> list, int id);

    void add(SinhVien sinhVien);

    SinhVien detail(List<SinhVien> list, int id);

    SinhVien update(List<SinhVien> list, int id);

    void delete(List<SinhVien> list, int id);

}
