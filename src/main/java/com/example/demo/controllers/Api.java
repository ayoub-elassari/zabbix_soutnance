package com.example.demo.controllers;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class Api {

    private final RestTemplate restTemplate;

    @Autowired
    public Api(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/auth")
    @ResponseBody
    public String getToken() {
        String apiUrl = "http://192.168.23.132/zabbix/api_jsonrpc.php";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", "user.login");

        JSONObject params = new JSONObject();
        params.put("user", "Admin");
        params.put("password", "zabbix");

        requestBody.put("params", params);
        requestBody.put("id", 1);

        // Create the request entity with the headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);

        // Make the API call with the POST method
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }
}

