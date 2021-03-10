package endterm_project.repositories;

import endterm_project.data.interfaces.IDB;
import endterm_project.entities.Book;
import endterm_project.entities.Person;
import endterm_project.repositories.interfaces.IBookRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private final IDB db;

    //constructor
    public BookRepository(IDB db){
        this.db = db;
    }

    @Override
    public boolean createBook(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO book(title, author, year, library_id) VALUES (?,?,?,?)";
            //to insert data
            PreparedStatement st = con.prepareStatement(sql);
            //inserting each data
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setInt(3, book.getYear());
            st.setInt(4, book.getLibrary_id());


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
    public Book getBook(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,author,year,library_id FROM book WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("library_id"));

                return book;
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
    public List<Book> getAllBooks() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,author,year,library_id FROM book";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>();
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

    @Override
    public List<Person> getBookUsers(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.title, person.id, person.name, person.surname\n" +
                    "FROM book\n" +
                    "INNER JOIN book_person\n" +
                    "ON person.id=book_person.book_id\n" +
                    "INNER JOIN person\n" +
                    "ON book_person.person_id=person.id where person.id=?;";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

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

}