package com.example.rest.service;

import com.example.rest.HAL.HAL;
import com.example.rest.model.Performance;
import com.example.rest.repository.PerformanceRepository;
import com.example.rest.service.performanceDTO.InputPerformanceDTO;
import com.example.rest.service.performanceDTO.PerformanceDTO;
import com.example.rest.validator.ValidationUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PerformanceServiceRealization implements PerformanceService {
    private final PerformanceRepository performanceRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PerformanceServiceRealization(PerformanceRepository performanceRepository,
                                         ValidationUtil validationUtil,
                                         ModelMapper modelMapper) {
        this.performanceRepository = performanceRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createPerformance(InputPerformanceDTO performanceDTO) {
        InputPerformanceDTO inputPerformanceDTO = new InputPerformanceDTO();
        inputPerformanceDTO.setName(performanceDTO.getName());
        inputPerformanceDTO.setDate(performanceDTO.getDate());

        if (!validationUtil.isValid(inputPerformanceDTO)) {
            this.validationUtil.violations(performanceDTO).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
        } else {
            try {
                this.performanceRepository.saveAndFlush(this.modelMapper.map(inputPerformanceDTO, Performance.class));
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
    }

    @Override
    public List<Performance> getAllPerformances() {
        return this.performanceRepository.findAll();
    }

    @Override
    public Performance findByName(String name) {
        return this.performanceRepository.findByName(name);
    }

    @Override
    public Performance getPerformanceById(String id) {
        return this.performanceRepository.findPerformanceById(id);
    }

    @Override
    public List<Performance> getPerformanceByDate(Date date) {
        return this.performanceRepository.findByDate(date);
    }

    @Override
    public boolean updatePerformanceDate(PerformanceDTO performanceDTO) {
        if (!validationUtil.isValid(performanceDTO)) {
            this.validationUtil.violations(performanceDTO).stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
        }
            Performance performance=performanceRepository.findPerformanceById(performanceDTO.getId());
            performance.setDate(performanceDTO.getDate());
            this.performanceRepository.saveAndFlush(performance);
            return true;

    }
    @Override
    public boolean deletePerformanceById(PerformanceDTO performanceDTO) {
        this.performanceRepository.deleteById(performanceDTO.getId());
        return true;
    }

    @Override
    public Map<String, Object> getAllPerformancesHal(int index, int count) {
        Page<PerformanceDTO> performancePage = getAllPerformances(index, count);
        String baseUrl = "/performances/hal";
        int pageNumber = performancePage.getNumber();
        int pageSize = performancePage.getSize();
        int total = performancePage.getTotalPages();

        List<Map<String, Object>> embeddedPerformances = performancePage.getContent().stream()
                .map(this::createPerformanceResource)
                .toList();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("_embedded", Collections.singletonMap("performances", embeddedPerformances));
        response.put("_links", HAL.paginateAsDictionary(baseUrl, pageNumber, pageSize, total));

        return response;
    }

    private Map<String, Object> createPerformanceResource(PerformanceDTO performanceDTO) {
        Map<String, Object> racerResource = new LinkedHashMap<>();
        racerResource.put("_links", createPerformanceLinks(performanceDTO));
        racerResource.put("id", performanceDTO.getId());
        racerResource.put("name", performanceDTO.getName());
        racerResource.put("date", performanceDTO.getDate());

        return racerResource;
    }

    private Map<String, Object> createPerformanceLinks(PerformanceDTO performanceDTO) {
        String baseUrl = "/performances/hal";
        String performanceID = performanceDTO.getId();
        Map<String, Object> links = new LinkedHashMap<>();
        links.put("self", Collections.singletonMap("href", baseUrl + "/" + performanceID));
//        links.put("car", Collections.singletonMap("href", "api/cars/" + racerDto.getCarId()));
//        links.put("team", Collections.singletonMap("href", "api/teams/" + racerDto.getTeamId()));
        return links;
    }

    public Page<PerformanceDTO> getAllPerformances(int index, int count) {
        PageRequest pageable = PageRequest.of(index, count);
        Page<Performance> performancePage = performanceRepository.findAll(pageable);
        List<PerformanceDTO> performanceDTOS = performancePage.getContent().stream().map((element) -> modelMapper.map(element, PerformanceDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(performanceDTOS, pageable, performancePage.getTotalElements());
    }









}

