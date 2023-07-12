package fpoly.sd17318.tiepnmph25816.service.impl;

import fpoly.sd17318.tiepnmph25816.entity.SinhVien;
import fpoly.sd17318.tiepnmph25816.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {
    private List<SinhVien> listSinhVien = new ArrayList<>();


    public SinhVienServiceImpl() {
        listSinhVien.add(new SinhVien(1, "Nguyen Van a", 20, true, "Thai Binh"));
        listSinhVien.add(new SinhVien(2, "Nguyen Van b", 21, false, "Thai Binh"));
        listSinhVien.add(new SinhVien(3, "Nguyen Van c", 22, true, "Thai Binh"));
        listSinhVien.add(new SinhVien(4, "Nguyen Van d", 23, false, "Thai Binh"));
    }

    @Override
    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    @Override
    public List<SinhVien> searchSinhVien(List<SinhVien> list, String ten) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equalsIgnoreCase(ten)) {
                listSinhVien.add(list.get(i));
            }
        }
        return listSinhVien;
    }

    @Override
    public List<SinhVien> sinhVienNam(List<SinhVien> list, boolean gioiTinh) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isGioiTinh() == true) {
                listSinhVien.add(list.get(i));
            }
        }
        return listSinhVien;
    }

    @Override
    public List<SinhVien> sortSinhVien(List<SinhVien> list) {
        list.sort((o1, o2) -> o2.getTuoi() - o1.getTuoi());
        return list;
    }

    @Override
    public void delete(List<SinhVien> list, int id) {
        int viTri = viTri(list, id);
        listSinhVien.remove(viTri);
    }

    @Override
    public SinhVien detail(List<SinhVien> list, int id) {
        int viTri = viTri(list, id);
        return listSinhVien.get(viTri);
    }

    @Override
    public void add(SinhVien sinhVien) {
        listSinhVien.add(sinhVien);
    }

    @Override
    public SinhVien update(List<SinhVien> list, int id) {
        int viTri = viTri(list, id);
        return listSinhVien.get(viTri);
    }

    @Override
    public int viTri(List<SinhVien> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


}
