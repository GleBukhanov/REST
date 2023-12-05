package com.example.rest.service;

import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GraphQLPerformanceServiceRealization {
    public PerformanceRepository performanceRepository;

    public GraphQLPerformanceServiceRealization(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;

    }


    @Transactional
    public Performance createPerformance(final String name, final Date date) {
        Performance performance=new Performance();
        performance.setName(name);
        performance.setDate(date);
        return performanceRepository.saveAndFlush(performance);
    }

    @Transactional
    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    @Transactional
    public Optional<Performance> getPerformanceById(String id) {
        return this.performanceRepository.findById(id);
    }

}
