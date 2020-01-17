package com.kurguzov.Entities;

import java.util.Objects;

public class SubscribersEntity {
    private int subId;
    private String subFio;
    private int subCityId;
    private String subTariff;
    private int subPrice;

    public SubscribersEntity() {
    }

    public SubscribersEntity(int subId, String subFio, int subCityId, String subTariff, int subPrice) {
        this.subId = subId;
        this.subFio = subFio;
        this.subCityId = subCityId;
        this.subTariff = subTariff;
        this.subPrice = subPrice;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubFio() {
        return subFio;
    }

    public void setSubFio(String subFio) {
        this.subFio = subFio;
    }

    public int getSubCityId() {
        return subCityId;
    }

    public void setSubCityId(int subCityId) {
        this.subCityId = subCityId;
    }

    public String getSubTariff() {
        return subTariff;
    }

    public void setSubTariff(String subTariff) {
        this.subTariff = subTariff;
    }

    public int getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(int subPrice) {
        this.subPrice = subPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribersEntity that = (SubscribersEntity) o;
        return subId == that.subId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId);
    }

    @Override
    public String toString() {
        return subFio + ": " +
                "ID = " + subId +
                ", ID города = " + subCityId +
                ", Тариф = " + subTariff +
                ", Цена тарифа = " + subPrice;
    }
}
