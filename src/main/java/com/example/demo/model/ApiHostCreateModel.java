package com.example.demo.model;

import lombok.Data;

@Data
public class ApiHostCreateModel {
    private String jsonrpc;
    private String method;
    private ApiParamsHostCreateModel params;
    private String auth;
    private int id;
}
