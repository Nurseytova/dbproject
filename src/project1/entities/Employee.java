package project1.entities;

/*entity of employee*/
public class Employee {
    /*attributes of employee*/
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int position_id;

    /*no-arg constructor */
    public Employee() {
    }
    /*parametrized constructor*/
    public Employee(String name, String surname, boolean gender, int position_id) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPosition_id(position_id);
    }
    /*parametrized constructor with id*/
    public Employee(int id, String name, String surname, boolean gender, int position_id) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPosition_id(position_id);
    }

    /*getters and setters*/
    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /*outputting info*/
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (gender ? "Male" : "Female") +
                ", position="+position_id+
                '}';
    }
}
