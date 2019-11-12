package com.kurguzov.Entities;

import java.util.Objects;

public class CitiesEntity {
    private int city_id;
    private String city_name;

    public CitiesEntity() {
    }

    public CitiesEntity(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitiesEntity citiesEntity = (CitiesEntity) o;
        return city_id == citiesEntity.city_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id);
    }

    @Override
    public String toString() {
        return city_name +
                "(ID = " + city_id +
                ") ";
    }
}
