package com.example.demo.zabbixApiV2.service;

import com.example.demo.zabbixApiV2.RequestIdGenerator;
import com.example.demo.zabbixApiV2.model.ZabixRequestBo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.PushBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class HostService {
    @Value("${url}")
    String apiUrl;
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<JsonNode> getHostByName(ZabixRequestBo zabixRequestBo, String auth){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
        requestBody.put("auth", auth);
        //change methode
        requestBody.put("method", "host.get");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        JSONObject filter = new JSONObject();
        JSONArray host = new JSONArray();
        host.put(zabixRequestBo.getHostName());
        filter.put("host", host);
        params.put("filter", filter);
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

    public ResponseEntity<JsonNode> getHosts(String auth){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
        requestBody.put("auth", auth);
        //change methode
        requestBody.put("method", "host.get");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        requestBody.put("params", params);
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

    public ResponseEntity<JsonNode> getHostsBySeverity(ZabixRequestBo zabixRequestBo,String auth){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
        requestBody.put("auth", auth);
        //change methode
        requestBody.put("method", "host.get");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        JSONArray severities = new JSONArray();
        severities.put(zabixRequestBo.getSeverities());
        params.put("severities", severities);
        requestBody.put("params", params);
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

    public ResponseEntity<JsonNode> createHost(ZabixRequestBo zabixRequestBo,String auth){
        //general structer
        String requestId = RequestIdGenerator.generateRequestId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("id", requestId);
        requestBody.put("auth", auth);
        //change methode
        requestBody.put("method", "host.create");
        //creating params object and adding attributes
        JSONObject params = new JSONObject();
        params.put("host", zabixRequestBo.getHostName());
        params.put("description", zabixRequestBo.getDescription());

        //traitement de l interface
        if(zabixRequestBo.getPaymn_interface()!=null){
            JSONArray interfaces= new JSONArray();
//            JSONObject interfaces = new JSONObject();
            for (int i=0; i<zabixRequestBo.getPaymn_interface().size(); i++){
                JSONObject interfaceobj = new JSONObject();
                if(i==0){
                    interfaceobj.put("main", 1);
                }else{
                    interfaceobj.put("main",0);
                }
                interfaceobj.put("ip", zabixRequestBo.getPaymn_interface().get(i).getIp());
                interfaceobj.put("port", zabixRequestBo.getPaymn_interface().get(i).getPort());
                if(zabixRequestBo.getPaymn_interface().get(i).getType().equals("agent")){
                    interfaceobj.put("type", 1);
                }else if (zabixRequestBo.getPaymn_interface().get(i).getType().equals("jmx")) {
                    interfaceobj.put("type", 4);
                }
                interfaceobj.put("dns", "");
                interfaceobj.put("useip", 1);
                interfaces.put(interfaceobj);
            }
            params.put("interfaces", interfaces);
        }

        //traitement des groupes
        JSONArray groups = new JSONArray();
        for(int i=0; i<zabixRequestBo.getPaymn_host_group().size(); i++){
            JSONObject group =new JSONObject();
            group.put("groupid", zabixRequestBo.getPaymn_host_group().get(i).getHost_groupe_server_id());
            groups.put(group);
        }
        params.put("groups", groups);

        //traitement param name
        for(int i=0; i<zabixRequestBo.getPaymn_host_paramName().size(); i++){
            if(zabixRequestBo.getPaymn_host_paramName().get(i).getDefault_value()!=null){
                params.put(zabixRequestBo.getPaymn_host_paramName().get(i).getName(), zabixRequestBo.
                        getPaymn_host_paramName().get(i).getDefault_value());
            }
//            else {
//                JSONArray complexe = new JSONArray();
//                JSONObject complexeObj = new JSONObject();
//                complexeObj.put(zabixRequestBo.getPaymn_host_paramName().get(i).getPaymn_host_complexe_value().)
//            }
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
//        return requestBody.toString();
    }
}

