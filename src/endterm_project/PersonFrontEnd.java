package endterm_project;

import endterm_project.controllers.PersonController;
import endterm_project.repositories.interfaces.IPersonRepository;

import java.util.Scanner;

import static java.lang.System.exit;

public class PersonFrontEnd {
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
            System.out.println("Welcome to Library");
            System.out.println("Select option:");
            System.out.println("1. Get all people");
            System.out.println("2. Get person by id");
            System.out.println("3. Create person");
            System.out.println("4. Get all books of person by person's id");
            System.out.println("0. Exit");
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
                    System.out.print("Enter option (1-4): ");
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
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPerson(id);
        System.out.println(response);
    }
    public void getAllPersonBooksMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getAllPersonBooks(id);
        System.out.println(response);
    }

    public void createPersonMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Now, enter library id");
        int library_id = scanner.nextInt();

        String response = controller.createPerson(name, surname,library_id);
        System.out.println(response);
    }
}
