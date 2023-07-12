package fpoly.sd17318.tiepnmph25816.service.impl;

import fpoly.sd17318.tiepnmph25816.entity.GiangVien;
import fpoly.sd17318.tiepnmph25816.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {

    private List<GiangVien> listGiangVien = new ArrayList<>();

    public GiangVienServiceImpl() {
        listGiangVien.add(new GiangVien("sv01", "Nguyen Van a", 21, "thai binh"));
        listGiangVien.add(new GiangVien("sv02", "Nguyen Van b", 19, "thai binh"));
        listGiangVien.add(new GiangVien("sv03", "Nguyen Van c", 22, "thai binh"));
        listGiangVien.add(new GiangVien("sv04", "Nguyen Van d", 17, "thai binh"));
    }

    @Override
    public List<GiangVien> getAll() {
        return listGiangVien;
    }

    @Override
    public void add(GiangVien giangVien) {
        listGiangVien.add(giangVien);
    }

    @Override
    public GiangVien detail(String ma) {
        for (GiangVien gv : listGiangVien) {
            if (gv.getMa().equalsIgnoreCase(ma)) {
                return gv;
            }
        }
        return null;
    }

    @Override
    public void delete(String ma) {
        GiangVien gv = detail(ma);
        listGiangVien.remove(gv);
    }

    @Override
    public List<GiangVien> search(List<GiangVien> list, String ten) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHoTen().equalsIgnoreCase(ten)) {
                listGiangVien.add(list.get(i));
            }
        }
        return listGiangVien;
    }

    @Override
    public void sapXep(List<GiangVien> list) {
        list.sort((o1, o2) -> o2.getTuoi() - o1.getTuoi());
    }

    @Override
    public List<GiangVien> searchMinMax(List<GiangVien> list, int min, int max) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (min <= list.get(i).getTuoi() && list.get(i).getTuoi() >= max) {
                listGiangVien.add(list.get(i));
            }
        }
        return listGiangVien;
    }

    @Override
    public int viTri(List<GiangVien> list, String ma) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getMa().equalsIgnoreCase(ma)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public GiangVien update(List<GiangVien> list, String ma) {
        int viTri = viTri(list, ma);
        return listGiangVien.get(viTri);
    }

}
