package com.example.rest.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.PerformanceService;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class PerformanceMutations implements GraphQLMutationResolver {
    private PerformanceService service;
    private PerformanceRepository repo;

    public PerformanceMutations(PerformanceService service,PerformanceRepository performanceRepository) {
        this.repo=performanceRepository;
        this.service = service;
    }

    public Performance createPerformance(String name,Date date) {
        Performance performance = new Performance();
        performance.setName(name);
        performance.setDate(date);
        repo.save(performance);
        return performance;
    }

}
