package Connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest1 {
    @Test
    public void testConnection() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "liuwujie");

        Connection connection = driver.connect(url, info);
        System.out.println(connection);

    }
}
