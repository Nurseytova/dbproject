package project1.repositories.interfaces;

import project1.entities.Position;

import java.util.ArrayList;
import java.util.List;

/*methods of position object*/
public interface IPositionRepository {
    boolean createPosition(Position position);
    Position getPosition(int id);
    List<Position> getAllPositions();
    int getSalaryById(int id);
    int getSumOfSalaryById(int id);
}
