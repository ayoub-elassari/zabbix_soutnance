package com.example.demo.zabbixApiV2.model;

public class Paymn_interface {
    private String ip;
    private String port;
    private String type;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Paymn_interface{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
