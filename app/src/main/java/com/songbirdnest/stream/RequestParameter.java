package com.songbirdnest.stream;

public class RequestParameter {
    private String mParam;
    private String mValue;

    public RequestParameter(String aParam, String aValue) {
        this.mParam = aParam;
        this.mValue = aValue;
    }

    public String toString() {
        return this.mParam + "=" + this.mValue;
    }

    public String getParam() {
        return this.mParam;
    }

    public void setParam(String aParam) {
        this.mParam = aParam;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String aValue) {
        this.mValue = aValue;
    }
}
