//package com.kurguzov.DAO;
//
//import java.sql.Connection;
//
//public class DAOConnection {
//
//        private static final String DRIVER=
//                "COM.cloudscape.core.RmiJdbcDriver";
//        private static final String DBURL=
//                "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";
//
//
//        public static Connection createConnection() {
//            // Использовать DRIVER и DBURL для создания соединения
//            // Рекомендовать реализацию/использование пула соединений
//        }
//        public CustomerDAO getCustomerDAO() {
//            // CloudscapeCustomerDAO реализует CustomerDAO
//            return new CloudscapeCustomerDAO();
//        }
//        public AccountDAO getAccountDAO() {
//            // CloudscapeAccountDAO реализует AccountDAO
//            return new CloudscapeAccountDAO();
//        }
//        public OrderDAO getOrderDAO() {
//            // CloudscapeOrderDAO реализует OrderDAO
//            return new CloudscapeOrderDAO();
//        }
//
//
//}
