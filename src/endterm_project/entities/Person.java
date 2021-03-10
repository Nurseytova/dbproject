package endterm_project.entities;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private static int id;
    private String name;
    private String surname;
    private int library_id;
    private List<Book> listOfBooks;

    public Person(String name, String surname, int library_id) {
        this.name = name;
        this.surname = surname;
    }

    public Person(int id, String name, String surname, int library_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", library id='" + library_id + '\'' +
                '}';
    }
}
