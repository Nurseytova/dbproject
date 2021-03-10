package endterm_project;

import endterm_project.controllers.BookController;
import endterm_project.repositories.interfaces.IBookRepository;

import java.util.Scanner;

public class BookFrontEnd {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
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
            System.out.println(PURPLE + "Welcome to My Application" + RESET);
            System.out.println(BLUE + "Select option:" + RESET);
            System.out.println(YELLOW + "1. Get all books" + RESET);
            System.out.println(YELLOW + "2. Get book by id" + RESET);
            System.out.println(YELLOW + "3. Create book" + RESET);
            System.out.println(YELLOW + "0. Exit" + RESET);
            System.out.println();
            try {
                System.out.print(BLUE + "Enter option (1-3): " + RESET);
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
        System.out.println(YELLOW + "Please enter id" + RESET);
        int id = scanner.nextInt();
        String response = controller.getBook(id);
        System.out.println(response);
    }

    public void createBookMenu() {
        System.out.println(YELLOW + "Please enter title of book" + RESET);
        String title = scanner.next();
        System.out.println(YELLOW + "Please enter book's author" + RESET);
        String author = scanner.next();
        System.out.println(YELLOW + "Please enter year " + RESET);
        int year  = scanner.nextInt();
        System.out.println(YELLOW + "Please enter library id " + RESET);
        int library_id  = scanner.nextInt();

        String response = controller.createBook(title, author,year,library_id);
        System.out.println(response);
    }
}
