package fpoly.sd17318.tiepnmph25816.service.impl;

import fpoly.sd17318.tiepnmph25816.entity.LopHoc;
import fpoly.sd17318.tiepnmph25816.repository.LopHocRepository;
import fpoly.sd17318.tiepnmph25816.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LopHocServiceImpl implements LopHocService {

    @Autowired
    LopHocRepository lopHocRepository;


    @Override
    public Page<LopHoc> getAll(Pageable pageable) {
        return lopHocRepository.findAll(pageable);
    }

    @Override
    public LopHoc detail(long id) {
        return lopHocRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        lopHocRepository.deleteById(id);
    }

    @Override
    public void add(LopHoc lopHoc) {
        lopHocRepository.save(lopHoc);
    }

    @Override
    public void update(LopHoc lopHoc) {
        lopHocRepository.save(lopHoc);
    }

    @Override
    public List<LopHoc> search(String name) {
        return lopHocRepository.search(name);
    }


}
