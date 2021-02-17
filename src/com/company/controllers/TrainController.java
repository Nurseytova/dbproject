package com.company.controllers;

import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ITrainRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class TrainController {
    //ITrainRepository- interface
    private final ITrainRepository repo;

    // constructor
    public TrainController(ITrainRepository repo) {
        this.repo = repo;
    }

    public String createTrain(String name, String number, int capacity) {

        Train train = new Train(name, number , capacity);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = repo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();
        return trains.toString();
    }

    public String getCapacity(int id) {
        int capacity = repo.getCapacityById(id);

        return (capacity == -1 ? "Train was not found!" : String.valueOf(capacity));
    }
}
