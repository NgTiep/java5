package fpoly.sd17318.tiepnmph25816.repository;

import fpoly.sd17318.tiepnmph25816.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LopHocRepository extends JpaRepository<LopHoc, Long> {

    @Query(value = "SELECT * FROM lop_hoc c WHERE c.name = ?1",nativeQuery = true)
    List<LopHoc> search(String name);
}
