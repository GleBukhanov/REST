package com.example.rest.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.GraphQLPerformanceServiceRealization;
import com.example.rest.service.PerformanceService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class PerformanceMutations implements GraphQLMutationResolver {
    private GraphQLPerformanceServiceRealization service;
    private PerformanceRepository repo;

    public PerformanceMutations(GraphQLPerformanceServiceRealization service, PerformanceRepository performanceRepository) {
        this.repo=performanceRepository;
        this.service = service;
    }
    @MutationMapping
    public Performance createPerformance(String name,Date date) {
       return this.service.createPerformance(name,date);
    }

}
