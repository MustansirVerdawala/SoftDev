/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccountapplication;

/**
 *
 * @author mbverdaw
 */
public abstract class User {
    protected String role;
    protected String username;
    protected String password;
    
    protected User(String role, String username, String password){
        this.role=role;
        this.username=username;
        this.password=password;
    }
    
    public String getRole(){
        return this.role;
    }
    
    protected String getUsername(){
        return this.username;
    }
    
    protected String getPass(){
        return this.password;
    }
    
    abstract protected boolean login(String username, String password);
    
}
