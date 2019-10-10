package com.kurguzov;

import com.kurguzov.hibernate.SubscribersEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Query<SubscribersEntity> query = session.createQuery("from SubscribersEntity c");
        List<SubscribersEntity> cities = query.getResultList();
        System.out.println("Места жительства абонентов:");
        for (SubscribersEntity city : cities) {
            System.out.println(city.getSubFio()+" живёт в городе" + city.getSubCityId().getCityName());
        }

        System.out.println("Общие данные о абонентах:");
        for (SubscribersEntity city : cities) {
            System.out.println(city.getSubFio()+ " - " + city.getSubTariff()+ " - "
                    + city.getSubPrice() + " рублей" + " - " +city.getSubCityId().getCityName());
        }

        System.out.println("\t Информация об оплате каждого абонента:");
        for (SubscribersEntity city : cities) {
            System.out.println(city.getSubFio()+ " платит по " + city.getSubPrice() + " рублей");
        }

        session.close();


    }
}