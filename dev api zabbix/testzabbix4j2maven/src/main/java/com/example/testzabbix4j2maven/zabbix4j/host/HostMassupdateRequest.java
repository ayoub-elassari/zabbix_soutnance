/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Suguru Yajima
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.testzabbix4j2maven.zabbix4j.host;

import com.example.testzabbix4j2maven.zabbix4j.hostgroup.HostgroupObject;
import com.example.testzabbix4j2maven.zabbix4j.hostinteface.HostInterfaceObject;
import com.example.testzabbix4j2maven.zabbix4j.template.TemplateObject;
import com.example.testzabbix4j2maven.zabbix4j.usermacro.Macro;
import com.example.testzabbix4j2maven.zabbix4j.utils.ZbxListUtils;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Request paramter for host.massupdate
 *
 * @author suguru yajima 2014
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HostMassupdateRequest extends ZabbixApiRequest {
    private Params params = new Params();

    public HostMassupdateRequest() {
        setMethod("host.massupdate");
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public class Params extends HostObject {
        private List<HostObject> hosts;
        private List<HostgroupObject> groups;
        private List<HostInterfaceObject> interfaces;
        private HostInventoryObject inventory;
        private Integer inventory_mode;
        private List<Macro> macros;
        private List<TemplateObject> templates;
        private List<TemplateObject> templates_clear;

        public void addHostId(Integer id) {
            HostObject obj = new HostObject();
            obj.setHostid(id);
            hosts = ZbxListUtils.add(hosts, obj);
        }

        public void addHostGroup(Integer id) {
            HostgroupObject obj = new HostgroupObject();
            obj.setGroupid(id);
            groups = ZbxListUtils.add(groups, obj);
        }

        public void addHostInterface(HostInterfaceObject obj) {
            interfaces = ZbxListUtils.add(interfaces, obj);
        }

        public void addMacro(Macro m) {
            macros = ZbxListUtils.add(macros, m);
        }

        public void addTemplate(Integer id) {
            TemplateObject obj = new TemplateObject();
            obj.setTemplateid(id);
            templates = ZbxListUtils.add(templates, obj);
        }

        public void addClearTemplate(Integer id) {
            TemplateObject obj = new TemplateObject();
            obj.setTemplateid(id);
            templates_clear = ZbxListUtils.add(templates_clear, obj);
        }
    }
}
