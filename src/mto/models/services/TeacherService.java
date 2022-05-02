package mto.models.services;

import mto.Database.DBConnector;
import mto.models.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    public int insertTeacher(Teacher teacher){
        int result = 0;
        String query = "insert into teacher (name, nrc, major, email, phone, address, password) values (?,?,?,?,?,?,?);";

        Connection connection = DBConnector .getConnection();
        PreparedStatement prep = null;

        try {
            prep= connection.prepareStatement(query);
            prep.setString(1, teacher.getName());
            prep.setString(2, teacher.getNrc());
            prep.setString(3, teacher.getMajor());
            prep.setString(4, teacher.getEmail());
            prep.setString(5, teacher.getPhone());
            prep.setString(6, teacher.getAddress());
            prep.setString(7, teacher.getPassword());
            result = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(connection, prep, null);
        return result;
    }

    public List<Teacher> getTeachers (){
        List<Teacher> teachers = new ArrayList<>();

        String qurey = "select * from teacher";

        Connection connection = DBConnector.getConnection();
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        try {
            prep = connection.prepareStatement(qurey);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                teachers.add(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("nrc"),
                        resultSet.getString("major"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(connection, prep, resultSet);
        return teachers;

    }

    public List<Teacher> getAccounts (){
        List<Teacher> teachers = new ArrayList<>();

        String qurey = "select * from teacher";

        Connection connection = DBConnector.getConnection();
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        try {
            prep = connection.prepareStatement(qurey);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                teachers.add(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(connection, prep, resultSet);
        return teachers;

    }

    public List<Teacher> getTeachers (String major){
        List<Teacher> teachers = new ArrayList<>();

        String qurey = "select * from teacher where major = ?";

        Connection connection = DBConnector.getConnection();
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        try {
            prep = connection.prepareStatement(qurey);
            prep.setString(1, major);
            resultSet = prep.executeQuery();
            while (resultSet.next()){
                teachers.add(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(connection, prep, resultSet);
        return teachers;

    }

}
