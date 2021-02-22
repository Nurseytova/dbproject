package project1;

import project1.controllers.EmployeeController;
import project1.entities.Employee;
import project1.repositories.interfaces.IEmployeeRepository;
import java.util.Scanner;

/*class where all methods and constructors works, running Position commands*/
public class EmployeeFrontend {
    private final EmployeeController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new employee*/
    public EmployeeFrontend (IEmployeeRepository reposi) {
        controller = new EmployeeController(reposi);
        scanner = new Scanner(System.in);
    }
/*console will start here when we call to do actions with employee table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Create employee");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
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
    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter position id");
        int position_id = scanner.nextInt();

        String response = controller.createEmployee(name, surname, gender,position_id);
        System.out.println(response);
    }
}
