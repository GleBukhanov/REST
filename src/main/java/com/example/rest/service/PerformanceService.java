package com.example.rest.service;

import com.example.rest.model.Performance;
import com.example.rest.service.performanceDTO.InputPerformanceDTO;
import com.example.rest.service.performanceDTO.PerformanceDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface PerformanceService {
    void createPerformance(InputPerformanceDTO inputPerformanceDTO);
//    Performance findByName(String name);
//    List<Performance> getPerformanceByDate(Date date);
//    List<Performance> getAllPerformances();
//    Performance getPerformanceById(String id);
//    boolean updatePerformanceDate(PerformanceDTO performanceDTO);
//    boolean deletePerformanceById(PerformanceDTO performanceDTO);
//    Map<String, Object> getAllPerformancesHal(int index, int count);

}
