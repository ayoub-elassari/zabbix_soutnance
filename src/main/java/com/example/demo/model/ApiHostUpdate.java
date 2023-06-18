package com.example.demo.model;

import lombok.Data;

@Data
public class ApiHostUpdate {
    private String jsonrpc;
    private String method;
    private Integer id;
    private String auth;
    private ApiHostUpdateParams params;
}
