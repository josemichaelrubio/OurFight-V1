package dev.rubio;

import dev.rubio.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

//Set the system variables in every run configuration

public class ConnectionTest {
    public static void main(String[] args) {
        //We handling the thrown exception from ConnectionUtil
        try {
            Connection c = ConnectionUtil.getConnection();
            System.out.println(c.getMetaData().getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
