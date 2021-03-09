package endterm_project;


import endterm_project.controllers.BookController;
import endterm_project.repositories.interfaces.IBookRepository;

import java.util.Scanner;

public class LibraryFrontEnd {
    /*calling controller*/
    private final BookController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new position*/
    public LibraryFrontEnd(IBookRepository repos){
        this.controller=new BookController(repos) ;
        this.scanner=new Scanner(System.in) ;
    }

    /*console will start here when we call to do actions with position table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all positions");
            System.out.println("2. Get book by id");
            System.out.println("3. Create position");
            System.out.println("4. Get salary by position id");
            System.out.println("5. Get count of salary by position id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllLibrariesMenu();;
                } else if (option == 2) {
                    getBookByIdMenu();;
                } else if (option == 3) {
                    createLibraryMenu();
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

    public void getAllLibrariesMenu(){
        String response = controller.getAllLibraries();
        System.out.println(response);
    }

    public void getBookByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getLibrary(id);
        System.out.println(response);
    }

    public void createLibraryMenu(){
        System.out.println("Please enter title of book");
        String title = scanner.next();
        System.out.println("Please enter book's author");
        String author = scanner.next();
        System.out.println("Please enter year ");
        int year  = scanner.nextInt();

        String response = controller.createLibrary(title, author,year);
        System.out.println(response);
    }

}
