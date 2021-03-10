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
            String sql = "INSERT INTO library(university, address) VALUES (?,?)";
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
        return true;
    }

    @Override
    public Library getLibrary(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,university,address FROM library WHERE id=?";
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
            String sql = "SELECT id,university,address FROM library";
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
    public int getLibraryBook(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT book.id, book.title, book.author, book.year, library.university " +
                    "FROM book " +
                    "INNER JOIN library " +
                    "ON book.library_id=library.id where book.id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getShort("library_id"));
                books.add(book);
            }
            return books.size();
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



