package fpoly.sd17318.lab4.service.impl;

import fpoly.sd17318.lab4.entity.SanPham;
import fpoly.sd17318.lab4.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private List<SanPham> listSanPham = new ArrayList<>();

    public SanPhamServiceImpl() {
        listSanPham.add(new SanPham(1, "a", 2000, 2));
        listSanPham.add(new SanPham(2, "b", 4000, 20));
        listSanPham.add(new SanPham(3, "c", 5000, 10));
        listSanPham.add(new SanPham(4, "d", 2300, 5));
    }

    @Override
    public List<SanPham> getAll() {
        return listSanPham;
    }

    @Override
    public SanPham detail(int id) {
        for (SanPham sanPham : listSanPham) {
            if (sanPham.getId() == id) {
                return sanPham;
            }
        }
        return null;
    }

    @Override
    public void add(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    @Override
    public SanPham update(List<SanPham> list, int id) {
        int viTri = viTri(list, id);
        return listSanPham.get(viTri);
    }

    @Override
    public int viTri(List<SanPham> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(int id) {
        SanPham sanPham = detail(id);
        listSanPham.remove(sanPham);
    }

    @Override
    public void clear() {
        listSanPham.clear();
    }

}
