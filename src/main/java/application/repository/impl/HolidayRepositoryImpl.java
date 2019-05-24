package application.repository.impl;

import application.model.Holiday;
import application.repository.CRUDCustomRepository;
import application.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HolidayRepositoryImpl implements CRUDCustomRepository<Holiday> {

    @Override
    public Holiday save(Holiday entity) {
        Connection connection = null;

        String insertTableHoliday = "INSERT INTO Holiday (start_date, end_date, id_employee) VALUES(?, ?, ?)";
        connection = (Connection) JDBCUtils.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insertTableHoliday);
            ps.setDate(1, Date.valueOf(entity.getStartDate()));
            ps.setDate(2, Date.valueOf(entity.getEndDate()));
            ps.setInt(3, entity.getIdEmployee());
            ps.executeUpdate();

            System.out.println("Record is inserted into Holiday table");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return entity;
    }

    @Override
    public List<Holiday> findAll() {
        List<Holiday> holidayList = new ArrayList<>();
        Connection connection = null;

        String selectHolidaySql = "SELECT * FROM Holiday";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(selectHolidaySql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Holiday holiday = new Holiday();
                holiday.setId(resultSet.getInt("id"));
                holiday.setStartDate(resultSet.getDate("start_date").toLocalDate());
                holiday.setEndDate(resultSet.getDate("end_date").toLocalDate());
                holiday.setIdEmployee((resultSet.getInt("id_employee")));
                holidayList.add(holiday);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return holidayList;
    }

    @Override
    public Holiday findById(Integer id) {
        return null;
    }

    @Override
    public Holiday update(Holiday entity) {
        Connection connection = null;

        String updateHolidaySql = "UPDATE Holiday SET start_date = ?, end_date = ?, id_employee = ? WHERE id = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(updateHolidaySql);
            ps.setDate(1, Date.valueOf(entity.getStartDate()));
            ps.setDate(2, Date.valueOf(entity.getEndDate()));
            ps.setInt(3, entity.getIdEmployee());
            ps.setInt(4, entity.getId());
            ps.executeUpdate();

            System.out.println("Record is updated in Holiday table ");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return entity;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;

        String deleteHolidaySql = "DELETE FROM HOLIDAY WHERE id = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(deleteHolidaySql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Record is deleted from Holiday table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
