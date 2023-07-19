package com.example.testzabbix4jjar.config;

import com.zabbix4j.ZabbixApi;
import com.zabbix4j.ZabbixApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZabbixConfig {

    @Value("${zabbix.server-url}")
    private String zabbixServerUrl;

//    @Value("${zabbix.username}")
//    private String zabbixUsername;

//    @Value("${zabbix.password}")
//    private String zabbixPassword;

    @Bean
    public ZabbixApi zabbixApi() throws ZabbixApiException {
        ZabbixApi zabbixApi = new ZabbixApi(zabbixServerUrl);
//        zabbixApi.login(zabbixUsername, zabbixPassword);
        return zabbixApi;
    }

}