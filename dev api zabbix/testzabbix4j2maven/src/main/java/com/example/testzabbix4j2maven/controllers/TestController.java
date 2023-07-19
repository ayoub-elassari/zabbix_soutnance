package com.example.testzabbix4j2maven.controllers;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApi;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/heho")
    public static void heho() throws ZabbixApiException {
        String user = "Admin";
        String password = "zabbix";

// login to zabbix
        ZabbixApi zabbixApi = new ZabbixApi("http://192.168.23.133/zabbix/api_jsonrpc.php");
        zabbixApi.login(user, password);
        System.out.println("hello");
    }
}
