package com.example.rest.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.GraphQLPerformanceServiceRealization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.rest.model.Performance;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Component
public class PerformanceQuery implements GraphQLQueryResolver {
    PerformanceRepository repo;
    GraphQLPerformanceServiceRealization service;

    public PerformanceQuery(PerformanceRepository repository, GraphQLPerformanceServiceRealization graphQLPerformanceServiceRealization) {
        this.repo = repository;
        this.service = graphQLPerformanceServiceRealization;
    }
    @GetMapping
    public List<Performance> getAllPerformances() {
        return this.service.getAllPerformances();
    }
    @GetMapping
    public Optional<Performance> getPerformanceById(String id) {
        return this.service.getPerformanceById(id);
    }
}
