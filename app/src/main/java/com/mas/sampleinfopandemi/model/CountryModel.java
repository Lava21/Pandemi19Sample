package com.mas.sampleinfopandemi.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("lastUpdate")
    private String mLastUpdate;
    @SerializedName("confirmed")
    private IdnConfirmed idnConfirmed;
    @SerializedName("recovered")
    private IdnRecovered idnRecovered;
    @SerializedName("deaths")
    private IdnDeaths idnDeaths;

    public CountryModel(String mLastUpdate, IdnConfirmed idnConfirmed, IdnRecovered idnRecovered, IdnDeaths idnDeaths){
        this.mLastUpdate = mLastUpdate;
        this.idnConfirmed = idnConfirmed;
        this.idnRecovered = idnRecovered;
        this.idnDeaths = idnDeaths;
    }

    public String getmLastUpdate() {
        return mLastUpdate;
    }

    public void setmLastUpdate(String mLastUpdate) {
        this.mLastUpdate = mLastUpdate;
    }

    public IdnConfirmed getIdnConfirmed() {
        return idnConfirmed;
    }

    public void setIdnConfirmed(IdnConfirmed idnConfirmed) {
        this.idnConfirmed = idnConfirmed;
    }

    public IdnRecovered getIdnRecovered() {
        return idnRecovered;
    }

    public void setIdnRecovered(IdnRecovered idnRecovered) {
        this.idnRecovered = idnRecovered;
    }

    public IdnDeaths getIdnDeaths() {
        return idnDeaths;
    }

    public void setIdnDeaths(IdnDeaths idnDeaths) {
        this.idnDeaths = idnDeaths;
    }

    public class IdnConfirmed{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public IdnConfirmed(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public class IdnRecovered{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public IdnRecovered(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public class IdnDeaths{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public IdnDeaths(int value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
