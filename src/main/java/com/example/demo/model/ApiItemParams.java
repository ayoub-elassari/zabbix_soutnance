package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiItemParams {
    private String name;
    private String key_;
    private String hostid;
    private Integer type;
    private Integer value_type;
    private Integer interfaceid;
    private List<Tag> tags;
    private String delay;
}
