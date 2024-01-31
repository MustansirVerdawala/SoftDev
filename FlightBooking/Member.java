/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author mbverdaw
 */
public class Member extends Passenger {
    
    private int yearsOfMembership;
    
    public Member(String name ,int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership=yearsOfMembership;
    }
    
    public void setYearsOfMembership(int yearsOfMembership){
        this.yearsOfMembership=yearsOfMembership;
    }
    
    public int getYearsOfMembership(){
        return this.yearsOfMembership;
    }
    
    @Override
    protected double applyDiscount(double p){
        if (this.yearsOfMembership>1){
            if (this.yearsOfMembership>5){
                return p*0.5;
            }
            else{
                return p*0.9;
            }
        }
        else{
            return p;
        }
    }
    
}
