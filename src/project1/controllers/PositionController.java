package project1.controllers;

import project1.entities.Position;
import project1.repositories.interfaces.IPositionRepository;

import java.util.List;

/*class where return comments that something is accessed or failed  */
public class PositionController {
    /*calling repository where we create position in db*/
    private final IPositionRepository repo;

    /*constructor with repository parameter*/
    public PositionController(IPositionRepository repo) {
        this.repo = repo;
    }

/*comment after actions*/
    /*for creating position*/
    public String createPosition(String description, int salary) {

        Position position = new Position(description, salary);

        boolean created = repo.createPosition(position);

        return (created ? "Position was created!" : "Position creation was failed!");
    }
    /*getting position by id*/
    public String getPosition(int id) {
        Position position = repo.getPosition(id);

        return (position == null ? "Position was not found!" : position.toString());
    }
/*outputting all positions*/
    public String getAllPositions() {
        List<Position> positions = repo.getAllPositions();
        return positions.toString();
    }

    public String getSalary(int id) {
        int salary = repo.getSalaryById(id);
        return (salary == -1 ? "Position was not found!" : String.valueOf(salary));
    }
}
