package com.example.demo.zabbixApiV2.controller;

import com.example.demo.zabbixApiV2.model.ZabixRequestBo;
import com.example.demo.zabbixApiV2.service.AuthService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/authentication")
    public ResponseEntity<JsonNode> getToken(@RequestBody ZabixRequestBo zabixRequestBo){
        return authService.getToken(zabixRequestBo);
    }
}
