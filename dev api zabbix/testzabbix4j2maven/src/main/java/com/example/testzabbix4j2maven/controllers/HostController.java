package com.example.testzabbix4j2maven.controllers;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApi;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiException;
import com.example.testzabbix4j2maven.zabbix4j.host.Host;
import com.example.testzabbix4j2maven.zabbix4j.host.HostCreateRequest;
import com.example.testzabbix4j2maven.zabbix4j.host.HostCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostController {

    private final ZabbixApi zabbixApi;

    @Autowired
    public HostController(ZabbixApi zabbixApi) {
        this.zabbixApi = zabbixApi;
    }
    @PostMapping
    public HostCreateResponse createHost(@RequestBody HostCreateRequest hostCreateRequest) throws ZabbixApiException {
        return zabbixApi.host().create(hostCreateRequest);
//
//    @GetMapping
//    public List<Host> getAllHosts() {
//        return zabbixApi.host().getAllHosts();
//    }
//
//    @GetMapping("/{hostId}")
//    public Host getHostById(@PathVariable("hostId") String hostId) {
//        return zabbixApi.host().getById(hostId);
//    }
//
    }
//
//    @PutMapping("/{hostId}")
//    public Host updateHost(@PathVariable("hostId") String hostId, @RequestBody Host host) {
//        host.setHostId(hostId);
//        return zabbixApi.host().update(host);
//    }
//
//    @DeleteMapping("/{hostId}")
//    public void deleteHost(@PathVariable("hostId") String hostId) {
//        zabbixApi.host().deleteById(hostId);
//    }
}
