package com.example.demo.zabbixApiV2.service;

import com.example.demo.zabbixApiV2.RequestIdGenerator;
import com.example.demo.zabbixApiV2.model.ZabixRequestBo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class AuthService {
    @Value("${url}")
    String apiUrl;
    @Autowired
    RestTemplate restTemplate;
    public ResponseEntity<JsonNode> getToken (ZabixRequestBo zabixRequestBo){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
        //change methode
        requestBody.put("method", "user.login");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        params.put("user", zabixRequestBo.getUsername());
        params.put("password", zabixRequestBo.getPassword());
        requestBody.put("params", params);
        System.out.println(requestBody.toString());
        //end params object
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse;
        try {
            jsonResponse = objectMapper.readTree(responseEntity.getBody());
        } catch (IOException e) {
            // Handle any JSON parsing errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
