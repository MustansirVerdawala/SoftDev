/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author mbverdaw
 */
public class LinkedDigitCounter extends AbstractCounter {
    
    private Counter leftNeighbour;
    
    public LinkedDigitCounter(Counter leftNeighbour){
        super();
        this.leftNeighbour=leftNeighbour;
    }
    
    @Override
    public void increment(){
        if (value<9){
            value=value+1;
        }else{
            value=0;
            leftNeighbour.increment();
        }
    }
    
    @Override
    public void decrement(){
        if (value>0){
            value=value-1;
        }else{
            value=9;
            leftNeighbour.decrement();
        }
    }
    
    @Override
    public void reset(){
        value=0;
        leftNeighbour.reset();
    }
    
    @Override
    public String count(){
        return leftNeighbour.count() +String.valueOf(value);
    }
    
}
