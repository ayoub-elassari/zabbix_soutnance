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

package com.example.testzabbix4j2maven.zabbix4j.maintenance;

import com.example.testzabbix4j2maven.zabbix4j.GetRequestCommonParams;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;
import com.example.testzabbix4j2maven.zabbix4j.utils.ZbxListUtils;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class MaintenanceGetRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public MaintenanceGetRequest() {
        setMethod("maintenance.get");
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

    public class Params extends GetRequestCommonParams {

        private List<Integer> groupids;
        private List<Integer> hostids;
        private List<Integer> maintenanceids;
        private String selectGroups;
        private String selectHosts;
        private String selectTimeperiods;

        public void addGroupId(Integer id) {
            groupids = ZbxListUtils.add(groupids, id);
        }

        public void addHostId(Integer id) {
            hostids = ZbxListUtils.add(hostids, id);
        }

        public void addMaintenanceId(Integer id) {
            maintenanceids = ZbxListUtils.add(maintenanceids, id);
        }

        /**
         * Gets groupids.
         *
         * @return Value of groupids.
         */
        public List<Integer> getGroupids() {
            return groupids;
        }

        /**
         * Sets new groupids.
         *
         * @param groupids New value of groupids.
         */
        public void setGroupids(List<Integer> groupids) {
            this.groupids = groupids;
        }

        /**
         * Gets hostids.
         *
         * @return Value of hostids.
         */
        public List<Integer> getHostids() {
            return hostids;
        }

        /**
         * Sets new hostids.
         *
         * @param hostids New value of hostids.
         */
        public void setHostids(List<Integer> hostids) {
            this.hostids = hostids;
        }

        /**
         * Gets selectTimeperiods.
         *
         * @return Value of selectTimeperiods.
         */
        public String getSelectTimeperiods() {
            return selectTimeperiods;
        }

        /**
         * Sets new selectTimeperiods.
         *
         * @param selectTimeperiods New value of selectTimeperiods.
         */
        public void setSelectTimeperiods(String selectTimeperiods) {
            this.selectTimeperiods = selectTimeperiods;
        }

        /**
         * Gets selectHosts.
         *
         * @return Value of selectHosts.
         */
        public String getSelectHosts() {
            return selectHosts;
        }

        /**
         * Sets new selectHosts.
         *
         * @param selectHosts New value of selectHosts.
         */
        public void setSelectHosts(String selectHosts) {
            this.selectHosts = selectHosts;
        }

        /**
         * Gets selectGroups.
         *
         * @return Value of selectGroups.
         */
        public String getSelectGroups() {
            return selectGroups;
        }

        /**
         * Sets new selectGroups.
         *
         * @param selectGroups New value of selectGroups.
         */
        public void setSelectGroups(String selectGroups) {
            this.selectGroups = selectGroups;
        }

        /**
         * Gets maintenanceids.
         *
         * @return Value of maintenanceids.
         */
        public List<Integer> getMaintenanceids() {
            return maintenanceids;
        }

        /**
         * Sets new maintenanceids.
         *
         * @param maintenanceids New value of maintenanceids.
         */
        public void setMaintenanceids(List<Integer> maintenanceids) {
            this.maintenanceids = maintenanceids;
        }
    }
}
