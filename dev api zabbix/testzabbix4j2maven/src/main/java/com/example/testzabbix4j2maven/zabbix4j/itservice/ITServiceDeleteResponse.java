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

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiResponse;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class ITServiceDeleteResponse extends ZabbixApiResponse {

    private Result result;

    public ITServiceDeleteResponse() {
        super();
    }

    /**
     * Gets result.
     *
     * @return Value of result.
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets new result.
     *
     * @param result New value of result.
     */
    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {

        private List<Integer> serviceids;


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
    }
}
