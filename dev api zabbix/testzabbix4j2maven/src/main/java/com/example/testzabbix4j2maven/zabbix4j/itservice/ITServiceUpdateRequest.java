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

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class ITServiceUpdateRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public ITServiceUpdateRequest() {
        setMethod("service.update");
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

    public class Params extends ITServiceObject {

        private List<ServiceDependencyObject> dependencies;
        private Integer parentid;
        private List<ServiceTimeObject> times;

        /**
         * Gets parentid.
         *
         * @return Value of parentid.
         */
        public Integer getParentid() {
            return parentid;
        }

        /**
         * Sets new parentid.
         *
         * @param parentid New value of parentid.
         */
        public void setParentid(Integer parentid) {
            this.parentid = parentid;
        }

        /**
         * Gets dependencies.
         *
         * @return Value of dependencies.
         */
        public List<ServiceDependencyObject> getDependencies() {
            return dependencies;
        }

        /**
         * Sets new dependencies.
         *
         * @param dependencies New value of dependencies.
         */
        public void setDependencies(List<ServiceDependencyObject> dependencies) {
            this.dependencies = dependencies;
        }
    }
}
