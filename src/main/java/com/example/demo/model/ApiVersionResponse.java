package com.example.demo.model;

import lombok.Data;

@Data
public class ApiVersionResponse {
    private String jsonrpc;
    private String result;
    private int id;
}
