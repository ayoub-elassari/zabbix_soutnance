package com.example.demo.controllers;

import com.example.demo.model.ApiItemModel;
import com.example.demo.service.ApiItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ApiItemService apiItemService;

    @PostMapping("/createItem")
    public String createItem(@RequestBody ApiItemModel apiItemModel){
        return apiItemService.createItem(apiItemModel);
    }

    @GetMapping("/getItem")
    public String getItem(){
        return "hi";
    }
}
