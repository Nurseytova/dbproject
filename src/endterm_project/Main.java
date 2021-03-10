package endterm_project;


import endterm_project.data.interfaces.IDB;
import endterm_project.entities.Library;
import endterm_project.repositories.BookRepository;
import endterm_project.repositories.LibraryRepository;
import endterm_project.repositories.PersonRepository;
import endterm_project.repositories.interfaces.IBookRepository;
import endterm_project.data.PostgreDB;
import endterm_project.repositories.interfaces.ILibraryRepository;
import endterm_project.repositories.interfaces.IPersonRepository;

public class Main {
    public static void main(String[] args) {
       /* IDB db = new PostgreDB();
        IBookRepository repo = new BookRepository(db);
        BookFrontEnd app = new BookFrontEnd(repo);
        app.start();*/
        IDB db = new PostgreDB();
        IPersonRepository repo = new PersonRepository(db);
        PersonFrontEnd app2 = new PersonFrontEnd(repo);
        app2.start();
       /* IDB db = new PostgreDB();
        ILibraryRepository repo = new LibraryRepository(db);
        LibraryFrontEnd app3 = new LibraryFrontEnd(repo);
        app3.start();*/
    }
}