package com.myproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Indeed there is a DataBase Connection file but it has not been used in this project as all storage has been done on the computer files
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:derby:./myTasksdb;create=false";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private Connection connection;

    public DatabaseConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connection created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void createTL(String tlname){
        String sql = "CREATE TABLE " + tlname + " ( taskList_id INT, taskItem_id INT," +
                "FOREIGN KEY (taskItem_id) REFERENCES TaskItem(taskItem_id)," +
                "FOREIGN KEY (taskList_id) REFERENCES TaskList(taskList_id)";
    }
}
