package application.model;

public class Employee {

    private int id;

    private String firstName;

    private String lastName;

    private Long cnp;

    private int idCompany;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp=" + cnp +
                ", idCompany=" + idCompany +
                '}';
    }

    public Employee(int id, String firstName, String lastName, Long cnp, int idCompany) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.idCompany = idCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }
}
