package com.qiudao.demo.domain;

import com.qiudao.demo.mvcModule.formatter.PhoneNumber;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * Created by hdfs on 2016/6/1.
 */
public class FormatterModel {

    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###")
    private int totalCount;

    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double discount;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double sumMoney;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date registerDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    @PhoneNumber
    private PhoneNumberModel phoneNumberModel;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public PhoneNumberModel getPhoneNumberModel() {
        return phoneNumberModel;
    }

    public void setPhoneNumberModel(PhoneNumberModel phoneNumberModel) {
        this.phoneNumberModel = phoneNumberModel;
    }

    @Override
    public String toString() {
        return "FormatterModel{" +
                "totalCount=" + totalCount +
                ", discount=" + discount +
                ", sumMoney=" + sumMoney +
                ", registerDate=" + registerDate +
                ", orderDate=" + orderDate +
                ", phoneNumberModel=" + phoneNumberModel +
                '}';
    }
}
