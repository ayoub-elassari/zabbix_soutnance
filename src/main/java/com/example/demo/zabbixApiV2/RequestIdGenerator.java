package com.example.demo.zabbixApiV2;

import java.util.UUID;

public class RequestIdGenerator {
    public static String generateRequestId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
