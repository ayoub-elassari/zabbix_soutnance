package com.example.demo.zabbixApiV2.service;

import com.example.demo.zabbixApiV2.RequestIdGenerator;
import com.example.demo.zabbixApiV2.model.item.ZabbixItemRequest;
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
public class ItemService {

    @Value("${url}")
    String apiUrl;
    @Autowired
    RestTemplate restTemplate;


    public ResponseEntity<JsonNode> createItem(ZabbixItemRequest zabbixItemRequest, String auth){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
//        requestBody.put("description", zabbixItemRequest.getDescription());
        requestBody.put("auth", auth);
        //change methode
        requestBody.put("method", "item.create");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        params.put("name", zabbixItemRequest.getName());
        params.put("description", zabbixItemRequest.getDescription());
        params.put("key_", zabbixItemRequest.getKey());
        params.put("hostid", zabbixItemRequest.getHost_server_id());
        params.put("value_type", zabbixItemRequest.getReturnType());
        params.put("interfaceid", zabbixItemRequest.getInterface_server_id());
        //traitement param name
        for(int i=0; i<zabbixItemRequest.getPaymn_item_paramName().size(); i++){
            if(zabbixItemRequest.getPaymn_item_paramName().get(i).getDefault_value()!=null){
                params.put(zabbixItemRequest.getPaymn_item_paramName().get(i).getName(), zabbixItemRequest.
                        getPaymn_item_paramName().get(i).getDefault_value());
            }
        }


        requestBody.put("params", params);
        System.out.println(requestBody);
        //end params object
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

//        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse;
        try {
            jsonResponse = objectMapper.readTree(responseEntity.getBody());
        } catch (IOException e) {
            // Handle any JSON parsing errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        //return "service";
    }
}
