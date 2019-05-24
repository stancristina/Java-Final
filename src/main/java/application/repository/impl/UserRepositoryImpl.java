package application.repository.impl;


import application.model.User;
import application.repository.CRUDCustomRepository;
import application.utils.JDBCUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements CRUDCustomRepository<User> {

    @Override
    public User save(User entity) {
        Connection connection = null;

        String insertUserTable = "INSERT INTO User (username, password, company) VALUES(?, ?, ? )";
        connection = (Connection) JDBCUtils.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insertUserTable);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getCompany());
            ps.executeUpdate();

            System.out.println("Record is inserted into User table");

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
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;

        String selectUserSql = "SELECT * FROM User";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(selectUserSql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setCompany(resultSet.getString("company"));
                userList.add(user);
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
        return userList;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User update(User entity) {
        Connection connection = null;

        String updateUserSql = "UPDATE User SET username = ?, password = ?, company = ? WHERE id = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(updateUserSql);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            ps.setString(3, (entity.getCompany()));
            ps.setInt(4, entity.getId());
            ps.executeUpdate();

            System.out.println("Record is updated in User table ");
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

        String deleteUserSql = "DELETE FROM User WHERE idCompany =?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(deleteUserSql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Record is deleted from User table");
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

    public List<User> findByUsername(String username) {
        List<User> userList = new ArrayList<>();
        Connection connection = null;

        String selectUserSql = "SELECT * FROM User WHERE username = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(selectUserSql);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setCompany(resultSet.getString("company"));
                userList.add(user);
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
        return userList;

    }

    public List<User> findByCompany(String company) {
        List<User> userList = new ArrayList<>();
        Connection connection = null;

        String selectUserSql = "SELECT * FROM User WHERE company = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(selectUserSql);
            ps.setString(1, company);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setCompany(resultSet.getString("company"));
                userList.add(user);
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
        return userList;

    }
}
