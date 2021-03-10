package endterm_project.entities;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private int library_id;
    private static List<Person> BookUsers;

    public Book(String title, String author, int year, int library_id){
        this.title = title;
        this.author = author;
        this.year = year;
        this.library_id=library_id;
    }
    public Book(String title, String author, int year, int library_id, List<Person> BookUsers){
        this.title = title;
        this.author = author;
        this.year = year;
        this.library_id=library_id;
        this.BookUsers=BookUsers;
    }

    public Book(int id, String title, String author, int year,int library_id){
        this.id=id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.library_id=library_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + year + '\'' +
                '}';
    }
}
