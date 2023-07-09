package com.example.demo.zabbixApiV2.controller;

import com.example.demo.zabbixApiV2.model.item.ZabbixItemRequest;
import com.example.demo.zabbixApiV2.service.ItemService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestItemController {

    @Autowired
    ItemService itemService;
    @PostMapping("/createItemv2")
    public ResponseEntity<JsonNode> createItemv2(@RequestBody ZabbixItemRequest zabbixItemRequest, @RequestHeader("auth") String auth){
        return itemService.createItem(zabbixItemRequest, auth);
    }
}
