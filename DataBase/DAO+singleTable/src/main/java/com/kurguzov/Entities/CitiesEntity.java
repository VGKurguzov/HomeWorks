package com.kurguzov.Entities;

import java.util.Objects;

public class CitiesEntity {
    private int cityId;
    private String cityName;

    public CitiesEntity() {
    }

    public CitiesEntity(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

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
        CitiesEntity citiesEntity = (CitiesEntity) o;
        return cityId == citiesEntity.cityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }

    @Override
    public String toString() {
        return cityName +
                "(ID = " + cityId +
                ") ";
    }
}
