package com.example.rest.repository;

import com.example.rest.model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, String> {

//    Performance findByName(String name);
//
//    Performance findPerformanceById(String id);
//
//    List<Performance> findByDate(Date date);
}
