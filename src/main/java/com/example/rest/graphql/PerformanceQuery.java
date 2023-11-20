package com.example.rest.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PerformanceQuery implements GraphQLQueryResolver {
    PerformanceRepository repo;
    public PerformanceQuery(PerformanceRepository repository) {
        this.repo = repository;
    }

    public Iterable<Performance> getAllPerformances() {
        return repo.findAll();
    }

    public Performance getPerformanceById(String id) {
        return repo.findPerformanceById(id);
    }
}
