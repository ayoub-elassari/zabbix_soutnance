package com.example.demo.service;

import com.example.demo.model.ApiVersionRequest;
import com.example.demo.model.ApiVersionResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiVersionService {
    RestTemplate restTemplate;

    @Autowired
    public ApiVersionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getApiVersion(ApiVersionRequest apiVersionRequest){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiVersionRequest.getJsonrpc());
        requestBody.put("method", apiVersionRequest.getMethod());
        requestBody.put("id", apiVersionRequest.getId());
        JSONObject params = new JSONObject(apiVersionRequest.getParams());
        requestBody.put("params", params);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return  responseEntity.getBody();
    }
}
