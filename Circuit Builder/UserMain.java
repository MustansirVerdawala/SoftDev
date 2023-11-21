/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author mbverdaw
 */
public class UserMain {
    
    public static void main(String[] args){
        
        ArrayList<Components> Comp=new ArrayList();
        
        Scanner scan=new Scanner(System.in);
        
        boolean iter= true;
        
        do{
            System.out.println("\nEnter Command: ");
            String cmd= scan.nextLine();
            
            if (cmd.trim().toLowerCase().equals("end")){
                iter=false;
            }
            else{

                if (cmd.trim().toLowerCase().equals("spice")){
                    for (Components ele:Comp){
                        ele.checkPolarity();
                        System.out.println(ele.displayComponent());
                    }
                }
                else{
                    String[] cmdArr=cmd.split(" ");
                    
                    if (cmdArr[0].toLowerCase().equals("r") || cmdArr[0].toLowerCase().equals("v")){
                        Components tempComp=new Components(cmdArr);
                        if (tempComp.validity){
                            Comp.add(tempComp);
                        }
                    }
                    else{
                        System.out.println("Invalid Input...Please try again...");
                    }
                }
            }
        }
        while (iter);
        
        System.out.println("\nAll Done");
        
    }
    
}
