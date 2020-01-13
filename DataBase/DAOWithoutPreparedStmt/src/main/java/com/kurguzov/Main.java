package com.kurguzov;

import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Services.SubscribersService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        SubscribersService subscribersService = new SubscribersService();
        try{
            SubscribersEntity human = new SubscribersEntity(21,"Петров Пётр Петрович","Тула","Огромный",1000);
            subscribersService.add(human);
            System.out.println("Вывод всех абонентов:");
            System.out.println(subscribersService.getAll());
            SubscribersEntity human2 = new SubscribersEntity(14,"Пупкин Яша Петрович","Тверь","Огромный",1000);
            subscribersService.update(human2);
            System.out.println("Абонент с ID = 14: " + subscribersService.getById(14));
            subscribersService.delete(21);
        }catch (SAXException|IOException|ParserConfigurationException|ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
    }
}
