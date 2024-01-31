/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author mbverdaw
 */
public class Ticket {
    public static int count=1;
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    
    public Ticket(Passenger p, Flight flight, double price){
        this.passenger=p;
        this.flight=flight;
        this.price=price;
        this.number=count;
        count++;
    }
    
    public void setPassenger(Passenger p){
        this.passenger=p;
    }
    
    public void setFlight(Flight flight){
        this.flight=flight;
    }
    
    public void setPrice(double price){
        this.price=price;
    }
    
    public Passenger getPassenger(){
        return this.passenger;
    }
    
    public Flight getFlight(){
        return this.flight;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    @Override
    public String toString(){
        return (this.passenger.name+", "+this.flight.toString()+", ticket price: $"+this.price);
    }
}
