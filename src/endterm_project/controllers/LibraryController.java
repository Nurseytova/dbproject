package endterm_project.controllers;

import endterm_project.entities.Library;
import endterm_project.repositories.interfaces.ILibraryRepository;

import java.util.List;

public class LibraryController {
    /*calling repository where we create position in db*/
    private final ILibraryRepository repo;

    /*constructor with repository parameter*/
    public LibraryController(ILibraryRepository repo) {
        this.repo = repo;
    }

    /*comment after actions*/
    /*for creating position*/
    public String createLibrary(String university, String address) {

        Library library = new Library(university, address);

        boolean created = repo.createLibrary(library);

        return (created ? "Library was created!" : "Library creation was failed!");
    }
    /*getting Library by id*/
    public String getLibrary(int id) {
        Library library = repo.getLibrary(id);

        return (library == null ? "Library was not found!" : library.toString());
    }
    /*outputting all Libraries*/
    public String getAllLibraries() {
        List<Library> libraries = repo.getAllLibraries();
        return libraries.toString();
    }
}
