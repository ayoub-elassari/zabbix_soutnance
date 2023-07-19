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

package com.example.testzabbix4j2maven.zabbix4j.image;

import com.example.testzabbix4j2maven.zabbix4j.ZabbixApiRequest;

/**
 * @author Suguru Yajima
 */
public class ImageCreateRequest extends ZabbixApiRequest {

    private Params params = new Params();

    public ImageCreateRequest() {
        setMethod("image.create");
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

    public class Params extends ImageObject {

        /**
         * Base64 encoded image. The maximum size of the encoded image is 1 MB.
         */
        private String image;

        /**
         * Gets Base64 encoded image. The maximum size of the encoded image is 1 MB..
         *
         * @return Value of Base64 encoded image. The maximum size of the encoded image is 1 MB..
         */
        public String getImage() {
            return image;
        }

        /**
         * Sets new Base64 encoded image. The maximum size of the encoded image is 1 MB..
         *
         * @param image New value of Base64 encoded image. The maximum size of the encoded image is 1 MB..
         */
        public void setImage(String image) {
            this.image = image;
        }
    }
}
