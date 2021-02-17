package com.company.entities;

public class Train {
    private int id ;
    private String name ;
    private String number ;
    private int capacity ;

    public Train(){

    }
    //constructor
    public Train(String name , String number, int capacity ){
        setName(name);
        setNumber(number);
        setCapacity(capacity);
    }

    public Train(int id ,String name , String number, int capacity ){
        setCapacity(capacity);
        setName(name);
        setNumber(number);
        setId(id);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString(){
        return "Train ID : " + getId() + " Train name : " + getName() + " Train number : " + getNumber()+ " Train capacity : "
                +getCapacity() ;
    }
}
