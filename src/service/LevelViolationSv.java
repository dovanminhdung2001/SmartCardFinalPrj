package service;

import model.LevelViolation;

import java.sql.*;
import java.util.ArrayList;

public class LevelViolationSv {
    private static final String url = "jdbc:mysql://localhost:3306/smartcard";
    private static final String user = "root";
    private static final String pass = "1";
    private static Connection connection;

    public static ArrayList<LevelViolation> findAllByTypeVehicle (int typeVehicle) throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
        String sql = String.format(
                "select tlv.id, tlv .kind_vehicle , tlv .penalty_range, tlv .status, tlv .type_violation_id , ttv.reason, ttv .status as 'type_status' " +
                "from t_level_violation tlv, t_type_violation ttv " +
                "where  tlv.type_violation_id = ttv.id and tlv .kind_vehicle = %d ;", typeVehicle
        );
        Statement statement = connection.createStatement();
        ArrayList<LevelViolation> list = new ArrayList<>();

        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            list.add(new LevelViolation(
                    resultSet.getInt("id"),
                    resultSet.getInt("kind_vehicle"),
                    resultSet.getInt("penalty_range"),
                    resultSet.getInt("status"),
                    resultSet.getInt("type_violation_id"),
                    resultSet.getString("reason"),
                    resultSet.getInt("type_status")
            ));
        }
        return list;
    }
}
