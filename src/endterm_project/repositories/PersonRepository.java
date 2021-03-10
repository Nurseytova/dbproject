package endterm_project.repositories;

import endterm_project.data.interfaces.IDB;
import endterm_project.entities.Book;
import endterm_project.entities.Library;
import endterm_project.entities.Person;
import endterm_project.repositories.interfaces.IPersonRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {
    private final IDB db;

    //constructor
    public PersonRepository(IDB db){
        this.db = db;
    }
    @Override
    public boolean createPerson(Person person) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO person(name, surname,library_id) VALUES (?,?,?)";
            //to insert data
            PreparedStatement st = con.prepareStatement(sql);
            //inserting each data
            st.setString(1, person.getName());
            st.setString(2, person.getSurname());
            st.setInt(3, person.getLibrary_id());

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
        return true;
    }
    @Override
    public Person getPerson(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,library_id FROM person WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Person person = new Person(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("library_id"));

                return person;
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
    public List<Person> getAllPeople() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname, library_id FROM person";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Person> people = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("library_id"));

                people.add(person);
            }
            return people;
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
    public List<Book> getAllPersonBooks(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.title, book.author, book.year, person.id, person.name, person.surname " +
                    "FROM person " +
                    "INNER JOIN book_person " +
                    "ON person.id=book_person.person_id " +
                    "INNER JOIN book " +
                    "ON book_person.book_id=book.id where person.id=?;";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>(id);
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("library_id"));

                books.add(book);
            }
            return books;
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

}
