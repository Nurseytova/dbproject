package endterm_project;


import endterm_project.data.interfaces.IDB;
import endterm_project.repositories.BookRepository;
import endterm_project.repositories.interfaces.IBookRepository;
import endterm_project.data.PostgreDB;

public class Main {
    public static void main(String[] args) {
        IDB db = (IDB) new PostgreDB();
        IBookRepository repo = (IBookRepository) new BookRepository(db);
        BookFrontEnd app = new BookFrontEnd(repo);
        app.start();
    }
}