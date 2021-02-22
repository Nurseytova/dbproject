package project1.repositories.interfaces;

import project1.entities.Employee;
import project1.entities.Position;

import java.util.List;

/*methods of employee object*/
public interface IEmployeeRepository {
     boolean createEmployee(Employee employee);
     Employee getEmployee(int id);
     List<Employee> getAllEmployees();
}
