/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;
import java.util.ArrayList;

/**
 *
 * @author mbverdaw
 */
public class Odometer implements Counter {
    DigitCounter dc;
    ArrayList<Counter> ldc=new ArrayList();
    int n;
    public Odometer(int n){
        if (n<1){
            throw new IllegalArgumentException("\n n must be greater than 1");
        }else{
            this.n=n;
            dc=new DigitCounter();
            ldc.add(new LinkedDigitCounter(dc));
            for (int i=0; i<n-1; i++){
                ldc.add(new LinkedDigitCounter(ldc.get(i)));
            }
        }
    }
    
    @Override
    public void increment(){
        ldc.get(n-2).increment();
    }
    
    @Override
    public void decrement(){
        ldc.get(n-2).decrement();
    }
    
    @Override
    public void reset(){
        ldc.get(n-2).reset();
    }
    
    @Override
    public String count(){
        return ldc.get(n-2).count();
    }
}
