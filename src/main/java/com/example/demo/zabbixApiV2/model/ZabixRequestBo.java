package com.example.demo.zabbixApiV2.model;

import java.io.Serializable;
import java.util.List;

public class ZabixRequestBo implements Serializable {
    private String username;
    private String password;
    private String hostName;
    private String severities;
    private String description;

    private String host_server_id;

    private List<Paymn_interface> paymn_interface;

    private List<Paymn_host_group> paymn_host_group;

    private List<Paymn_host_paramName> paymn_host_paramName;

    public String getHost_server_id() {
        return host_server_id;
    }

    public void setHost_server_id(String host_server_id) {
        this.host_server_id = host_server_id;
    }

    public List<Paymn_host_paramName> getPaymn_host_paramName() {
        return paymn_host_paramName;
    }

    public void setPaymn_host_paramName(List<Paymn_host_paramName> paymn_host_paramName) {
        this.paymn_host_paramName = paymn_host_paramName;
    }

    public void setPaymn_interface(List<Paymn_interface> paymn_interface) {
        this.paymn_interface = paymn_interface;
    }

    public List<Paymn_host_group> getPaymn_host_group() {
        return paymn_host_group;
    }

    public void setPaymn_host_group(List<Paymn_host_group> paymn_host_group) {
        this.paymn_host_group = paymn_host_group;
    }

    public List<Paymn_interface> getPaymn_interface() {
        return paymn_interface;
    }

    public void setPaymn_interfaces(List<Paymn_interface> paymn_interfaces) {
        this.paymn_interface = paymn_interfaces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverities() {
        return severities;
    }

    public void setSeverities(String severities) {
        this.severities = severities;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ZabixRequestBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hostName='" + hostName + '\'' +
                ", severities='" + severities + '\'' +
                ", description='" + description + '\'' +
                ", paymn_interface=" + paymn_interface +
                ", paymn_host_group=" + paymn_host_group +
                ", paymn_host_paramName=" + paymn_host_paramName +
                '}';
    }
}
