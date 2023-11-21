/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author mbverdaw
 */
public class Components {
    
    public double value;
    public int id;
    public char type;
    public static int Rcounter=1;
    public static int Vcounter=1;
    public int node1;
    public int node2;
    public boolean validity=true;
    
    public Components(String[] cmdArr){
        if (cmdArr[0].toLowerCase().equals("r")){
            this.type='r';
        }
        else if (cmdArr[0].toLowerCase().equals("v")){
            this.type='v';
        }
        else validity=false;
        
        int inputCounter=0;
        
        for (String ele:cmdArr){
            if (ele.equals("") || ele.equals("v") || ele.equals("r")) continue;
            else{
                switch (inputCounter){
                    case 0:
                        try{
                            this.node1= Integer.parseInt(ele);
                            if (this.node1>0){
                                inputCounter++;
                            }
                            else{
                                validity=false;
                            }
                            break;
                        }
                        catch(NumberFormatException e){
                            validity=false;
                        }
                    case 1:
                        try{
                            this.node2= Integer.parseInt(ele);
                            if (this.node2>0){
                                inputCounter++;
                            }
                            else{
                                validity=false;
                            }
                            break;
                        }
                        catch(NumberFormatException e){
                            validity=false;
                        }
                    case 2:
                        try{
                            this.value= Double.parseDouble(ele);
                            if ((this.value>0 && this.type=='r')|| this.type=='v'){
                                inputCounter++;
                            }
                            else{
                                validity=false;
                            }
                            break;
                        }
                        catch(NumberFormatException e){
                            validity=false;
                        }
                    default:
                        validity=false;           
                }
            }
        }
        if (validity){
            if (type=='r'){
                id=Rcounter;
                Rcounter++;
            }
            else{
                id=Vcounter;
                Vcounter++;
            }
        }
        else{
            System.out.println("Invalid Input.. Please try again");
        }
    }
    
    public String displayComponent(){
        if (type=='r'){
            return ("R"+this.id+" "+this.node1+" "+this.node2+" "+this.value+" Ohms");
        } 
        else{
            return ("V"+this.id+" "+this.node1+" "+this.node2+" DC "+this.value+" Volts");
        }
    }
    
    public void checkPolarity(){
        if (this.value!=Math.abs(this.value)){
            this.value=Math.abs(this.value);
            int temp=this.node1;
            this.node1=this.node2;
            this.node2=temp;
        }
    }
}
