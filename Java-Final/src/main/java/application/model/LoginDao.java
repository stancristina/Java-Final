package application.model;
import javax.xml.transform.Result;
import java.sql.*;

public class LoginDao {

    public static boolean validate(User user) {

        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement(
                    "select * from user1 where username = ? and pass = ?");

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
        }

        return status;


    }

}
