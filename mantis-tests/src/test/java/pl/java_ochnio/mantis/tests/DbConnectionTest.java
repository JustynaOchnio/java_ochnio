package pl.java_ochnio.mantis.tests;

import org.testng.annotations.Test;
import pl.java_ochnio.mantis.model.UserData;
import pl.java_ochnio.mantis.model.Users;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection() {
        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/bugtracker?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,username from mantis_user_table");
            Users users = new Users();
            while (rs.next()) {
                users.add(new UserData().withId(rs.getInt("id")).withUsername(rs.getString("username")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(users);

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
