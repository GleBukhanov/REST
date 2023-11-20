package com.example.rest.service;

import com.example.rest.model.Performance;
import com.example.rest.service.performanceDTO.InputPerformanceDTO;

import java.util.Date;
import java.util.List;

public interface GraphQLPerformanceService {
    Performance createPerformance(String name, Date date);
    List<Performance> getAllPerformances();
    Performance getPerformanceById(String id);

}
