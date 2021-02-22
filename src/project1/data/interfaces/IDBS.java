package project1.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/*interface method for getting a connect with presql with exceptions*/
public interface IDBS {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
