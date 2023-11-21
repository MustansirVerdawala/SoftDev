/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author mbverdaw
 */
public class Account {
    public String Name;
    public double bal;
    public int num;
    
    public Account(String name, int number, double initialBalance){
        Name=name;
        bal=initialBalance;
        num=number;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public double getBalance(){
        return this.bal;
    }
    
    public int getNumber(){
        return this.num;
    }
    
    public boolean deposit(double amount){
        if (amount>0){
            this.bal+=amount;
            return true;
        }
        else{
            System.out.println("\nIncorrect input...\nCan only input a positive value");
            return false;
        }
    }
    
    public boolean withdraw(double amount){
        if (amount>0){
            if (amount<=this.bal){
                this.bal-=amount;
                return true;
            }
            else{
                System.out.println("\nIncorrect input...\nWithdrawal amount exceeds balance");
                return false;
            }
        }
        else{
            System.out.println("\nIncorrect input...\nCan only input a positive value");
            return false;
        }
    }
    
    @Override
    public String toString() {//DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +String.format("$%.2f", getBalance()) + ")";
    }
    
}
