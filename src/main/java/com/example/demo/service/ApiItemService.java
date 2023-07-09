package com.example.demo.service;

import com.example.demo.model.ApiItemModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiItemService {

    RestTemplate restTemplate;

    public ApiItemService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createItem(ApiItemModel apiItemModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiItemModel.getJsonrpc());
        requestBody.put("method", apiItemModel.getMethod());
        requestBody.put("id", apiItemModel.getId());
        requestBody.put("auth", apiItemModel.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject();
        params.put("name", apiItemModel.getParams().getName());
        params.put("key_", apiItemModel.getParams().getKey_());
        params.put("hostid", apiItemModel.getParams().getHostid());
        params.put("type", apiItemModel.getParams().getType());
        params.put("value_type", apiItemModel.getParams().getValue_type());
        params.put("interfaceid", apiItemModel.getParams().getInterfaceid());
        params.put("delay", apiItemModel.getParams().getDelay());
        JSONArray tags = new JSONArray();
        for (int i=0; i<apiItemModel.getParams().getTags().size(); i++) {
            JSONObject tag = new JSONObject();
            tag.put("tag", apiItemModel.getParams().getTags().get(i).getTag());
            tag.put("value", apiItemModel.getParams().getTags().get(i).getValue());
            tags.put(tag);
        }
        params.put("tags", tags);
//        return params.toString();
        requestBody.put("params",params);
//        return requestBody.toString();
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }
}
