package endterm_project.controllers;

import endterm_project.entities.Book;
import endterm_project.repositories.interfaces.IBookRepository;

import java.util.List;

public class BookController {
    private final IBookRepository repo;
/*connecting repository where all methods*/
    public BookController(IBookRepository repo) {
        this.repo = repo;
    }
/*creating new objects*/
    public String createBook(String title, String author, int year, int library_id) {

        Book book = new Book(title, author, year,library_id);

        boolean created = repo.createBook(book);

        return (created ? "Book creation was failed!" : "You successfully created a new book!");
    }
    public String getBook(int id) {
        Book book = repo.getBook(id);

        return (book == null ? "Library was not found!" : book.toString());
    }
    public String getAllBooks() {
        List<Book> books = repo.getAllBooks();
        return books.toString();
    }

}