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

package com.example.testzabbix4j2maven.zabbix4j.template;

import com.example.testzabbix4j2maven.zabbix4j.hostgroup.HostgroupObject;
import com.example.testzabbix4j2maven.zabbix4j.usermacro.Macro;
import com.example.testzabbix4j2maven.zabbix4j.utils.ZbxListUtils;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;
import com.example.testzabbix4j2maven.zabbix4j.host.HostObject;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class TemplateUpdateRequest extends ZabbixApiRequest {
    private Params params = new Params();

    public TemplateUpdateRequest() {
        setMethod("template.update");
    }

    /**
     * Gets params.
     *
     * @return Value of params.
     */
    public Params getParams() {
        return params;
    }

    /**
     * Sets new params.
     *
     * @param params New value of params.
     */
    public void setParams(Params params) {
        this.params = params;
    }

    public class Params extends TemplateObject {

        private List<HostgroupObject> groups;
        private List<HostObject> hosts;
        private List<Macro> macros;
        private List<TemplateObject> templates;
        private List<TemplateObject> templates_clear;

        public void addGroupId(Integer id) {
            HostgroupObject obj = new HostgroupObject();
            obj.setGroupid(id);
            groups = ZbxListUtils.add(groups, obj);
        }

        public void addHostId(Integer id) {
            HostObject obj = new HostObject();
            obj.setHostid(id);
            hosts = ZbxListUtils.add(hosts, obj);
        }

        public void addMacro(String macro, String value) {
            Macro obj = new Macro();
            obj.setMacro(macro);
            obj.setValue(value);
            macros = ZbxListUtils.add(macros, obj);
        }

        public void addTemplateId(Integer id) {
            TemplateObject obj = new TemplateObject();
            obj.setTemplateid(id);
            templates = ZbxListUtils.add(templates, obj);
        }

        public void addClearTemplate(Integer id) {
            TemplateObject obj = new TemplateObject();
            obj.setTemplateid(id);
            templates_clear = ZbxListUtils.add(templates_clear, obj);
        }

        /**
         * Gets templates_clear.
         *
         * @return Value of templates_clear.
         */
        public List<TemplateObject> getTemplates_clear() {
            return templates_clear;
        }

        /**
         * Sets new templates_clear.
         *
         * @param templates_clear New value of templates_clear.
         */
        public void setTemplates_clear(List<TemplateObject> templates_clear) {
            this.templates_clear = templates_clear;
        }

        /**
         * Gets templates.
         *
         * @return Value of templates.
         */
        public List<TemplateObject> getTemplates() {
            return templates;
        }

        /**
         * Sets new templates.
         *
         * @param templates New value of templates.
         */
        public void setTemplates(List<TemplateObject> templates) {
            this.templates = templates;
        }

        /**
         * Gets hosts.
         *
         * @return Value of hosts.
         */
        public List<HostObject> getHosts() {
            return hosts;
        }

        /**
         * Sets new hosts.
         *
         * @param hosts New value of hosts.
         */
        public void setHosts(List<HostObject> hosts) {
            this.hosts = hosts;
        }

        /**
         * Gets groups.
         *
         * @return Value of groups.
         */
        public List<HostgroupObject> getGroups() {
            return groups;
        }

        /**
         * Sets new groups.
         *
         * @param groups New value of groups.
         */
        public void setGroups(List<HostgroupObject> groups) {
            this.groups = groups;
        }

        /**
         * Gets macros.
         *
         * @return Value of macros.
         */
        public List<Macro> getMacros() {
            return macros;
        }

        /**
         * Sets new macros.
         *
         * @param macros New value of macros.
         */
        public void setMacros(List<Macro> macros) {
            this.macros = macros;
        }
    }
}