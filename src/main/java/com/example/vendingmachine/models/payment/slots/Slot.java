package com.example.vendingmachine.models.payment.slots;

public class Slot  {
    private double total = 0.0f;


    public Slot(double total) {
        this.total = total;
    }

    public double getTotal() {
        System.out.println("Now Entered slot money is "+total/10);
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addMoney(double value){
        if(value > 0.0){
            total += value;
        }
    }
}
