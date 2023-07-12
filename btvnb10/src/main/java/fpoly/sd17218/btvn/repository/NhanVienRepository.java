package fpoly.sd17218.btvn.repository;

import fpoly.sd17218.btvn.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query(value = "SELECT * FROM nhan_vien WHERE nhan_vien.ten like ?1",nativeQuery = true)
    Page<NhanVien> search(String ten, Pageable pageable);

    @Query(value = "select * from nhan_vien order by nhan_vien.ten desc",nativeQuery = true)
    Page<NhanVien> sort(Pageable pageable);



}
