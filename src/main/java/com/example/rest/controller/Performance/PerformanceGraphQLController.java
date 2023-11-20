package com.example.rest.controller.Performance;

import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.GraphQLPerformanceService;
import com.example.rest.service.PerformanceService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
@Controller
public class PerformanceGraphQLController {

    private final GraphQLPerformanceService graphQLPerformanceService;
    private final PerformanceRepository repo;

    public PerformanceGraphQLController(GraphQLPerformanceService graphQLPerformanceService, PerformanceRepository repo) {
        this.graphQLPerformanceService = graphQLPerformanceService;
        this.repo = repo;
    }

    @MutationMapping("/graphiql")
    public ResponseEntity<?> createPostWithGraphQl(@Argument String name, @Argument Date date) {
        graphQLPerformanceService.createPerformance(name, date);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @QueryMapping("/graphiql")
    public ResponseEntity<?> getAllPerformancesGraphQL() {
        final List<Performance> performances = graphQLPerformanceService.getAllPerformances();
        return performances != null && !performances.isEmpty()
                ? new ResponseEntity<>(performances, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @QueryMapping("/graphiql/id")
    public ResponseEntity<?> getPerformanceByIdGraphQL(@Argument String id) {
        Performance performance = graphQLPerformanceService.getPerformanceById(id);
        return performance != null
                ? new ResponseEntity<>(performance, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
