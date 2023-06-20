package service;

import model.LevelViolation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ViolationSv {
    private static final String url = "jdbc:mysql://localhost:3306/smartcard";
    private static final String user = "root";
    private static final String pass = "1";
    private static Connection connection;

    public static boolean addViolation (Double cccd, List<LevelViolation> list) throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
        String sql =  "insert into t_violation (citizen_identification_number, level_violation_id, created_date) values "  ;
        Statement statement = connection.createStatement();

        for (LevelViolation levelViolation : list) {
            sql += String.format(" (%f, %d, '%s'),", cccd, levelViolation.getId(), DateUtils.nowStr());
        }
        sql = sql.substring(0, sql.length() - 1) + ";";

        statement.execute(sql);

        return true;
    }
}
