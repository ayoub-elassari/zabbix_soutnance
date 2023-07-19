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

package com.zabbix4j.hostgroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.ZabbixApiMethod;

/**
 * Created by Suguru Yajima on 2014/04/27.
 */
public class Hostgroup extends ZabbixApiMethod {

    public Hostgroup(String apiUrl, String auth) {
        super(apiUrl, auth);
    }

    /**
     * The method allows to retrieve host groups according to the given parameters.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/get">hostgroup.get</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupGetResponse get(HostgroupGetRequest request) throws ZabbixApiException {
        HostgroupGetResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupGetResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method checks if at least one host group that matches the given filter criteria exists.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/exists">hostgroup.exists</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupExistsResponse exist(HostgroupExistsRequest request) throws ZabbixApiException {
        HostgroupExistsResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupExistsResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to create new host groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/create">hostgroup.create</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupCreateResponse create(HostgroupCreateRequest request) throws ZabbixApiException {

        HostgroupCreateResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupCreateResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to update existing hosts groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/update">hostgroup.update</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupUpdateResponse update(HostgroupUpdateRequest request) throws ZabbixApiException {

        HostgroupUpdateResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupUpdateResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to delete host groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/delete">hostgroup.delete</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupDeleteResponse delete(HostgroupDeleteRequest request) throws ZabbixApiException {

        HostgroupDeleteResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupDeleteResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method checks if the given host groups are available for reading.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/isreadable">hostgroup.isreadable</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupIsReadableResponse isreadable(HostgroupIsReadableRequest request) throws ZabbixApiException {

        HostgroupIsReadableResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupIsReadableResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method checks if the given host groups are available for writing.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/iswritable">hostgroup.iswritable</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupIsWritableResponse isWritable(HostgroupIsWritableRequest request) throws ZabbixApiException {

        HostgroupIsWritableResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupIsWritableResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to retrieve host groups that match the given filter criteria.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/getobjects">hostgroup.getobjects</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupGetobjectsResponse getobjects(HostgroupGetobjectsRequest request) throws ZabbixApiException {
        HostgroupGetobjectsResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupGetobjectsResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to simultaneously add multiple related objects to all the given host groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/massadd">hostgroup.massadd</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupMassaddResponse massadd(HostgroupMassaddRequest request) throws ZabbixApiException {
        HostgroupMassaddResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        try {
            String responseJson = sendRequest(requestJson);

            response = gson.fromJson(responseJson, HostgroupMassaddResponse.class);
        } catch (ZabbixApiException e) {
            throw new ZabbixApiException(e);
        }

        return response;
    }

    /**
     * This method allows to remove related objects from multiple host groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/massremove">hostgroup.massremove</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupMassremoveResponse massremove(HostgroupMassremoveRequest request) throws ZabbixApiException {
        HostgroupMassremoveResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, HostgroupMassremoveResponse.class);

        return response;
    }

    /**
     * This method allows to simultaneously replace or remove related objects for multiple host groups.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/hostgroup/massupdate">hostgroup.massupdate</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public HostgroupMassupdateResponse massupdate(HostgroupMassupdateRequest request) throws ZabbixApiException {
        HostgroupMassupdateResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, HostgroupMassupdateResponse.class);

        return response;
    }
}
