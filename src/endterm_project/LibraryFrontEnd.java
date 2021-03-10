package endterm_project;


import endterm_project.controllers.LibraryController;
import endterm_project.repositories.interfaces.ILibraryRepository;

import java.util.Scanner;

public class LibraryFrontEnd {
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
    private final LibraryController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new position*/
    public LibraryFrontEnd(ILibraryRepository repos){
        this.controller=new LibraryController(repos) ;
        this.scanner=new Scanner(System.in) ;
    }

    /*console will start here when we call to do actions with position table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println(PURPLE + "Welcome to My Application" + RESET);
            System.out.println(BLUE + "Select option:" + RESET);
            System.out.println(YELLOW + "1. Get all Libraries" + RESET);
            System.out.println(YELLOW + "2. Get book by id" + RESET);
            System.out.println(YELLOW + "3. Create library" + RESET);
            System.out.println(YELLOW + "4. Get all books in library by id" + RESET);
            System.out.println(YELLOW + "0. Exit" + RESET);
            System.out.println();
            try {
                System.out.print(BLUE + "Enter option (1-4): " + RESET);
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllLibrariesMenu();;
                } else if (option == 2) {
                    getLibraryByIdMenu();
                } else if (option == 3) {
                    createLibraryMenu();
                } else if (option == 4) {
                    getAllLibraryBooksMenu();
                } else {
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
    public void getAllLibrariesMenu(){
        String response = controller.getAllLibraries();
        System.out.println(response);
    }
    public void getAllLibraryBooksMenu(){
        System.out.println(YELLOW + "Please enter id" + RESET);
        int id = scanner.nextInt();
        String response = controller.getLibraryBooks(id);
        System.out.println(response);
    }

    public void getLibraryByIdMenu() {
        System.out.println(YELLOW + "Please enter id" + RESET);
        int id = scanner.nextInt();
        String response = controller.getLibrary(id);
        System.out.println(response);
    }

    public void createLibraryMenu(){
        System.out.println(YELLOW + "Please enter title of book" + RESET);
        String title = scanner.next();
        System.out.println(YELLOW + "Please enter book's author" + RESET);
        String author = scanner.next();
        System.out.println(YELLOW + "Please enter year " + RESET);
        int year  = scanner.nextInt();

        String response = controller.createLibrary(title, author,year);
        System.out.println(response);
    }

}
