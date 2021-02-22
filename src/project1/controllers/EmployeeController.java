package project1.controllers;

import java.util.List;

import project1.entities.Employee;
import project1.repositories.interfaces.IEmployeeRepository;

/*class where return comments that something is accessed or failed  */
public class EmployeeController {
    /*calling repository where we create position in db*/
    private final IEmployeeRepository repo;

   /* constructor*/
    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    /*comment after actions*/
    /*when creating employee*/
    public String createEmployee(String name, String surname, String gender, int position_id) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname, male, position_id);

        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    /*getting employee by id*/
    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }
    /*outputting all employees*/
    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();

        return employees.toString();
    }

}
