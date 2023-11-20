package com.example.rest.service;

import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GraphQLPerformanceServiceRealization implements GraphQLPerformanceService{
    private final PerformanceRepository performanceRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public GraphQLPerformanceServiceRealization(PerformanceRepository performanceRepository,
                                         ModelMapper modelMapper) {
        this.performanceRepository = performanceRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Performance createPerformance(String name, Date date) {
        final Performance performance=new Performance();
        performance.setName(name);
        performance.setDate(date);
        return performanceRepository.save(performance);
    }

    @Override
    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    @Override
    public Performance getPerformanceById(String id) {
        return performanceRepository.getById(id);
    }

}
