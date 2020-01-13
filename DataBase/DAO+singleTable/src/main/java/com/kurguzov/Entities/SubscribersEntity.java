package com.kurguzov.Entities;

import java.util.Objects;

public class SubscribersEntity {
    private int sub_id;
    private String sub_fio;
    private String sub_city;
    private String sub_tariff;
    private int sub_price;

    public SubscribersEntity() {
    }

    public SubscribersEntity(int sub_id, String sub_fio, String sub_city, String sub_tariff, int sub_price) {
        this.sub_id = sub_id;
        this.sub_fio = sub_fio;
        this.sub_city = sub_city;
        this.sub_tariff = sub_tariff;
        this.sub_price = sub_price;
    }

    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_fio() {
        return sub_fio;
    }

    public void setSub_fio(String sub_fio) {
        this.sub_fio = sub_fio;
    }

    public String getSub_city() {
        return sub_city;
    }

    public void setSub_city(String sub_city) {
        this.sub_city = sub_city;
    }

    public String getSub_tariff() {
        return sub_tariff;
    }

    public void setSub_tariff(String sub_tariff) {
        this.sub_tariff = sub_tariff;
    }

    public int getSub_price() {
        return sub_price;
    }

    public void setSub_price(int sub_price) {
        this.sub_price = sub_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribersEntity that = (SubscribersEntity) o;
        return sub_id == that.sub_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sub_id);
    }

    @Override
    public String toString() {
        return sub_fio+ ": " +
                "ID = " + sub_id +
                ", Город = " + sub_city +
                ", Тариф = " + sub_tariff +
                ", Цена тарифа = " + sub_price;
    }
}
