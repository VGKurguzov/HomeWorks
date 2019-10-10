package com.kurguzov;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        String url = "jdbc:h2:~/test";
        String name = "sa";
        String password = "";

        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url,name,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT distinct SUB_TARIFF,SUB_PRICE FROM SUBSCRIBERS ORDER BY SUB_PRICE");

            while(resultSet.next()){
                System.out.println(resultSet.getString("sub_tariff") + " - " + resultSet.getInt("sub_price"));
            }
            System.out.println("--------------------------------------------------------");
            resultSet = statement.executeQuery("SELECT SUB_ID, SUB_FIO, CITY_NAME, SUB_TARIFF, SUB_PRICE FROM SUBSCRIBERS LEFT JOIN CITIES ON SUB_CITY_ID = CITY_ID");
            while(resultSet.next()){
                System.out.println("#" + resultSet.getInt("sub_id")
                        +"\t" + resultSet.getString("sub_fio") + "\t" + resultSet.getString("city_name")+
                        "\t" + resultSet.getString("sub_tariff") + "\t" + resultSet.getInt("sub_price"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
