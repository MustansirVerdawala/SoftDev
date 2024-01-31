/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author mbverdaw
 */
public class Manager {
    private ArrayList<Flight> flights=new ArrayList<>();
    
    private ArrayList<Ticket> tickets=new ArrayList<>();
    
    public void createFlights(){
        Scanner scanner=new Scanner(System.in);
        String response="n";
        do{
           System.out.println("Enter the flight number: ");
           int flightNumber=Integer.parseInt(scanner.nextLine());
           System.out.println("Enter the flight's origin: ");
           String origin=scanner.nextLine();
           System.out.println("Enter the flight's destination: ");
           String destination=scanner.nextLine();
           System.out.println("Enter the flight's departure time: ");
           String departureTime=scanner.nextLine();
           System.out.println("Enter the flight's capacity: ");
           int capacity=Integer.parseInt(scanner.nextLine());
           System.out.println("Enter the flight's ticket price: ");
           double price=Double.parseDouble(scanner.nextLine());
           
           try{
               Flight flight=new Flight(flightNumber, origin, destination, departureTime, capacity, price);
               flights.add(flight);
               System.out.println(flight);
           }
           catch (IllegalArgumentException e){
               System.out.println("Origin and Destination can't be the same");
           }
           
           System.out.println("\nDo you want to add more flights (y/n)? ");
           response=scanner.nextLine();
        }while(response.equals("y"));
    }
    
    public void displayAvailableFlights(String origin, String destination){
        for (Flight flight: flights){
            if (origin.equals(flight.getOrigin()) && destination.equals(flight.getDestination()) && 
                    flight.getNumberOfSeatsLeft()>0){
                System.out.println(flight);
            }
        }
    }
    
    public Flight getFlight(int flightNumber){
        for (Flight flight:flights){
            if (flightNumber==flight.getFlightNumber()){
                return flight;
            }
        }
        System.out.println("No such flight exists");
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        boolean flag0=false;
        for (Flight flight:flights){
            if (flight.getFlightNumber()==flightNumber){
                flag0=true;
                if (flight.bookASeat()){
                    Ticket ticket=new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice()));
                    System.out.println(ticket);
                    tickets.add(ticket);
                    break;
                }
                else{
                    System.out.println("No more seats available");
                    break;
                }
            }
        }
        if (!flag0){
            System.out.println("No such flight found in database");
        }
    }
    
    public static void main(String[] args){
        Manager manager=new Manager();
        
        manager.createFlights();
        manager.displayAvailableFlights("Toronto","New York");
        System.out.println(manager.getFlight(66));
        Passenger passenger=new Member("James Bond", 19, 7);
        manager.bookSeat(1010, passenger);
        passenger=new NonMember("Anakin Skywalker",70);
        manager.bookSeat(66,passenger);
        passenger=new NonMember("Bruce Wayne",35);
        manager.bookSeat(66, passenger);
    }   
}