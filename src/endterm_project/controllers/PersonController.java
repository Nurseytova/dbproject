package endterm_project.controllers;

import endterm_project.entities.Person;
import endterm_project.repositories.interfaces.IPersonRepository;

import java.util.List;

public class PersonController {
    /*calling repository where we create position in db*/
    private final IPersonRepository repo;

    /*constructor with repository parameter*/
    public PersonController(IPersonRepository repo) {
        this.repo = repo;
    }

    /*comment after actions*/
    /*for creating position*/
    public String createPerson(String name, String surname) {

        Person person = new Person(name, surname);

        boolean created = repo.createPerson(person);

        return (created ? "Person was created!" : "Person creation was failed!");
    }
    /*getting position by id*/
    public String getPerson(int id) {
        Person person = repo.getPerson(id);

        return (person == null ? "Person was not found!" : person.toString());
    }
    /*outputting all positions*/
    public String getAllPeople() {
        List<Person> people = repo.getAllPeople();
        return people.toString();
    }
}
