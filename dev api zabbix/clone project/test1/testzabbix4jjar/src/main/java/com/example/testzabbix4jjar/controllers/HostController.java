package com.example.testzabbix4jjar.controllers;

import com.example.testzabbix4jjar.services.HostService;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HostController {

    @Autowired
    HostService hostService;

    @PostMapping("/getHostByid")
    public HostGetResponse getHostById(@RequestBody Integer id) throws ZabbixApiException {
        System.out.println("hello");
        return hostService.getHostById(id);
    }
}
