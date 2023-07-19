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

package com.zabbix4j.graphitem;

import com.zabbix4j.GetRequestCommonParams;
import com.zabbix4j.ZabbixApiRequest;
import com.zabbix4j.utils.ZbxListUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Request paramter for graphitem.get
 *
 * @author Suguru Yajima on 2014/06/01.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GraphItemGetRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public GraphItemGetRequest() {
        setMethod("graphitem.get");
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public class Params extends GetRequestCommonParams {
        private List<Integer> gitemids;
        private List<Integer> graphids;
        private List<Integer> itemids;
        private Integer type;
        private String expandData;
        private String selectGraphs;

        public void addGItemId(Integer id) {
            this.gitemids = ZbxListUtils.add(this.gitemids, id);
        }

        public void addGraphId(Integer id) {
            this.graphids = ZbxListUtils.add(this.graphids, id);
        }

        public void addItemId(Integer id) {
            this.itemids = ZbxListUtils.add(this.itemids, id);
        }

    }
}
