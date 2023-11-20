//package com.example.rest.controller.Performance;
//
//import com.example.rest.model.Performance;
//import com.example.rest.repository.PerformanceRepository;
//import com.example.rest.service.PerformanceService;
//import com.example.rest.service.performanceDTO.InputPerformanceDTO;
//import com.example.rest.service.performanceDTO.PerformanceDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.management.remote.rmi.RMIServer;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//@RequestMapping(value = "/performances")
//public class PerformanceController {
//    private final PerformanceService performanceService;
//    private final PerformanceRepository repo;
//
//    @Autowired
//    public PerformanceController(PerformanceService performanceService, PerformanceRepository performanceRepository) {
//        this.performanceService = performanceService;
//        this.repo = performanceRepository;
//    }
//
//    @PostMapping(value = "/create")
//    @ResponseBody
//    public ResponseEntity<?> createPerformance(@RequestBody InputPerformanceDTO inputPerformanceDTO) {
//        performanceService.createPerformance(inputPerformanceDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/showAll")
//    public ResponseEntity<List<Performance>> getAllPerformances() {
//        final List<Performance> performances = performanceService.getAllPerformances();
//        return performances != null && !performances.isEmpty()
//                ? new ResponseEntity<>(performances, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PatchMapping
//    public ResponseEntity<?> updatePerformance(@RequestBody PerformanceDTO performanceDTO) {
//        final boolean updated = performanceService.updatePerformanceDate(performanceDTO);
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deletePerformanceById(@RequestBody PerformanceDTO performanceDTO) {
//        final boolean deleted = performanceService.deletePerformanceById(performanceDTO);
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
////    @PostMapping(value = "/theatre/{performanceId}/{theatreId}")
////    public ResponseEntity<?> performanceToTheatre(@PathVariable(name = "performanceId") int performanceId, @PathVariable
////            (name = "theatreId") String theatreId) {
////        performanceService.performanceToTheatre(performanceId, theatreId);
////        return new ResponseEntity<>(HttpStatus.CREATED);
////    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getPerformanceById(@PathVariable(name = "id") String id) {
//        Performance performance = performanceService.getPerformanceById(id);
////        Link link = linkTo(methodOn(PerformanceController.class).getPerformanceById(id)).withSelfRel();
////        performance.add(link);
//        return performance != null
//                ? new ResponseEntity<>(performance, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/hal")
//    public ResponseEntity<Map<String, Object>> getAllPerformancesWithHAL(@RequestParam(defaultValue = "0") int index, @RequestParam(defaultValue = "5") int count) {
//        return ResponseEntity.ok(performanceService.getAllPerformancesHal(index, count));
//    }
//
//    @MutationMapping("/graphiql")
//    public ResponseEntity<?> createPostWithGraphQl(@Argument String name, @Argument Date date) {
//        performanceService.createPerformanceGraphQl(name, date);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @QueryMapping("/graphiql")
//    public ResponseEntity<?> getAllPerformancesGraphQL() {
//        final List<Performance> performances = performanceService.getAllPerformancesGraphQl();
//        return performances != null && !performances.isEmpty()
//                ? new ResponseEntity<>(performances, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @QueryMapping("/graphiql/id")
//    public ResponseEntity<?> getPerformanceByIdGraphQL(@Argument String id) {
//        Performance performance = performanceService.getPerformanceGraphQL(id);
//        return performance != null
//                ? new ResponseEntity<>(performance, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//}

