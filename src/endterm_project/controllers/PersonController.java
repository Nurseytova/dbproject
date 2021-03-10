package endterm_project.controllers;

import endterm_project.entities.Book;
import endterm_project.entities.Person;
import endterm_project.repositories.interfaces.IPersonRepository;

import java.util.List;

public class PersonController {
    /*calling repository where we create position in db*/
    private final IPersonRepository repo;

    /*creating new objects*/
    public PersonController(IPersonRepository repo) {
        this.repo = repo;
    }

    /*comment after actions*/
    public String createPerson(String name, String surname, int library_id) {
        Person person = new Person(name, surname, library_id);
        boolean created = repo.createPerson(person);
        return (created ? "Person creation was failed!" : "You successfully created a person!");
    }

    public String getPerson(int id) {
        Person person = repo.getPerson(id);
        return (person == null ? "Person was not found!" : person.toString());
    }

    public String getAllPeople() {
        List<Person> people = repo.getAllPeople();
        return people.toString();
    }

    public String getAllPersonBooks(int id) {
        List<Book> books = repo.getAllPersonBooks(id);
        return (books == null ? "Person's book was not found!" : books.toString());
    }
}
