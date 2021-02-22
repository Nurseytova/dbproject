package project1.data;

import project1.data.interfaces.IDBS;

import java.sql.*;

/*to connect with BD*/
public class PostgreDB implements IDBS {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/jdbc_1";
        try {
           /* Here we load the driver’s class file into memory at the runtime*/
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "27042003");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
