package com.kurguzov;

import com.kurguzov.hibernate.CitiesEntity;
import com.kurguzov.hibernate.SubscribersEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        String hql="from SubscribersEntity c";
        Query<SubscribersEntity> query = session.createQuery(hql);

        List<SubscribersEntity> cities = query.getResultList();

        for (SubscribersEntity city : cities) {
            System.out.println(city.getSubFio()+"---" + city.getSubCityId().getCityName());
        }

        session.close();


    }
}