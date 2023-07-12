package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.GiangVien;

import java.util.List;

public interface GiangVienService {

    List<GiangVien> getAll();

    void add(GiangVien giangVien);

    GiangVien detail(String ma);

    void delete(String ma);

    List<GiangVien> search(List<GiangVien>list, String ten);

    void sapXep(List<GiangVien>list);

    List<GiangVien> searchMinMax(List<GiangVien>list, int min, int max);

    int viTri(List<GiangVien>list, String ma);

    GiangVien update(List<GiangVien>list, String ma);
}
