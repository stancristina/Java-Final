package application.model;

public class User {

    private String username;

    private String password;

    private int idCompany;

    public User() {
    }

    public User(String username, String password, int idCompany) {
        this.username = username;
        this.password = password;
        this.idCompany = idCompany;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idCompany=" + idCompany +
                '}';
    }
}
