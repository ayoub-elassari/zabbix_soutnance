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

package com.example.testzabbix4j2maven.zabbix4j.hostinteface;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Suguru Yajima on 2014/05/01.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HostInterfaceObject {

    private Integer interfaceid;
    private String dns;
    private Integer hostid;
    private String ip;
    private Integer main;
    private Integer port;
    private Integer type;
    private Integer useip;

    public HostInterfaceObject() {
        super();
    }

    public static enum MAIN {
        NOT_DEFAULT(0),DEFAULT(1);

        public int value;
        private MAIN(int value) {
            this.value = value;
        }
    }

    public static enum TYPE {
        AGENT(1),SNMP(2),IPMI(3),JMX(4);
        public int value;
        private TYPE(int value) {
            this.value = value;
        }
    }

    public static enum USE_IP {
        USE_HOST_DNS(0),USE_HOST_IP(1);
        public int value;
        private USE_IP(int value) {
            this.value = value;
        }
    }
}
