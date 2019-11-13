package com.kurguzov.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CITIES", schema = "PUBLIC", catalog = "TEST")
public class CitiesEntity implements Serializable {
    private int cityId;
    private String cityName;

    @Id
    @Column(name = "CITY_ID")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CITY_NAME")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitiesEntity that = (CitiesEntity) o;
        if (cityId != that.cityId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}
