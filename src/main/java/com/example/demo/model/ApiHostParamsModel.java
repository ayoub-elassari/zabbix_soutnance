package com.example.demo.model;

import lombok.Data;

import java.security.PrivateKey;
import java.util.List;

@Data
public class ApiHostParamsModel {
    private List<String> output;
    private List<String> selectInterfaces;
    private FilterZabbix filter;
    private List<String> selectParentTemplates;
    private List<String> hostids;
    private List<String> tags;
    private List<Integer> severities;
}
