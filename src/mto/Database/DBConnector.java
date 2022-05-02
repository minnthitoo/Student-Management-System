package mto.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnector {

    public static Connection getConnection(){

        Properties properties = new Properties();
        Connection connection = null;

        try {
            properties.load(new FileInputStream(DBConnector.class.getResource("details.properties").getPath()));
            Class.forName(properties.getProperty("DRIVER"));
            connection = DriverManager.getConnection(
                    properties.getProperty("URL"),
                    properties.getProperty("USER"),
                    properties.getProperty("PASSWORD")
            );
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void CloseConnection(Connection con, PreparedStatement prep, ResultSet res) {
        try {

            if (con != null) {
                con.close();
            }
            if (prep != null) {
                prep.close();
            }
            if (res != null) {
                res.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
