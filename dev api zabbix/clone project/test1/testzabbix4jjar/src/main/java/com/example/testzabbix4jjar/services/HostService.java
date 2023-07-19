package com.example.testzabbix4jjar.services;

import com.zabbix4j.ZabbixApi;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.ZabbixApiParamter;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HostService {

    @Autowired
    ZabbixApi zabbixApi;

    public HostGetResponse getHostById(Integer id) throws ZabbixApiException {
        Integer targetHostId = 10108;
        HostGetRequest request = new HostGetRequest();
        HostGetRequest.Params params = request.getParams();

        ArrayList<Integer> hostIds = new ArrayList<Integer>();
        hostIds.add(targetHostId);
        params.setHostids(hostIds);

        params.setSelectDiscoveryRule(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectGroups(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectItems(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectApplications(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectDiscoveries(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectGraphs(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectHostDiscovery(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectHttpTests(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectInterfaces(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectInventory(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectMacros(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectParentTemplates(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectScreens(ZabbixApiParamter.QUERY.extend.name());
        params.setSelectTriggers(ZabbixApiParamter.QUERY.extend.name());

        HostGetResponse response = zabbixApi.host().get(request);
        return response;
    }
}
