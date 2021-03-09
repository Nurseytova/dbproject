package endterm_project.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/*interface method for getting a connect with presql with exceptions*/
public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
