package com.example.rest.service.performanceDTO;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class InputPerformanceDTO {
    private String name;
    private Date date;
    public InputPerformanceDTO(){}
    @NotNull
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }

}
