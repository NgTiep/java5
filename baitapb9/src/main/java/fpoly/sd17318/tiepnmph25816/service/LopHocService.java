package fpoly.sd17318.tiepnmph25816.service;

import fpoly.sd17318.tiepnmph25816.entity.LopHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface LopHocService {

    Page<LopHoc> getAll(Pageable pageable);

    LopHoc detail(long id);

    void delete(long id);

    void add(LopHoc lopHoc);

    void update(LopHoc lopHoc);

    List<LopHoc> search(String name);


}
