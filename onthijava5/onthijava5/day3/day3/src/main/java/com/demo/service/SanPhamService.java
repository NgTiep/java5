package com.demo.service;

import com.demo.model.SanPham;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SanPhamService {

    private List<SanPham> listSanPham = new ArrayList<>();

    Map<Integer, SanPham> items = new HashMap(){{
        put(1, new SanPham(1, "iphon1",11));
        put(2, new SanPham(2, "iphon2",21));
        put(3, new SanPham(3, "iphon3",41));
    }};

    public List<SanPham> getAll() {
        return new ArrayList<>(items.values());
    }

    public SanPham getById(int id){
        return items.get(id);
    }

}
