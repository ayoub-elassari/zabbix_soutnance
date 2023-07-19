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

package com.zabbix4j.image;

import com.zabbix4j.GetRequestCommonParams;
import com.zabbix4j.ZabbixApiRequest;
import com.zabbix4j.utils.ZbxListUtils;

import java.util.List;

/**
 * @author Suguru Yajima
 */
public class ImageGetRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public ImageGetRequest() {
        setMethod("image.get");
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

        private List<Integer> imageids;
        private List<Integer> sysmapids;
        private Boolean select_image;

        public void addImageId(Integer id) {
            imageids = ZbxListUtils.add(imageids, id);
        }

        public void addSystemId(Integer id) {
            sysmapids = ZbxListUtils.add(sysmapids, id);
        }

        /**
         * Gets sysmapids.
         *
         * @return Value of sysmapids.
         */
        public List<Integer> getSysmapids() {
            return sysmapids;
        }

        /**
         * Sets new sysmapids.
         *
         * @param sysmapids New value of sysmapids.
         */
        public void setSysmapids(List<Integer> sysmapids) {
            this.sysmapids = sysmapids;
        }

        /**
         * Gets select_image.
         *
         * @return Value of select_image.
         */
        public Boolean getSelect_image() {
            return select_image;
        }

        /**
         * Sets new select_image.
         *
         * @param select_image New value of select_image.
         */
        public void setSelect_image(Boolean select_image) {
            this.select_image = select_image;
        }

        /**
         * Gets imageids.
         *
         * @return Value of imageids.
         */
        public List<Integer> getImageids() {
            return imageids;
        }

        /**
         * Sets new imageids.
         *
         * @param imageids New value of imageids.
         */
        public void setImageids(List<Integer> imageids) {
            this.imageids = imageids;
        }
    }
}