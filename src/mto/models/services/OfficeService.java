package mto.models.services;

import mto.Database.DBConnector;
import mto.models.Office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficeService {

    public List<Office> getOffice(){
        List<Office> offices = new ArrayList<>();

        String query = "select * from office";

        Connection connection = DBConnector.getConnection();
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        try {
            prep = connection.prepareStatement(query);
            resultSet = prep.executeQuery();

            while (resultSet.next()){
                offices.add(new Office(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offices;
    }
}
