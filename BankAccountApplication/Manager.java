/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mbverdaw
 */
public class Manager extends User {
    
    public static ArrayList<Customer> customers=new ArrayList<Customer>();
    
    public Manager(){
        super("Manager", "admin", "admin");
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/student1/mbverdaw/COE528/Project/BankAccountApplication/src/bankaccountapplication/customer_credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    int accountNumber = Integer.parseInt(parts[2].trim());
                    double balance = Double.parseDouble(parts[3].trim());
                    boolean exists = false;
                    for (Customer c : customers) {
                        if (c.getUsername().equals(username)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        Customer customer = new Customer(username, password, accountNumber);
                        customer.getBankAcc().withdraw(100);
                        customer.getBankAcc().deposit(balance);
                        customers.add(customer);
                    }
                }
            }
        }catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
    
    public boolean login(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            return true;
        }else{
            return false;
        }
    }
    
    public void addCustomer(String username, String password) throws Exception{
        for (Customer ele:this.customers){
            if (ele.getUsername().equals(username)){
                throw new Exception();
            }
        }
        customers.add(new Customer(username, password, customers.size()+1));
       
        writeCustomerCredentials();
    }
    
    public void deleteCustomer(String username){
        Customer customerToRemove = null;
        for (Customer ele : customers){
            if (ele.getUsername().equals(username)){
                customerToRemove = ele;
                break; // Exit the loop once the customer is found
            }            
        }

        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            writeCustomerCredentials();
        }
    }
    
    public void writeCustomerCredentials() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("/home/student1/mbverdaw/COE528/Project/BankAccountApplication/src/bankaccountapplication/customer_credentials.txt"))) {
            for (Customer customer : customers) {
                String line = customer.getUsername() + "," + customer.getPass() + "," +
                        customer.getBankAcc().getAccNum() + "," + customer.getBankAcc().getBalance();
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
