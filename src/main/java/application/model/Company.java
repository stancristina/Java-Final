package application.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private int id;

    private String name;

    private String address;

    //private List<Employee> employeeList = new ArrayList<>();

    public Company() {
    }

    public Company(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        //this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\''+
                '}';
    }
}
