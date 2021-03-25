//Establishes a connection to our database
package dev.rubio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver"); //Helps load in the driver from our class path so we won't run into an exception. Not needed but it helps.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection == null || connection.isClosed()) {
            String connectionUrl = System.getenv("connectionUrl");
            String username = System.getenv("username"); //never hard code username and password. Instead, We use environment variables
            String password = System.getenv("password");

            //create a connection
            connection = DriverManager.getConnection(connectionUrl,username,password);
        }
        return connection;
    }
}
