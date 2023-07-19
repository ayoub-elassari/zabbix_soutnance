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

package com.example.testzabbix4j2maven.zabbix4j.itservice;

import com.example.testzabbix4j2maven.zabbix4j.GetRequestCommonParams;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;
import com.example.testzabbix4j2maven.zabbix4j.utils.ZbxListUtils;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class ITServiceGetRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public ITServiceGetRequest() {
        setMethod("service.get");
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

        private List<Integer> serviceids;
        private List<Integer> parentids;
        private List<Integer> childids;
        private String selectParent;
        private String selectDependencies;
        private String selectParentDependencies;
        private String selectTimes;
        private String selectAlarms;
        private String selectTrigger;

        public void addSerivceId(Integer id) {
            serviceids = ZbxListUtils.add(serviceids, id);
        }

        public void addParentId(Integer id) {
            parentids = ZbxListUtils.add(parentids, id);
        }

        public void addChildId(Integer id) {
            childids = ZbxListUtils.add(childids, id);
        }

        /**
         * Gets serviceids.
         *
         * @return Value of serviceids.
         */
        public List<Integer> getServiceids() {
            return serviceids;
        }

        /**
         * Sets new serviceids.
         *
         * @param serviceids New value of serviceids.
         */
        public void setServiceids(List<Integer> serviceids) {
            this.serviceids = serviceids;
        }

        /**
         * Gets selectDependencies.
         *
         * @return Value of selectDependencies.
         */
        public String getSelectDependencies() {
            return selectDependencies;
        }

        /**
         * Sets new selectDependencies.
         *
         * @param selectDependencies New value of selectDependencies.
         */
        public void setSelectDependencies(String selectDependencies) {
            this.selectDependencies = selectDependencies;
        }

        /**
         * Gets selectAlarms.
         *
         * @return Value of selectAlarms.
         */
        public String getSelectAlarms() {
            return selectAlarms;
        }

        /**
         * Sets new selectAlarms.
         *
         * @param selectAlarms New value of selectAlarms.
         */
        public void setSelectAlarms(String selectAlarms) {
            this.selectAlarms = selectAlarms;
        }

        /**
         * Gets childids.
         *
         * @return Value of childids.
         */
        public List<Integer> getChildids() {
            return childids;
        }

        /**
         * Sets new childids.
         *
         * @param childids New value of childids.
         */
        public void setChildids(List<Integer> childids) {
            this.childids = childids;
        }

        /**
         * Gets parentids.
         *
         * @return Value of parentids.
         */
        public List<Integer> getParentids() {
            return parentids;
        }

        /**
         * Sets new parentids.
         *
         * @param parentids New value of parentids.
         */
        public void setParentids(List<Integer> parentids) {
            this.parentids = parentids;
        }

        /**
         * Gets selectParentDependencies.
         *
         * @return Value of selectParentDependencies.
         */
        public String getSelectParentDependencies() {
            return selectParentDependencies;
        }

        /**
         * Sets new selectParentDependencies.
         *
         * @param selectParentDependencies New value of selectParentDependencies.
         */
        public void setSelectParentDependencies(String selectParentDependencies) {
            this.selectParentDependencies = selectParentDependencies;
        }

        /**
         * Gets selectParent.
         *
         * @return Value of selectParent.
         */
        public String getSelectParent() {
            return selectParent;
        }

        /**
         * Sets new selectParent.
         *
         * @param selectParent New value of selectParent.
         */
        public void setSelectParent(String selectParent) {
            this.selectParent = selectParent;
        }

        /**
         * Gets selectTimes.
         *
         * @return Value of selectTimes.
         */
        public String getSelectTimes() {
            return selectTimes;
        }

        /**
         * Sets new selectTimes.
         *
         * @param selectTimes New value of selectTimes.
         */
        public void setSelectTimes(String selectTimes) {
            this.selectTimes = selectTimes;
        }

        /**
         * Gets selectTrigger.
         *
         * @return Value of selectTrigger.
         */
        public String getSelectTrigger() {
            return selectTrigger;
        }

        /**
         * Sets new selectTrigger.
         *
         * @param selectTrigger New value of selectTrigger.
         */
        public void setSelectTrigger(String selectTrigger) {
            this.selectTrigger = selectTrigger;
        }
    }
}