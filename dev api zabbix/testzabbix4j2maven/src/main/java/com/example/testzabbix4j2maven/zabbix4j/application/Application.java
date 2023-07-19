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

package com.example.testzabbix4j2maven.zabbix4j.application;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiException;
import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiMethod;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Suguru Yajima on 2014/05/22.
 */
public class Application extends ZabbixApiMethod {
    public Application(String apiUrl, String auth) {
        super(apiUrl, auth);
    }

    /**
     * This method allows to create new applications.
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public ApplicationCreateResponse create(ApplicationCreateRequest request) throws ZabbixApiException {
        ApplicationCreateResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, ApplicationCreateResponse.class);

        return response;
    }

    public ApplicationUpdateResponse update(ApplicationUpdateRequest request) throws ZabbixApiException {
        ApplicationUpdateResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);


        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, ApplicationUpdateResponse.class);


        return response;
    }

    public ApplicationDeleteResponse delete(ApplicationDeleteRequest request) throws ZabbixApiException {
        ApplicationDeleteResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, ApplicationDeleteResponse.class);


        return response;
    }

    public ApplicationGetResponse get(ApplicationGetRequest request) throws ZabbixApiException {
        ApplicationGetResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, ApplicationGetResponse.class);

        return response;
    }

    /**
     * This method allows to simultaneously add multiple items to the given applications.</br>
     * see <a href="https://www.zabbix.com/documentation/2.2/manual/api/reference/application/massadd">application.massadd</a>
     *
     * @param request
     * @return
     * @throws ZabbixApiException
     */
    public ApplicationMassaddResponse massadd(ApplicationMassaddRequest request) throws ZabbixApiException {
        ApplicationMassaddResponse response = null;
        request.setAuth(auth);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String requestJson = gson.toJson(request);

        String responseJson = sendRequest(requestJson);

        response = gson.fromJson(responseJson, ApplicationMassaddResponse.class);

        return response;
    }
}
