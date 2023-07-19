package com.example.testzabbix4j2maven.controllers;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final ZabbixApi zabbixApi;

    @Autowired
    public AuthenticationController(ZabbixApi zabbixApi) {
        this.zabbixApi = zabbixApi;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        try {
            zabbixApi.login(username, password);
            return "Authentication successful";
        } catch (Exception e) {
            return "Authentication failed";
        }
    }

//    @PostMapping("/logout")
//    public String logout() {
//        try {
//            zabbixApi.logout();
//            return "Logout successful";
//        } catch (Exception e) {
//            return "Logout failed";
//        }
//    }

}
