/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author mbverdaw
 */
public class NonMember extends Passenger {
    
    public NonMember(String name, int age){
        super(name, age);
    }
    
    @Override
    protected double applyDiscount(double p){
        if (this.age>65){
            return p*0.9;
        }
        return p;
    }
    
}
