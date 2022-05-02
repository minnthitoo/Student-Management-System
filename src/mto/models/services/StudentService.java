package mto.models.services;

import mto.Database.DBConnector;
import mto.models.Student;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public int insertStudent(Student student){
        int res = 0;
        String query = "insert into student (name, nrc, s_class, phone, email, address) values (?,?,?,?,?,?);";
        Connection connection = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setString(2, student.getNrc());
            ps.setString(3, student.getS_class());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getAddress());
            res = ps.executeUpdate();
            if (res == 1){
                JOptionPane.showMessageDialog(null, "Student inserted successfully");
            }else {
                JOptionPane.showMessageDialog(null, "Insertion fill!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(connection, ps, null);
        return res;
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        String qurey = "select * from student;";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            ps = con.prepareStatement(qurey);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                students.add(new Student(
                      resultSet.getInt("id"),
                      resultSet.getString("name"),
                      resultSet.getString("nrc"),
                      resultSet.getString("s_class"),
                      resultSet.getString("phone"),
                      resultSet.getString("email"),
                      resultSet.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, resultSet);
        return students;
    }

    public int deleteStudent(int id){
        int res = 0;
        String query = "delete from student where id=?";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            res = ps.executeUpdate();
            if (res == 1){
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, null);
        return res;
    }

    public int studentUpdate(Student student){
        int res = 0;
        String query = "update student set name = ?, nrc = ?, s_class = ?, phone = ?, email = ?, address = ? where id = ?;";
        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, student.getName() );
            ps.setString(2, student.getNrc());
            ps.setString(3, student.getS_class());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getAddress());
            ps.setInt(7, student.getId());
            res = ps.executeUpdate();
            if (res == 1){
                JOptionPane.showMessageDialog(null, "Updated Successfully");
            }else {
                JOptionPane.showMessageDialog(null, "Update fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnector.CloseConnection(con, ps, null);
        return res;
    }
}
