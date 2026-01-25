package ge.tbc.automation.data;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnection {
    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new SQLServerDriver());

            String dbURL = JDBConfiguration.getURL();
            String dbUsername =JDBConfiguration.getUsername();
            String dbPassword = JDBConfiguration.getPassword();

            return DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
