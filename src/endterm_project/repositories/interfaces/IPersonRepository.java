package endterm_project.repositories.interfaces;

import endterm_project.entities.Book;
import endterm_project.entities.Person;
import java.util.List;

public interface IPersonRepository {
    boolean createPerson(Person person);
    Person getPerson(int id);
    List<Person> getAllPeople();
    List<Book> getAllPersonBooks(int id);
}
