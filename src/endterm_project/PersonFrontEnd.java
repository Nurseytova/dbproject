package endterm_project;

import endterm_project.controllers.PersonController;
import endterm_project.repositories.interfaces.IPersonRepository;

import java.util.Scanner;

import static java.lang.System.exit;

public class PersonFrontEnd {
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
    private final PersonController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new position*/
    public PersonFrontEnd(IPersonRepository repos){
        this.controller=new PersonController(repos) ;
        this.scanner=new Scanner(System.in) ;
    }

    /*console will start here when we call to do actions with position table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println(PURPLE + "Welcome to Library" + RESET);
            System.out.println(BLUE + "Select option:" + RESET);
            System.out.println(YELLOW + "1. Get all people" + RESET);
            System.out.println(YELLOW + "2. Get person by id" + RESET);
            System.out.println(YELLOW + "3. Create person" + RESET);
            System.out.println(YELLOW + "4. Get all books of person by person's id" + RESET);
            System.out.println(YELLOW + "0. Exit" + RESET);
            System.out.println();
            Integer choice = scanner.nextInt();
//            try {
               /* switch (choice){
                    case 1 -> getAllPeopleMenu();
                    case 2 -> getPersonByIdMenu();
                    case 3 ->createPersonMenu();
                    case 4-> getAllPersonBooksMenu();
                    case 5 -> {
                        break;
                    }*/
//                }

                try {
                    System.out.print(BLUE + "Enter option (1-4): " + RESET);
                    int option = scanner.nextInt();
                    if (option == 1) {
                        getAllPersonBooksMenu();;
                    } else if (option == 2) {
                        getPersonByIdMenu();
                    } else if (option == 3) {
                        createPersonMenu();
                    } else if (option == 4) {
                        getAllPeopleMenu();
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
    public void getAllPeopleMenu(){
        String response = controller.getAllPeople();
        System.out.println(response);
    }

    public void getPersonByIdMenu() {
        System.out.println(YELLOW + "Please enter id" + RESET);
        int id = scanner.nextInt();
        String response = controller.getPerson(id);
        System.out.println(response);
    }
    public void getAllPersonBooksMenu() {
        System.out.println(YELLOW + "Please enter id" + RESET);
        int id = scanner.nextInt();
        String response = controller.getAllPersonBooks(id);
        System.out.println(response);
    }

    public void createPersonMenu() {
        System.out.println(YELLOW + "Please enter name" + RESET);
        String name = scanner.next();
        System.out.println(YELLOW + "Please enter surname" + RESET);
        String surname = scanner.next();
        System.out.println(YELLOW + "Now, enter library id" + RESET);
        int library_id = scanner.nextInt();

        String response = controller.createPerson(name, surname,library_id);
        System.out.println(response);
    }
}
