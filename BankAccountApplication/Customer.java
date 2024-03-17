/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountapplication;

/**
 *
 * @author mbverdaw
 */
public class Customer extends User{

    private String level;
    private BankAccount bankAcc;
    
    public Customer(String username, String password, int bankAccNum){
        super("Customer", username, password);
        this.bankAcc= new BankAccount(bankAccNum);
    }
    
    public boolean login(String user, String pass){
        if (this.username.equals(user) && this.password.equals(pass)){
            return true;
        }else{
            return false;
        }
    }
    
    private void setUsername(String username){
        this.username=username;
    }
    
    private void setPassword(String password){
        this.password=password;
    }
    
    public void setBankAcc(BankAccount bankacc){
        this.bankAcc=bankacc;
    }
    
    public BankAccount getBankAcc(){
        return this.bankAcc;
    }

    public void setLevel(){
        if (this.bankAcc.getBalance()<20000){
            if (this.bankAcc.getBalance()<10000){
                this.level="Silver";
            }else{
                this.level="Gold";
            }
        }else{
            this.level="Platinum";
        }
    }
    
    public String getLevel(){
        return this.level;
    }
    
    public double calcFee(){
        if (this.level.equals("Silver")){
            return 20;
        }else if (this.level.equals("Gold")){
            return 10;
        }else{
            return 0;
        }
    }
    
}
