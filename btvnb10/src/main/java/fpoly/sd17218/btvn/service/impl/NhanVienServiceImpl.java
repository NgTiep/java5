package fpoly.sd17218.btvn.service.impl;

import fpoly.sd17218.btvn.entity.NhanVien;
import fpoly.sd17218.btvn.repository.NhanVienRepository;
import fpoly.sd17218.btvn.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nhanVienRepository.findById(id).get();
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);

    }

    @Override
    public Page<NhanVien> search(String ten, Pageable pageable) {
        return nhanVienRepository.search("%" + ten + "%", pageable);
    }

    @Override
    public     Page<NhanVien> sort(Pageable pageable){
        return nhanVienRepository.sort(pageable);
    }

}
