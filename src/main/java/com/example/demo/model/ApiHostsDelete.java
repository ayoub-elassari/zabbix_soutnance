package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiHostsDelete {
    private String jsonrpc;
    private String method;
    private Integer id;
    private String auth;
    private List<String> params;
}
