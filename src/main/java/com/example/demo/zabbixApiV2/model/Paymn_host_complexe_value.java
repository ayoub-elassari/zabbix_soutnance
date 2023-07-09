package com.example.demo.zabbixApiV2.model;

public class Paymn_host_complexe_value {
    private String host_key;
    private String host_value;

    public String getHost_key() {
        return host_key;
    }

    public void setHost_key(String host_key) {
        this.host_key = host_key;
    }

    public String getHost_value() {
        return host_value;
    }

    public void setHost_value(String host_value) {
        this.host_value = host_value;
    }

    @Override
    public String toString() {
        return "Paymn_host_complexe_value{" +
                "host_key='" + host_key + '\'' +
                ", host_value='" + host_value + '\'' +
                '}';
    }
}
