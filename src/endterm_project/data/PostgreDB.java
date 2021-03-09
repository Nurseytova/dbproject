package endterm_project.data;

import endterm_project.data.interfaces.IDB;


import java.sql.*;

/*to connect with BD*/
public class PostgreDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/library_db";
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
