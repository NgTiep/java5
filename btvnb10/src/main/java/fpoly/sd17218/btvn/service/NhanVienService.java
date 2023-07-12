package fpoly.sd17218.btvn.service;

import fpoly.sd17218.btvn.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    Page<NhanVien> getAll(Pageable pageable);

    NhanVien getOne(UUID id);

    void delete(UUID id);

    void add(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    Page<NhanVien> search(String ten, Pageable pageable);

    Page<NhanVien> sort(Pageable pageable);

}
