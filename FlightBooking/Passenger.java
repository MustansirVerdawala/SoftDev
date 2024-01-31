/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author mbverdaw
 */
public abstract class Passenger {
    protected String name;
    protected int age;
    
    public Passenger(String name, int age){
        this.name=name;
        this.age=age;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    protected abstract double applyDiscount(double p);
}
