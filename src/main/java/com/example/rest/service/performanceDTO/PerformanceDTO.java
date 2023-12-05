package com.example.rest.service.performanceDTO;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class PerformanceDTO extends InputPerformanceDTO {
    private String id;
    public PerformanceDTO(){}

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id=id;
    }


}
