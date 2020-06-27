package com.tlp.mybatisdemo.jdbc;

import java.sql.*;

/**
 * @author：tlp
 * @crateDate：2019/10/13 14:52
 */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://192.168.217.20:3306/test";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test_user");

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println(id + ":" + name);
        }
    }

}

