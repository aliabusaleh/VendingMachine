package com.example.vendingmachine.models.payment.cards;


import com.example.vendingmachine.models.payment.IMoney;

public class Cards implements IMoney {

    private final CardsAccepted cardType;
    private int ID;
    private String CardHolderName;
    private int cvv2;
    private double Balance =0;
    public Cards(int ID, String cardHolderName,int ccv2) {
        this.ID = ID;
        CardHolderName = cardHolderName;
        this.cvv2= ccv2;
        //need to check type from the ID
        this.cardType = CardsAccepted.DEBIET_CARD;
        //validate it's working and have money
        Validate();
    }

    public boolean Validate() {
        //check ID, Name, Date, Balance .... etc
        System.out.println("Valid Card ");

        //hard coded balance
        this.Balance = 1000;
        return true;
    }
    public boolean WithdrewMoney(double value){
        if(Balance >= value){
            Balance -= value;
            System.out.println("Paid with Card, withdraw money of "+value+"$, Balance Now is "+Balance+"$.");
            return true;
        }
        else{
            //should have custom exception .. abort process
            System.out.println("insufficient Balance.. Please enter different card");
        return false;
        }
    }

    @Override
    public double getValue() {
        return 0;
    }

    public CardsAccepted getCardType() {
        return cardType;
    }

    public int getID() {
        return ID;
    }

    public String getCardHolderName() {
        return CardHolderName;
    }

    public int getCvv2() {
        return cvv2;
    }

    public double getBalance() {
        return Balance;
    }
}
