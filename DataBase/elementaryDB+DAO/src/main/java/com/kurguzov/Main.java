package com.kurguzov;

import com.kurguzov.Entities.CitiesEntity;
import com.kurguzov.Entities.SubscribersEntity;
import com.kurguzov.Service.CitiesService;
import com.kurguzov.Service.SubscribersService;
import com.kurguzov.Utils.XMLParser;

public class Main extends XMLParser {

    public static void main(String[] args) {
        CitiesEntity novosibirskCity = new CitiesEntity(5,"Новосибирск");
        CitiesService citiesService = new CitiesService();
        System.out.println("Вывод всех городов");
        System.out.println(citiesService.getAll());
        System.out.println("Город с id = 2");
        System.out.println(citiesService.getById(2).getCity_name());
        citiesService.add(novosibirskCity);

        SubscribersEntity human = new SubscribersEntity(21,"Столов Алексей Игоревич",5,"Малый",100);
        SubscribersService subscribersService = new SubscribersService();
        subscribersService.add(human);
        System.out.println("Вывод всех абонентов");
        System.out.println(subscribersService.getAll());

        SubscribersEntity human2 = new SubscribersEntity(20,"Вилкин Пётр Петрович",5,"Огромный",1000);
        subscribersService.update(human2);

        subscribersService.delete(21);

    }

}
