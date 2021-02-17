package com.company;

import com.company.controllers.TrainController;
import com.company.controllers.UserController;
import com.company.entities.Train;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.Scanner;

public class TrainFrontend {
    private final TrainController controller;
    private final Scanner scanner;

    public TrainFrontend(ITrainRepository repo){
        this.controller=new TrainController(repo) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Get capacity by train id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if (option == 4) {
                    getTrainCapacityByIdMenu();

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

    public void getAllTrainsMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTrain(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter number");
        String number = scanner.next();
        System.out.println("Please enter capacity ");
        int capacity  = scanner.nextInt();

        String response = controller.createTrain(name, number, capacity);
        System.out.println(response);
    }

    public void getTrainCapacityByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTrain(id);
        System.out.println(response);
    }

}


