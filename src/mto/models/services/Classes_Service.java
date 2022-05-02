package mto.models.services;

import mto.Database.DBConnector;
import mto.models.Classes;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Classes_Service {
    public int insertClass(Classes classes){
        int res = 0;
        String query = "insert into classes (class_name, duration, startdate) values (?,?,?);";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, classes.getClass_name());
            ps.setString(2, classes.getDuration());
            ps.setString(3, classes.getStartdate());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, null);
        return res;

    }

    public List<Classes> getClasses(){
        List<Classes> classes = new ArrayList<>();
        String query = "select * from classes";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                classes.add(new Classes(
                        resultSet.getInt("id"),
                        resultSet.getString("class_name"),
                        resultSet.getString("duration"),
                        resultSet.getString("startdate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, resultSet);
        return classes;
    }

    public void updateClass(Classes classes){
        String query = "update classes set class_name = ?, duration = ?, startdate = ? where id = ?;";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, classes.getClass_name());
            ps.setString(2, classes.getDuration());
            ps.setString(3, classes.getStartdate());
            ps.setInt(4, classes.getId());
            int ind = ps.executeUpdate();
            if (ind == 1){
                JOptionPane.showMessageDialog(null, "Updated successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, null);
    }

    public void deleteClass(Classes classes){

        String query = "delete from classes where id = ?";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, classes.getId());
            int res = ps.executeUpdate();
            if (res == 1){
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(con, ps, null);

    }

}
