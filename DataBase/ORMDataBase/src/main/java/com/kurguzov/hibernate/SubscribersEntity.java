package com.kurguzov.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "SUBSCRIBERS", schema = "PUBLIC", catalog = "TEST")
public class SubscribersEntity {
    private int subId;
    private String subFio;
    private CitiesEntity subCityId;
    private String subTariff;
    private int subPrice;

    @Id
    @Column(name = "SUB_ID")
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "SUB_FIO")
    public String getSubFio() {
        return subFio;
    }

    public void setSubFio(String subFio) {
        this.subFio = subFio;
    }

    @ManyToOne
    @JoinColumn(name = "sub_city_id",referencedColumnName = "city_id",nullable = false)
    public CitiesEntity getSubCityId() {
        return subCityId;
    }

    public void setSubCityId(CitiesEntity subCityId) {
        this.subCityId = subCityId;
    }


    @Basic
    @Column(name = "SUB_TARIFF")
    public String getSubTariff() {
        return subTariff;
    }

    public void setSubTariff(String subTariff) {
        this.subTariff = subTariff;
    }

    @Basic
    @Column(name = "SUB_PRICE")
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
        if (subId != that.subId) return false;
        if (subPrice != that.subPrice) return false;
        if (subFio != null ? !subFio.equals(that.subFio) : that.subFio != null) return false;
        if (subTariff != null ? !subTariff.equals(that.subTariff) : that.subTariff != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = subId;
        result = 31 * result + (subFio != null ? subFio.hashCode() : 0);
        result = 31 * result + (subTariff != null ? subTariff.hashCode() : 0);
        result = 31 * result + subPrice;
        return result;
    }
}
