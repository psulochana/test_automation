package com.library.mgmnt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:8895/librarymanagement";
        String username = "";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }
}
