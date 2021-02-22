package project1;

import project1.data.PostgreDB;
import project1.data.interfaces.IDBS;
import project1.repositories.EmployeeRepository;
import project1.repositories.PositionRepository;
import project1.repositories.interfaces.IEmployeeRepository;
import project1.repositories.interfaces.IPositionRepository;

public class Main {

    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            // Here we load the driver’s class file into memory at the runtime
//            Class.forName("org.postgresql.Driver");
//
//            // Establish the connection
//            con = DriverManager.getConnection(connectionUrl, "postgres", "0000");
//
//            // The object of statement is responsible to execute queries with the database
//            stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
//            rs = stmt.executeQuery("select * mistake from users");
//
//            while (rs.next()) // Processing the result
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            try { // Close connection - clean up the system resources
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        // Here you specify which DB and  to use
        // And changing DB should not affect to whole code
        IDBS db = new PostgreDB();
        IPositionRepository repo = new PositionRepository(db);
        MyPosition app = new MyPosition(repo);
        app.start();

    }
}
