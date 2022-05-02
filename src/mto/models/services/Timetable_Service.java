package mto.models.services;

import mto.Database.DBConnector;
import mto.controllers.TimetableController;
import mto.models.Timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Timetable_Service {
    public int insertTimetable(Timetable timetable){

        int res = 0;

        String query = "insert into timetable (mon_fir_time, mon_sec_time, mon_tha_time, mon_for_time, tue_fir_time, tue_sec_time, tue_tha_time, tue_for_time, wed_fir_time, wed_sec_time, wed_tha_time, wed_for_time, thu_fir_time, thu_sec_time, thu_tha_time, thu_for_time, fri_fir_time, fri_sec_time, fri_tha_time, fri_for_time, major) values (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        Connection con = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, timetable.getMon_first());
            ps.setString(2, timetable.getMon_second());
            ps.setString(3, timetable.getMon_third());
            ps.setString(4, timetable.getMon_forth());

            ps.setString(5, timetable.getTue_first());
            ps.setString(6, timetable.getTue_second());
            ps.setString(7, timetable.getTue_third());
            ps.setString(8, timetable.getTue_forth());

            ps.setString(9, timetable.getWed_first());
            ps.setString(10, timetable.getWed_second());
            ps.setString(11, timetable.getWed_third());
            ps.setString(12, timetable.getWed_forth());

            ps.setString(13, timetable.getThu_first());
            ps.setString(14, timetable.getTue_second());
            ps.setString(15, timetable.getTue_third());
            ps.setString(16, timetable.getTue_forth());

            ps.setString(17, timetable.getFri_first());
            ps.setString(18, timetable.getFri_second());
            ps.setString(19, timetable.getFri_third());
            ps.setString(20, timetable.getFri_forth());

            ps.setString(21, timetable.getMajor());
            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(con, ps, null);

        return res;

    }

    public Timetable getTimetables(String major) {

        Timetable timetable = null;

        String query = "select * from timetable where major = ?;";

        Connection connection = DBConnector.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, major);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                timetable = new Timetable(
                        resultSet.getInt("id"),
                        resultSet.getString("mon_fir_time"),
                        resultSet.getString("mon_sec_time"),
                        resultSet.getString("mon_tha_time"),
                        resultSet.getString("mon_for_time"),
                        resultSet.getString("tue_fir_time"),
                        resultSet.getString("tue_sec_time"),
                        resultSet.getString("tue_tha_time"),
                        resultSet.getString("tue_for_time"),
                        resultSet.getString("wed_fir_time"),
                        resultSet.getString("wed_sec_time"),
                        resultSet.getString("wed_tha_time"),
                        resultSet.getString("wed_for_time"),
                        resultSet.getString("thu_fir_time"),
                        resultSet.getString("thu_sec_time"),
                        resultSet.getString("thu_tha_time"),
                        resultSet.getString("thu_for_time"),
                        resultSet.getString("fri_fir_time"),
                        resultSet.getString("fri_sec_time"),
                        resultSet.getString("fri_tha_time"),
                        resultSet.getString("fri_for_time")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(connection, ps, resultSet);

        return timetable;

    }

    public int updateTimetable(Timetable timetable){

        int res = 0;

        String query = "update timetable set mon_fir_time = ?, mon_sec_time = ?, mon_tha_time = ?, mon_for_time = ?, tue_fir_time = ?, tue_sec_time = ?, tue_tha_time = ?, tue_for_time = ?, wed_fir_time = ?, wed_sec_time = ?, wed_tha_time = ?, wed_for_time = ?, thu_fir_time = ?, thu_sec_time = ?, thu_tha_time = ?, thu_for_time = ?, fri_fir_time = ?, fri_sec_time = ?, fri_tha_time = ?, fri_for_time = ? where id = ?;";
        Connection connection = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, timetable.getMon_first());
            ps.setString(2, timetable.getMon_second());
            ps.setString(3, timetable.getMon_third());
            ps.setString(4, timetable.getMon_forth());

            ps.setString(5, timetable.getTue_first());
            ps.setString(6, timetable.getTue_second());
            ps.setString(7, timetable.getTue_third());
            ps.setString(8, timetable.getTue_forth());

            ps.setString(9, timetable.getWed_first());
            ps.setString(10, timetable.getWed_second());
            ps.setString(11, timetable.getWed_third());
            ps.setString(12, timetable.getWed_forth());

            ps.setString(13, timetable.getThu_first());
            ps.setString(14, timetable.getThu_second());
            ps.setString(15, timetable.getThu_third());
            ps.setString(16, timetable.getThu_forth());

            ps.setString(17, timetable.getFri_first());
            ps.setString(18, timetable.getFri_second());
            ps.setString(19, timetable.getFri_third());
            ps.setString(20, timetable.getFri_forth());

            ps.setInt(21, timetable.getId());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.CloseConnection(connection, ps, null);

        return res;

    }

    public int deleteTimetable(Timetable timetable){
        int res = 0;

        String query = "delete from timetable where id = ?";


        Connection connection = DBConnector.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, timetable.getId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  res;
    }

}
