package com.example.testzabbix4j2maven;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApi;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiException;

public class Main {
    public static void main(String args[]) throws ZabbixApiException {
        String user = "Admin";
        String password = "zabbix";

// login to zabbix
        ZabbixApi zabbixApi = new ZabbixApi("http://192.168.23.133/zabbix/api_jsonrpc.php");
        zabbixApi.login(user, password);
        System.out.println("hello");
    }
}
