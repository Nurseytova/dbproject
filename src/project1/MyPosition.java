package project1;

import project1.controllers.PositionController;
import project1.repositories.interfaces.IPositionRepository;

import java.util.Scanner;

/*class where all methods and constructors works, running Position commands*/
public class MyPosition {
    /*calling controller*/
    private final PositionController controller;
    private final Scanner scanner;

    /*creating new controller and scanner for new position*/
    public MyPosition(IPositionRepository repos){
        this.controller=new PositionController(repos) ;
        this.scanner=new Scanner(System.in) ;
    }

    /*console will start here when we call to do actions with position table*/
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all positions");
            System.out.println("2. Get position by id");
            System.out.println("3. Create position");
            System.out.println("4. Get salary by position id");
            System.out.println("5. Get count of salary by position id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllPositionsMenu();
                } else if (option == 2) {
                    getPositionByIdMenu();
                } else if (option == 3) {
                    createPositionMenu();
                } else if (option == 4) {
                    getPositionSalaryByIdMenu();

                } else if (option == 5) {
                    getSumOfSalaryById();

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

    public void getAllPositionsMenu(){
        String response = controller.getAllPositions();
        System.out.println(response);
    }

    public void getPositionByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getPosition(id);
        System.out.println(response);
    }

    public void createPositionMenu() {
        System.out.println("Please enter name of position");
        String description = scanner.next();
        System.out.println("Please enter salary ");
        int salary  = scanner.nextInt();

        String response = controller.createPosition(description, salary);
        System.out.println(response);
    }

    public void getPositionSalaryByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getPosition(id);
        System.out.println(response);
    }
    private void getSumOfSalaryById() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getAllPositions();
        System.out.println(response);
    }
}
