package project1.repositories;

import project1.data.interfaces.IDBS;
import project1.entities.Position;
import project1.repositories.interfaces.IPositionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*repository where */
public class PositionRepository implements IPositionRepository {
    private final IDBS db;

    //constructor
    public PositionRepository(IDBS db){
        this.db = db;
    }

    @Override
    public boolean createPosition(Position position) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO position(description, salary) VALUES (?,?)";
            //to insert data
            PreparedStatement st = con.prepareStatement(sql);
            //inserting each data
            st.setString(1, position.getDescription());
            st.setInt(2, position.getSalary());

            boolean executed = st.execute();
            return executed;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Position getPosition(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,description,salary FROM position WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Position position = new Position(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("salary"));

                return position;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Position> getAllPositions() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,description,salary FROM position";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Position> positions = new ArrayList<>();
            while (rs.next()) {
                Position position = new Position(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("salary"));

                positions.add(position);
            }

            return positions;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getSalaryById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM position WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int salary = rs.getInt("salary");

                return salary;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }
    @Override
    public int getSumOfSalaryById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, description, salary  FROM position";
            //   String sql2 = "SELECT*FROM Specialty WHERE id=? AND SUM(salary)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Integer sum = 0;
            while (rs.next()) {
                Position position = new Position(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("salary"));
                sum += position.getSalary();
            }
            return sum;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
             } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

}
