package endterm_project.repositories.interfaces;

import endterm_project.entities.Book;
import endterm_project.entities.Person;

import java.util.List;

public interface IBookRepository {
    boolean createBook(Book book);
    Book getBook(int id);
    List<Book> getAllBooks();
    int getBookUsers(int id);
}