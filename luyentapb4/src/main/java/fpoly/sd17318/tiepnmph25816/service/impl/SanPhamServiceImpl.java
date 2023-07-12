package fpoly.sd17318.tiepnmph25816.service.impl;

import fpoly.sd17318.tiepnmph25816.entity.SanPham;
import fpoly.sd17318.tiepnmph25816.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private List<SanPham> listSanPham = new ArrayList<>();

    public SanPhamServiceImpl() {
        listSanPham.add(new SanPham(1, "sp001", "a", 1000, true, "loai 1"));
        listSanPham.add(new SanPham(2, "sp002", "b", 900, false, "loai 2"));
        listSanPham.add(new SanPham(3, "sp003", "c", 10000, true, "loai 3"));
        listSanPham.add(new SanPham(4, "sp004", "d", 2000, false, "loai 4"));
    }

    @Override
    public List<SanPham> getAll() {
        return listSanPham;
    }

    @Override
    public void add(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    @Override
    public SanPham detail(int id) {
        for (SanPham sp : listSanPham) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        SanPham sanPham = detail(id);
        listSanPham.remove(sanPham);
    }

    @Override
    public List<SanPham> searchTen(List<SanPham> list, String ten) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equalsIgnoreCase(ten)) {
                listSanPham.add(list.get(i));
            }
        }
        return listSanPham;
    }

    @Override
    public List<SanPham> nam(List<SanPham> list, boolean gioiTinh) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isGioiTinh()==true) {
                listSanPham.add(list.get(i));
            }
        }
        return listSanPham;
    }

    @Override
    public void sapXep(List<SanPham> list) {
        list.sort((o1, o2) -> o2.getGia()-o1.getGia());
    }

    @Override
    public int viTri(List<SanPham> list, int id) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public SanPham update(List<SanPham> list, int id) {
        int viTri = viTri(list,id);
        return listSanPham.get(viTri);
    }
}
