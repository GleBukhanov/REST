package com.example.rest.repository;

import com.example.rest.model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, String> {

    Performance findByName(String name);

    Performance findPerformanceById(String id);

    List<Performance> findByDate(Date date);
}
