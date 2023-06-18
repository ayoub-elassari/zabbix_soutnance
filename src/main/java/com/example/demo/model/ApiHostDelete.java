package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiHostDelete {
    private String jsonrpc;
    private String method;
    private List<String> params;
    private String auth;
    private int id;
}
