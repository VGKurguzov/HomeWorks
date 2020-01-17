package com.kurguzov;

import com.kurguzov.Entities.CitiesEntity;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Services.CitiesService;
import com.kurguzov.Services.SubscribersService;
import com.kurguzov.Utils.ConnectionDB;
import com.kurguzov.Utils.XMLParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try{
            XMLParser.init();
        }catch (SAXException | IOException | ParserConfigurationException e){
            e.printStackTrace();
        }
        CitiesService citiesService = new CitiesService();
        SubscribersService subscribersService = new SubscribersService();
        try{
            CitiesEntity KazanCity = new CitiesEntity(8,"Омутминск");
            citiesService.add(KazanCity);
            System.out.println("Вывод всех городов:");
            System.out.println(citiesService.getAll());
            System.out.println("Город с ID = 4: " + citiesService.getById(4));
            SubscribersEntity human = new SubscribersEntity(22,"Коробкин Арсений Васильевич",2,"Огромный",1000);
            subscribersService.add(human);
            System.out.println("Вывод всех абонентов:");
            System.out.println(subscribersService.getAll());
            SubscribersEntity human2 = new SubscribersEntity(14,"Пупкин Яша Петрович",7,"Огромный",1000);
            subscribersService.update(human2);
            System.out.println("Абонент с ID = 14: " + subscribersService.getById(14));
            subscribersService.delete(22);
            citiesService.delete(8);
        }catch (ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ConnectionDB.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
