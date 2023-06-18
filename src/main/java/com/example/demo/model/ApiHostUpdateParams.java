package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiHostUpdateParams {
    private String hostid;
    private Integer status;
    private List<Templates> templates;
    private List<Templates> templates_clear;
}
