package endterm_project.repositories;

import endterm_project.data.interfaces.IDB;
import endterm_project.entities.Book;
import endterm_project.entities.Library;
import endterm_project.repositories.interfaces.ILibraryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepository implements ILibraryRepository{
    private final IDB db;

    //constructor
    public LibraryRepository(IDB db){
        this.db = db;
    }

    @Override
    public boolean createLibrary(Library library) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO position(description, salary) VALUES (?,?)";
            //to insert data
            PreparedStatement st = con.prepareStatement(sql);
            //inserting each data
            st.setString(1, library.getUniversity());
            st.setString(2, library.getAddress());

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
    public Library getLibrary(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,university,address FROM book WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Library library = new Library(rs.getInt("id"),
                        rs.getString("university"),
                        rs.getString("address"));


                return library;
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
    public List<Library> getAllLibraries() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,university,address FROM book";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Library> libraries = new ArrayList<>();
            while (rs.next()) {
                Library library = new Library(rs.getInt("id"),
                        rs.getString("university"),
                        rs.getString("address"));

                libraries.add(library);
            }
            return libraries;
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
    public List<Book> getAllLibraryBooks(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.title, book.author, book.year, library.university\n" +
                    "FROM book\n" +
                    "INNER JOIN library\n" +
                    "ON book.id=library.id where id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getString("university"));
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



