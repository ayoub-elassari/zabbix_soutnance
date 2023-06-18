package com.example.demo.controllers;

import com.example.demo.model.ApiVersionRequest;
import com.example.demo.service.ApiVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiversion")
public class ApiVersionController {
    @Autowired
    ApiVersionService apiVersionService;
    @PostMapping()
    public String getApiVersion(@RequestBody ApiVersionRequest apiVersionRequest){
         return apiVersionService.getApiVersion(apiVersionRequest);
    }
}
