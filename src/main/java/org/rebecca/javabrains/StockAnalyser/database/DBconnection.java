package org.rebecca.javabrains.StockAnalyser.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public Connection getConnnection() {
        Connection connection = null;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/stockanalyser";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
