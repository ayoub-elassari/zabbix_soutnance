package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiVersionRequest {
    private String jsonrpc;
    private String method;
    private Object params;
    private String auth;
    private int id;
}
