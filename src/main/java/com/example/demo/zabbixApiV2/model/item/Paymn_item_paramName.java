package com.example.demo.zabbixApiV2.model.item;

import lombok.Data;

import java.util.List;

@Data
public class Paymn_item_paramName {
    private String name;
    private String default_value;
    private List<Paymn_ietm_complexe_value> paymn_ietm_complexe_value;
}
