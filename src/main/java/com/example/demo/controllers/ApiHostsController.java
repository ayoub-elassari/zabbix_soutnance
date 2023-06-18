package com.example.demo.controllers;

import com.example.demo.model.*;
import com.example.demo.service.ApiHostsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiHostsController {
    @Autowired
    ApiHostsService apiHostsService;
    @PostMapping("/gethostsid")
    public String gethostsid(@RequestBody ApiHostModel apapiHostModel){
        return apiHostsService.getHostsId(apapiHostModel);
    }

    @PostMapping("/gethostsidname")
    public String getHostsIdName(@RequestBody ApiHostModel apiHostModel){
        return apiHostsService.getHostsIdNameInterface(apiHostModel);
    }

    @PostMapping("/gethostsbyname")
    public String getHostsByName(@RequestBody ApiHostModel apiHostModel){
        return apiHostsService.getHostsByName(apiHostModel);
    }

    @PostMapping("/getHostTemplates")
    public String getHostTemplates(@RequestBody ApiHostModel apiHostModel){
        return apiHostsService.getHostTemplates(apiHostModel);
    }

    @PostMapping("/getHostsIdNameWithoutInterface")
    public String getHostsIdNameWithoutInterface(@RequestBody ApiHostModel apiHostModel){
        return apiHostsService.getHostsIdNameWithoutInterface(apiHostModel);
    }

    @PostMapping("/getHostBySeverity")
    public String getHostBySeverity(@RequestBody ApiHostModel apiHostModel){
        return apiHostsService.getHostBySeverity(apiHostModel);
    }

    @DeleteMapping("/deleteHostsByID")
    public String deleteHostById(@RequestBody ApiHostDelete apiHostDelete){
        return apiHostsService.deleteHostById(apiHostDelete);
    }

    @GetMapping("/creaHostIpInterfaceTagsGroupsTemplatesMac")
    public String creaHostIpInterfaceTagsGroupsTemplatesMac(@RequestBody ApiHostCreateModel apiHostCreateModel){
        return apiHostsService.creaHostIpInterfaceTagsGroupsTemplatesMac(apiHostCreateModel);
//          return  apiHostCreateModel.toString();
    }

    @DeleteMapping("/deleteHosts")
    public String deleteHosts(@RequestBody ApiHostsDelete apiHostsDelete){
        return apiHostsService.deleteHosts(apiHostsDelete);
    }

    @PutMapping("/hostupdateStatus")
    public String hostupdateStatus(@RequestBody ApiHostUpdate apiHostUpdate){
        return apiHostsService.hostupdateStatus(apiHostUpdate);
    }

    @PostMapping("/hostUnlinktempaltes")
    public String hostUnlinktempaltes(@RequestBody ApiHostUpdate apiHostUpdate){
        return apiHostsService.hostUnlinktempaltes(apiHostUpdate);
    }

    @PostMapping("/hostLinkTemplate")
    public String hostLinkTemplate(@RequestBody ApiHostUpdate apiHostUpdate){
        return apiHostsService.hostLinkTemplate(apiHostUpdate);
    }
}
