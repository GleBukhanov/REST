package com.example.rest.controller.Performance;

import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.PerformanceService;
import com.example.rest.service.performanceDTO.InputPerformanceDTO;
import com.example.rest.service.performanceDTO.PerformanceDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceRepository repo;
    private final RabbitTemplate rabbitTemplate;

    public PerformanceController(PerformanceService performanceService, PerformanceRepository performanceRepository, RabbitTemplate rabbitTemplate) {
        this.performanceService = performanceService;
        this.repo = performanceRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<?> createPerformance(@RequestBody InputPerformanceDTO inputPerformanceDTO) {
        performanceService.createPerformance(inputPerformanceDTO);

        rabbitTemplate.convertAndSend("queueName", inputPerformanceDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping(value = "/showAll")
//    public ResponseEntity<List<Performance>> getAllPerformances() {
//        final List<Performance> performances = performanceService.getAllPerformances();
//        return performances != null && !performances.isEmpty()
//                ? new ResponseEntity<>(performances, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PatchMapping
//    public ResponseEntity<?> updatePerformance(@RequestBody PerformanceDTO performanceDTO) {
//        final boolean updated = performanceService.updatePerformanceDate(performanceDTO);
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deletePerformanceById(@RequestBody PerformanceDTO performanceDTO) {
//        final boolean deleted = performanceService.deletePerformanceById(performanceDTO);
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

//    @PostMapping(value = "/theatre/{performanceId}/{theatreId}")
//    public ResponseEntity<?> performanceToTheatre(@PathVariable(name = "performanceId") int performanceId, @PathVariable
//            (name = "theatreId") String theatreId) {
//        performanceService.performanceToTheatre(performanceId, theatreId);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getPerformanceById(@PathVariable(name = "id") String id) {
//        Performance performance = performanceService.getPerformanceById(id);
////        Link link = linkTo(methodOn(PerformanceController.class).getPerformanceById(id)).withSelfRel();
////        performance.add(link);
//        return performance != null
//                ? new ResponseEntity<>(performance, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping("/hal")
//    public ResponseEntity<Map<String, Object>> getAllPerformancesWithHAL(@RequestParam(defaultValue = "0") int index, @RequestParam(defaultValue = "5") int count) {
//        return ResponseEntity.ok(performanceService.getAllPerformancesHal(index, count));
//    }

}