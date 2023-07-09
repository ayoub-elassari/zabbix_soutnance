package com.example.demo.zabbixApiV2.model;

public class Paymn_host_group {
    private String host_groupe_server_id;

    public String getHost_groupe_server_id() {
        return host_groupe_server_id;
    }

    public void setHost_groupe_server_id(String host_groupe_server_id) {
        this.host_groupe_server_id = host_groupe_server_id;
    }

    @Override
    public String toString() {
        return "Paymn_host_group{" +
                "host_groupe_server_id='" + host_groupe_server_id + '\'' +
                '}';
    }
}
