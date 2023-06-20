package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class SmartCardSv {
    private static final String url = "jdbc:mysql://localhost:3306/smartcard";
    private static final String user = "root";
    private static final String pass = "1";
    private static Connection connection;

    public static void create (Double cccd, String avatarUrl, String publicKey, String name, Date dob, Integer balance) throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
//        String sql = String.format("insert")

    }
}