package endterm_project.repositories.interfaces;


import endterm_project.entities.Book;
import endterm_project.entities.Library;

import java.util.List;

public interface ILibraryRepository {
    boolean createLibrary(Library library);
    Library getLibrary(int id);
    List<Library> getAllLibraries();
    int getLibraryBook(int id);
}