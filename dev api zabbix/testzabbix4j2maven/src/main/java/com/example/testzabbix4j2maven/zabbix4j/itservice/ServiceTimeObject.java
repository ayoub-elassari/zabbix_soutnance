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

/**
 * @author Suguru Yajima
 */
public class ServiceTimeObject {

    private Integer timeid;
    private Integer serviceid;

    /**
     * Time when the service time comes into effect.
     * <p/>
     * For onetime downtimes ts_from must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM
     */
    private Integer ts_from;

    /**
     * Time when the service time ends.
     * <p/>
     * For onetime uptimes ts_to must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM
     */
    private Integer ts_to;

    private Integer type;
    private String note;

    /**
     * Gets Time when the service time comes into effect.
     * <p/>
     * For onetime downtimes ts_from must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     *
     * @return Value of Time when the service time comes into effect.
     * <p/>
     * For onetime downtimes ts_from must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     */
    public Integer getTs_from() {
        return ts_from;
    }

    /**
     * Sets new Time when the service time comes into effect.
     * <p/>
     * For onetime downtimes ts_from must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     *
     * @param ts_from New value of Time when the service time comes into effect.
     *                <p/>
     *                For onetime downtimes ts_from must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     */
    public void setTs_from(Integer ts_from) {
        this.ts_from = ts_from;
    }

    /**
     * Gets Time when the service time ends.
     * <p/>
     * For onetime uptimes ts_to must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     *
     * @return Value of Time when the service time ends.
     * <p/>
     * For onetime uptimes ts_to must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     */
    public Integer getTs_to() {
        return ts_to;
    }

    /**
     * Sets new Time when the service time ends.
     * <p/>
     * For onetime uptimes ts_to must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     *
     * @param ts_to New value of Time when the service time ends.
     *              <p/>
     *              For onetime uptimes ts_to must be set as a Unix timestamp, for other types - as a specific time in a week, in seconds, for example, 90000 for Tue, 2:00 AM.
     */
    public void setTs_to(Integer ts_to) {
        this.ts_to = ts_to;
    }

    /**
     * Gets timeid.
     *
     * @return Value of timeid.
     */
    public Integer getTimeid() {
        return timeid;
    }

    /**
     * Sets new timeid.
     *
     * @param timeid New value of timeid.
     */
    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }

    /**
     * Gets serviceid.
     *
     * @return Value of serviceid.
     */
    public Integer getServiceid() {
        return serviceid;
    }

    /**
     * Sets new serviceid.
     *
     * @param serviceid New value of serviceid.
     */
    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    /**
     * Gets type.
     *
     * @return Value of type.
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gets note.
     *
     * @return Value of note.
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets new note.
     *
     * @param note New value of note.
     */
    public void setNote(String note) {
        this.note = note;
    }

    public static enum SERVICE_TIME_TYPE {
        PLANNED_UPTIME(0), PLANNED_DOWNTIME(1), ONE_TIME_DOWMTIME(2);
        public int value;

        private SERVICE_TIME_TYPE(int value) {
            this.value = value;
        }

    }
}