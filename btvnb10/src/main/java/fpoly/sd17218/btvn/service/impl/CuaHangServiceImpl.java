package fpoly.sd17218.btvn.service.impl;

import fpoly.sd17218.btvn.entity.CuaHang;
import fpoly.sd17218.btvn.repository.CuaHangRepository;
import fpoly.sd17218.btvn.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.findById(id).get();
    }
}
