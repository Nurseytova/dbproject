package endterm_project;

import endterm_project.controllers.BookController;
import endterm_project.repositories.interfaces.IBookRepository;

import java.util.Scanner;

public class BookFrontEnd {
    /*calling controller*/
    private final BookController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new position*/
    public BookFrontEnd(IBookRepository repos){
        this.controller=new BookController(repos) ;
        this.scanner=new Scanner(System.in) ;
    }

    /*console will start here when we call to do actions with position table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get book by id");
            System.out.println("3. Create book");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllBooksMenu();
                } else if (option == 2) {
                    getBookByIdMenu();
                } else if (option == 3) {
                    createBookMenu();
                }else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("*************************");
        }
    }

    /*what to do in console with the methods*/
    public void getAllBooksMenu(){
        String feedback = controller.getAllBooks();
        System.out.println(feedback);
    }

    public void getBookByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getBook(id);
        System.out.println(response);
    }

    public void createBookMenu() {
        System.out.println("Please enter title of book");
        String title = scanner.next();
        System.out.println("Please enter book's author");
        String author = scanner.next();
        System.out.println("Please enter year ");
        int year  = scanner.nextInt();
        System.out.println("Please enter library id ");
        int library_id  = scanner.nextInt();

        String response = controller.createBook(title, author,year,library_id);
        System.out.println(response);
    }
}
