package application.repository.impl;

import application.model.Company;
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
public class CompanyRepositoryImpl implements CRUDCustomRepository<Company> {

    @Override
    public Company save(Company entity) {
        Connection connection = null;

        String insertTableCompany = "INSERT INTO Company (name, address) VALUES(?, ?)";
        connection = (Connection) JDBCUtils.getDBConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insertTableCompany);
            ps.setString(1, entity.getName());
            ps.setString(2, String.valueOf(entity.getAddress()));
            ps.executeUpdate();

            System.out.println("Record is inserted into Company table");

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
    public List findAll() {
        List<Company> companyList = new ArrayList<>();
        Connection connection = null;

        String selectCompanySql = "SELECT * FROM Company";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(selectCompanySql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
                company.setAddress(resultSet.getString("address"));
                companyList.add(company);
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
        return companyList;
    }

    @Override
    public Company findById(Integer id) {
        return null;
    }

    @Override
    public Company update(Company entity) {
        Connection connection = null;

        String updateCompanySql = "UPDATE Company SET name = ?, address = ? WHERE id = ?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(updateCompanySql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getAddress());
            ps.setString(3, String.valueOf(entity.getId()));
            ps.executeUpdate();

            System.out.println("Record is updated in Company table ");
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

        String deleteCompanySql = "DELETE FROM Company WHERE id =?";
        connection = JDBCUtils.getDBConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(deleteCompanySql);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();

            System.out.println("Record is deleted from Company table");
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
