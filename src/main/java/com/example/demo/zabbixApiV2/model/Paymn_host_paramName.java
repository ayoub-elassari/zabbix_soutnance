package com.example.demo.zabbixApiV2.model;

import java.util.List;

public class Paymn_host_paramName {
    private String name;
    private String default_value;

    private List<Paymn_host_complexe_value> paymn_host_complexe_value;

    public List<Paymn_host_complexe_value> getPaymn_host_complexe_value() {
        return paymn_host_complexe_value;
    }

    public void setPaymn_host_complexe_value(List<Paymn_host_complexe_value> paymn_host_complexe_value) {
        this.paymn_host_complexe_value = paymn_host_complexe_value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    @Override
    public String toString() {
        return "paymn_host_paramName{" +
                "name='" + name + '\'' +
                ", default_value='" + default_value + '\'' +
                '}';
    }
}
