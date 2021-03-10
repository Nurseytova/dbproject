package endterm_project.controllers;

import endterm_project.entities.Book;
import endterm_project.repositories.interfaces.IBookRepository;

import java.util.List;

public class BookController {
    /*calling repository where we create position in db*/
    private final IBookRepository repo;

    /*constructor with repository parameter*/
    public BookController(IBookRepository repo) {
        this.repo = repo;
    }

    /*comment after actions*/
    /*for creating position*/
    public String createBook(String title, String author, int year, int library_id) {

        Book book = new Book(title, author, year,library_id);

        boolean created = repo.createBook(book);

        return (created ? "Library was created!" : "Library creation was failed!");
    }
    /*getting Library by id*/
    public String getBook(int id) {
        Book book = repo.getBook(id);

        return (book == null ? "Library was not found!" : book.toString());
    }
    /*outputting all Libraries*/
    public String getAllBooks() {
        List<Book> books = repo.getAllBooks();
        return books.toString();
    }
}