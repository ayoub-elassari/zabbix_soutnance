package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiParamsHostCreateModel {
    //added
    private String host;
    private List<Interface> interfaces;
    private List<Groups> groups;
    private List<Tag> tags;
    private List<Templates> templates;
    private List<Macro> macros;
    private Integer inventory_mode;
    private Inventory inventory;
}

