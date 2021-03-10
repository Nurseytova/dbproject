package endterm_project.controllers;

import endterm_project.entities.Book;
import endterm_project.entities.Library;
import endterm_project.repositories.interfaces.ILibraryRepository;

import java.util.List;

public class LibraryController {
    /*calling repository where data puts in methods*/
    private final ILibraryRepository repo;

    /*creating new objects*/
    public LibraryController(ILibraryRepository repo) {
        this.repo = repo;
    }

    public String createLibrary(String university, String address, int year) {
        Library library = new Library(university, address);
        boolean created = repo.createLibrary(library);
        return (created ? "Library creation was failed!" : "Library was created!");
    }
    public String getLibrary(int id) {
        Library library = repo.getLibrary(id);
        return (library == null ? "Library was not found!" : library.toString());
    }
    public String getAllLibraries() {
        List<Library> libraries = repo.getAllLibraries();
        return libraries.toString();
    }
    public String getLibraryBooks(int id) {
        int books = repo.getLibraryBook(id);
        return (books == 0 ? "Library was not found!" : String.valueOf(books));
    }
}
