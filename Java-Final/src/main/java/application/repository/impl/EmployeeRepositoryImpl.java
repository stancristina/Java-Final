package application.repository.impl;

import application.model.Employee;
import application.repository.CRUDCustomRepository;
import application.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements CRUDCustomRepository<Employee> {

    @Override
    public  Employee save(Employee entity) {
        Connection connection = null;

        String insertTableEmployee = "INSERT INTO Employee (first_name, last_name, cnp, created_by) VALUES(?, ?, ?, ?)";
        connection = (Connection) JDBCUtils.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insertTableEmployee);
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3, entity.getCnp());
            ps.setInt(4, entity.getCreatedBy());
            ps.executeUpdate();

            System.out.println("Record is inserted into Employee table");

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
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;

        String selectEmployeeSql = "SELECT * FROM EMPLOYEE";
        connection = JDBCUtils.getDBConnection();

        try {
                PreparedStatement ps = connection.prepareStatement(selectEmployeeSql);
                ResultSet resultSet = ps.executeQuery();
                while(resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setCnp(resultSet.getLong("cnp"));
                    employee.setCreatedBy(resultSet.getInt("created_by"));
                    employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        Connection connection = null;

        String updateEmployeeSql = "UPDATE EMPLOYEE SET first_name = ?, last_name = ?, cnp = ? WHERE id = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(updateEmployeeSql);
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, String.valueOf(entity.getCnp()));
            ps.setString(4, String.valueOf(entity.getId()));
            ps.executeUpdate();

            System.out.println("Record is updated in Employee table ");
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

        String deleteEmployeeSql = "DELETE FROM EMPLOYEE WHERE id =?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(deleteEmployeeSql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Record is deleted from Employee table");
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
