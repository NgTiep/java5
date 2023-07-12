package com.demo.repo;

import com.demo.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface ReportRepo extends JpaRepository<Report, Serializable> {
    @Query("SELECT new Report(o.category, sum(o.price), count(o)) "
            + " FROM Product o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();

}
