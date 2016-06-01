package com.qiudao.demo.domain;

/**
 * Created by hdfs on 2016/6/1.
 */
public class PhoneNumberModel {
    private String areaCode;
    private String phoneNumber;

    public PhoneNumberModel(){

    }

    public PhoneNumberModel(String areaCode, String phoneNumber) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumberModel{" +
                "areaCode='" + areaCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
