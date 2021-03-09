package endterm_project.entities;

import java.util.List;

public class Library {
    private int id;
    private String university;
    private String address;
    private static List<Book> booksInLibrary;

    public Library(String university, String address) {
        this.university = university;
        this.address = address;
    }

    public Library(int id, String university, String address) {
        this.id = id;
        this.university = university;
        this.address = address;
    }
    public Library(String university, String address, List<Book> booksInLibrary) {
        this.university = university;
        this.address = address;
        this.booksInLibrary=booksInLibrary;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", university='" + university + '\'' +
                ", address='" + address + '\'' +
                ", address='" + booksInLibrary + '\'' +
                '}';
    }
}

