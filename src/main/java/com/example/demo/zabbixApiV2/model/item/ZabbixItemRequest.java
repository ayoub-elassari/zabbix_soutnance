package com.example.demo.zabbixApiV2.model.item;

import lombok.Data;

import java.util.List;

@Data
public class ZabbixItemRequest {
    private String name;
    private String description;
    private String key;
    private String returnType;
    private int host_server_id;
    private int interface_server_id;
    private List<Paymn_item_paramName> paymn_item_paramName;
}
