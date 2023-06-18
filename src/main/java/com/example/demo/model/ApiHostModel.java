package com.example.demo.model;

import lombok.Data;
@Data
public class ApiHostModel {
        private String jsonrpc;
        private String method;
        private ApiHostParamsModel params;
        private String auth;
        private int id;
}
