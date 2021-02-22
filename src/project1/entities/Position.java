package project1.entities;

/*entity of employee*/
public class Position {
    /*attributes of position*/
    private int id ;
    private int salary;
    private String description ;

    /*no-arg constructor*/
    public Position(){

    }
    /*parametrized constructor*/
    public Position(String description, int salary){
        setDescription(description);
        setSalary(salary);
    }

    /*parametrized constructor with id*/
    public Position(int id ,String description, int salary ){
        setDescription(description);
        setSalary(salary);
        setId(id);
    }
    /*getters and setters*/
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /*outputting info*/
    @Override
    public String toString(){
        return "Position ID : " + getId() + " Position description : " + getDescription() + " Position salary : " + getSalary();
    }
}
