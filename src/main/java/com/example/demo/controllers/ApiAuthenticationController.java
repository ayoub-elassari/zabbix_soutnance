package com.example.demo.controllers;


import com.example.demo.model.ApiVersionRequest;
import com.example.demo.service.ApiAuthenticationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Controller;

@RestController
public class ApiAuthenticationController {

    @Autowired
    ApiAuthenticationService apiAuthenticationService;



    @PostMapping(value = "/auth")
//    @ResponseBody
    public ResponseEntity<String> getToken(@RequestBody ApiVersionRequest apiVersionRequest) {
        return apiAuthenticationService.authenticate(apiVersionRequest);


//        String apiUrl = "http://192.168.23.133/zabbix/api_jsonrpc.php";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("jsonrpc", "2.0");
//        requestBody.put("method", "user.login");
//
//        JSONObject params = new JSONObject();
//        params.put("user", "Admin");
//        params.put("password", "zabbix");
//
//        requestBody.put("params", params);
//        requestBody.put("id", 1);
//
//        // Create the request entity with the headers and body
//        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
//
//        // Make the API call with the POST method
//        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
//        return responseEntity.getBody();
    }
}

