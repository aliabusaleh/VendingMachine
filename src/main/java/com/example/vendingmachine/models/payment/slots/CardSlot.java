package com.example.vendingmachine.models.payment.slots;


import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.cards.Cards;
import com.example.vendingmachine.models.payment.coins.Coins;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.service.payment.CardPayment;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CardSlot extends Cards implements ISlot{


    CardPayment payment;
    public CardSlot(){
        super(0,"",0);
        payment = new CardPayment();

    }
    public CardSlot(int ID, String cardHolderName, int ccv2) {
        super(ID, cardHolderName, ccv2);
        payment = new CardPayment();
    }

    @Override
    public IMoney insert(IMoney money) {
        if(payment.Validate(money))
            return new Cards(((Cards)money).getID(),((Cards)money).getCardHolderName(),((Cards)money).getCvv2());
        else{
            System.out.println("invalid Card");
            return null;
        }
    }

}
