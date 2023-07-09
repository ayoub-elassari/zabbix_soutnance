package com.example.demo.zabbixApiV2.controller;

import com.example.demo.zabbixApiV2.model.ZabixRequestBo;
import com.example.demo.zabbixApiV2.service.HostService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HostController {
    @Autowired
    HostService hostService;
    @PostMapping("/host/getHostByname")
    public ResponseEntity<JsonNode> getHostByName(@RequestBody ZabixRequestBo zabixRequestBo, @RequestHeader("auth") String auth){
        return hostService.getHostByName(zabixRequestBo, auth);
    }

    @GetMapping("/host/getHosts")
    public ResponseEntity<JsonNode> getHosts(@RequestHeader("auth") String auth){
        return hostService.getHosts(auth);
    }

    @GetMapping("/host/getHostsBySeverity")
    public ResponseEntity<JsonNode> getHostsBySeverity(@RequestBody ZabixRequestBo zabixRequestBo, @RequestHeader("auth") String auth){
        return hostService.getHostsBySeverity(zabixRequestBo, auth);
    }

    @PostMapping("/host/createHost")
    public ResponseEntity<JsonNode> createHost(@RequestBody ZabixRequestBo zabixRequestBo ,@RequestHeader("auth") String auth){
        return hostService.createHost(zabixRequestBo, auth);
    }

    @DeleteMapping("/host/deleteHost")
    public String deleteHost(@RequestBody ZabixRequestBo zabixRequestBo ,@RequestHeader("auth") String auth){
        System.out.println(auth);
        System.out.println(zabixRequestBo.toString());
        System.out.println(zabixRequestBo.getHost_server_id());
        return "delete test";
    }
}
