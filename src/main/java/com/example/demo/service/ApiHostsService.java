package com.example.demo.service;

import com.example.demo.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ApiHostsService {

    RestTemplate restTemplate;
    Map<String, String> myMap = new HashMap<>();

    public ApiHostsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getHostsId(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //HttpEntity<String> requestEntity = new HttpEntity<>(convertToJson(apiHostModel), headers);

        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        //changement commence ici
        JSONObject params = new JSONObject(apiHostModel.getParams());
        JSONArray output = new JSONArray();
        output.put("hostid");
        params.put("output", output);
        requestBody.put("params", params);
        //changement termine
        requestBody.put("auth", apiHostModel.getAuth());
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return  responseEntity.getBody();
    }

//    public String convertToJson(Object obj){
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.writeValueAsString(obj);
//        }catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }

    public String getHostsIdNameInterface(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        requestBody.put("auth", apiHostModel.getAuth());
        JSONArray output = new JSONArray();
        // change the next two lines
        output.put(apiHostModel.getParams().getOutput().get(0));
        output.put(apiHostModel.getParams().getOutput().get(1));
        //test code
        /*
        List<String> testOutput = apiHostModel.getParams().getOutput();
        System.out.println(testOutput.get(0));

         */
        //
        JSONArray selectedInterfaces = new JSONArray();
        selectedInterfaces.put(apiHostModel.getParams().getSelectInterfaces().get(0));
        selectedInterfaces.put(apiHostModel.getParams().getSelectInterfaces().get(1));
        JSONObject params = new JSONObject(apiHostModel.getParams());
        params.put("output", output);
        params.put("selectInterfaces", selectedInterfaces);
        requestBody.put("params", params);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return  responseEntity.getBody();
    }

    public String getHostsByName(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        //changement commence ici
        JSONObject params = new JSONObject(apiHostModel.getParams().getFilter());
        JSONObject filter = new JSONObject();
        JSONArray host = new JSONArray();
        // test boucle
        for(int i =0; i<apiHostModel.getParams().getFilter().getHost().size(); i++){
            System.out.println(apiHostModel.getParams().getFilter().getHost().get(i));
            host.put(apiHostModel.getParams().getFilter().getHost().get(i));
        }
        filter.put("host", host);
        params.put("filter", filter);
        /*
        //chamge this section
        JSONArray output = new JSONArray();
        output.put("filter");
        params.put("output", output);
        */
        requestBody.put("params", params);
        //changement termine
        requestBody.put("auth", apiHostModel.getAuth());
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return  responseEntity.getBody();
    }

    public String getHostTemplates(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        requestBody.put("auth", apiHostModel.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject(apiHostModel.getParams());
        JSONArray output = new JSONArray();
        for (int i=0; i<apiHostModel.getParams().getOutput().size(); i++){
            output.put(apiHostModel.getParams().getOutput().get(i));
        }
        JSONArray selectParentTemplates = new JSONArray();
        for (int i=0; i<apiHostModel.getParams().getSelectParentTemplates().size(); i++){
            selectParentTemplates.put(apiHostModel.getParams().getSelectParentTemplates().get(i));
        }
        JSONArray hostids = new JSONArray();
        for (int i=0; i<apiHostModel.getParams().getHostids().size(); i++){
            hostids.put(apiHostModel.getParams().getHostids().get(i));
        }
        params.put("output", output);
        params.put("selectParentTemplates", selectParentTemplates);
        params.put("hostids", hostids);
        //changement termine ici
        requestBody.put("params", params);
        System.out.println(requestBody.toString());
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        return  responseEntity.getBody();
    }

    public String getHostsIdNameWithoutInterface(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        requestBody.put("auth", apiHostModel.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject(apiHostModel.getParams());
        JSONArray output = new JSONArray();
        output.put(apiHostModel.getParams().getOutput().get(0));
        JSONArray tags = new JSONArray();
        params.put("output", output);
        params.put("tags", tags);
        requestBody.put("params", params);
        System.out.println(requestBody.toString());
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        return  responseEntity.getBody();
    }

    public String getHostBySeverity(ApiHostModel apiHostModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostModel.getJsonrpc());
        requestBody.put("method", apiHostModel.getMethod());
        requestBody.put("id", apiHostModel.getId());
        requestBody.put("auth", apiHostModel.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject(apiHostModel.getParams());
        JSONArray output = new JSONArray();
        for (int i=0; i<apiHostModel.getParams().getOutput().size(); i++){
            output.put(apiHostModel.getParams().getOutput().get(i));
        }
        JSONArray severities = new JSONArray();
        for (int i=0; i<apiHostModel.getParams().getSeverities().size(); i++){
            severities.put(apiHostModel.getParams().getSeverities().get(i));
        }
        params.put("output", output);
        params.put("severities", severities);
        requestBody.put("params", params);
        System.out.println(requestBody.toString());
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }

    public String deleteHostById(ApiHostDelete apiHostDelete){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostDelete.getJsonrpc());
        requestBody.put("method", apiHostDelete.getMethod());
        requestBody.put("id", apiHostDelete.getId());
        requestBody.put("auth", apiHostDelete.getAuth());
        //changement commence ici
        JSONArray params = new JSONArray();
        for(int i =0; i<apiHostDelete.getParams().size(); i++){
            params.put(apiHostDelete.getParams().get(i));
        }
        requestBody.put("params",params);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }

    public String creaHostIpInterfaceTagsGroupsTemplatesMac(ApiHostCreateModel apiHostCreateModel){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
//        String apiUrl = "http://192.168.1.142/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostCreateModel.getJsonrpc());
        requestBody.put("method", apiHostCreateModel.getMethod());
        requestBody.put("id", apiHostCreateModel.getId());
        requestBody.put("auth", apiHostCreateModel.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject();
        params.put("host", apiHostCreateModel.getParams().getHost());
        JSONArray interfaces= new JSONArray();
        for(int i=0; i<apiHostCreateModel.getParams().getInterfaces().size(); i++){
//            interfaces.put(apiHostCreateModel.getParams().getInterfaces().get(i));
            //changes
            JSONObject interfaceObj= new JSONObject();
            interfaceObj.put("type", apiHostCreateModel.getParams().getInterfaces().get(i).getType());
            interfaceObj.put("main", apiHostCreateModel.getParams().getInterfaces().get(i).getMain());
            interfaceObj.put("useip", apiHostCreateModel.getParams().getInterfaces().get(i).getUseip());
            interfaceObj.put("ip", apiHostCreateModel.getParams().getInterfaces().get(i).getIp());
            interfaceObj.put("dns", apiHostCreateModel.getParams().getInterfaces().get(i).getDns());
            interfaceObj.put("port", apiHostCreateModel.getParams().getInterfaces().get(i).getPort());
            interfaces.put(interfaceObj);
        }
        params.put("interfaces", interfaces);
        System.out.println(interfaces.toString());
        JSONArray groups = new JSONArray();
//        removing groups
        for(int i=0; i<apiHostCreateModel.getParams().getGroups().size(); i++){
            JSONObject group=new JSONObject();
            group.put("groupid", apiHostCreateModel.getParams().getGroups().get(i).getGroupid());
//            groups.put(apiHostCreateModel.getParams().getGroups().get(i));
            groups.put(group);
        }
        System.out.println(groups);
        params.put("groups", groups);
        System.out.println(params.toString());

        JSONArray tags =new JSONArray();
        //removing tags

//        for (int i=0; i<apiHostCreateModel.getParams().getTags().size(); i++){
////            tags.put(apiHostCreateModel.getParams().getTags().get(i));
//            JSONObject tag = new JSONObject();
//            tag.put("tag", apiHostCreateModel.getParams().getTags().get(i).getTag());
//            tag.put("value", apiHostCreateModel.getParams().getTags().get(i).getValue());
//            tags.put(tag);
//        }
        params.put("tags", tags);
        JSONArray templates=new JSONArray();
        //removing templates
        for(int i=0; i<apiHostCreateModel.getParams().getTemplates().size(); i++){
//            templates.put(apiHostCreateModel.getParams().getTemplates().get(i));
            JSONObject tempalte = new JSONObject();
            tempalte.put("templateid", apiHostCreateModel.getParams().getTemplates().get(i).getTemplateid());
            templates.put(tempalte);
        }
        params.put("templates", templates);
        JSONArray macros = new JSONArray();
        //removing macros
//        for (int i=0; i<apiHostCreateModel.getParams().getMacros().size(); i++){
////            macros.put(apiHostCreateModel.getParams().getMacros().get(i));
//            //changes
//            JSONObject macro = new JSONObject();
//            macro.put("macro", apiHostCreateModel.getParams().getMacros().get(i).getMacro());
//            macro.put("value", apiHostCreateModel.getParams().getMacros().get(i).getValue());
//            macro.put("description", apiHostCreateModel.getParams().getMacros().get(i).getDescription());
//            System.out.println(macro);
//            macros.put(macro);
//        }
        System.out.println(macros);
        params.put("macros", macros);
        JSONObject inventory = new JSONObject();
        //removing inventory
//        inventory.put("macaddress_a", apiHostCreateModel.getParams().getInventory().getMacaddress_a());
//        inventory.put("macaddress_b", apiHostCreateModel.getParams().getInventory().getMacaddress_b());
        params.put("inventory", inventory);

//        JSONObject inventory=new JSONObject();
//        inventory.put("inventory", apiHostCreateModel.getParams().getInventory());
        params.put("inventory_mode", apiHostCreateModel.getParams().getInventory_mode());

        requestBody.put("params",params);
//        return requestBody.toString();
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity);
        return  responseEntity.getBody();
//        System.out.println(responseEntity);
//        return params.toString();
    }

    public String deleteHosts(ApiHostsDelete apiHostsDelete){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostsDelete.getJsonrpc());
        requestBody.put("method", apiHostsDelete.getMethod());
        requestBody.put("id", apiHostsDelete.getId());
        requestBody.put("auth", apiHostsDelete.getAuth());
        //changement commence ici
        JSONArray params = new JSONArray();
        for(int i=0; i<apiHostsDelete.getParams().size(); i++){
            params.put(apiHostsDelete.getParams().get(i));
        }
        requestBody.put("params",params);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }

    public String hostupdateStatus(ApiHostUpdate apiHostUpdate){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostUpdate.getJsonrpc());
        requestBody.put("method", apiHostUpdate.getMethod());
        requestBody.put("id", apiHostUpdate.getId());
        requestBody.put("auth", apiHostUpdate.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject();
        params.put("hostid", apiHostUpdate.getParams().getHostid());
        params.put("status", apiHostUpdate.getParams().getStatus());
        requestBody.put("params",params);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }
    public String hostUnlinktempaltes(ApiHostUpdate apiHostUpdate){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostUpdate.getJsonrpc());
        requestBody.put("method", apiHostUpdate.getMethod());
        requestBody.put("id", apiHostUpdate.getId());
        requestBody.put("auth", apiHostUpdate.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject();
        params.put("hostid", apiHostUpdate.getParams().getHostid());
        JSONArray templates_clear = new JSONArray();
        for (int i=0; i<apiHostUpdate.getParams().getTemplates_clear().size(); i++){
            JSONObject templateID = new JSONObject();
            templateID.put("templateid", apiHostUpdate.getParams().getTemplates_clear().get(i).getTemplateid());
            templates_clear.put(templateID);
        }
        params.put("templates_clear", templates_clear);
        requestBody.put("params",params);
//        return requestBody.toString();
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
    }

    public String hostLinkTemplate(ApiHostUpdate apiHostUpdate){
        String apiUrl = "http://192.168.23.137/zabbix/api_jsonrpc.php";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject requestBody = new JSONObject();
        requestBody.put("jsonrpc", apiHostUpdate.getJsonrpc());
        requestBody.put("method", apiHostUpdate.getMethod());
        requestBody.put("id", apiHostUpdate.getId());
        requestBody.put("auth", apiHostUpdate.getAuth());
        //changement commence ici
        JSONObject params = new JSONObject();
        params.put("hostid", apiHostUpdate.getParams().getHostid());
        JSONArray templates = new JSONArray();
        for(int i=0; i<apiHostUpdate.getParams().getTemplates().size(); i++){
            JSONObject template = new JSONObject();
            template.put("templateid", apiHostUpdate.getParams().getTemplates().get(i).getTemplateid());
            templates.put(template);
        }
        params.put("templates", templates);


        requestBody.put("params",params);
//        return requestBody.toString();
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.toString());
        return  responseEntity.getBody();
//        return apiHostUpdate.toString();
    }
}
