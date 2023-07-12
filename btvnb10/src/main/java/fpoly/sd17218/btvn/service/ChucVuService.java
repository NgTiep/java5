package fpoly.sd17218.btvn.service;

import fpoly.sd17218.btvn.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(UUID id);
}
