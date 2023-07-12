package fpoly.sd17218.btvn.service.impl;

import fpoly.sd17218.btvn.entity.ChucVu;
import fpoly.sd17218.btvn.repository.ChucVuRepository;
import fpoly.sd17218.btvn.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepository.findById(id).get();
    }
}
