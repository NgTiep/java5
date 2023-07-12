package fpoly.sd17218.btvn.service;

import fpoly.sd17218.btvn.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(UUID id);
}
