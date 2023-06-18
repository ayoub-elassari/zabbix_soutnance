package com.example.demo.service;

import com.example.demo.model.ApiVersionRequest;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiAuthenticationService {
    RestTemplate restTemplate;

    public ApiAuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String authenticate(ApiVersionRequest apiVersionRequest){
        String apiUrl = "http://192.168.23.133/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiVersionRequest.getJsonrpc());
        requestBody.put("method", apiVersionRequest.getMethod());
        requestBody.put("id", apiVersionRequest.getId());
        System.out.println(apiVersionRequest.getParams());
        JSONObject params = new JSONObject(apiVersionRequest.getParams());
        params.put("user", "Admin");
        params.put("password", "zabbix");
        System.out.println(params);
        requestBody.put("params", params);
        System.out.println(requestBody);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return  responseEntity.getBody();

    }
}
