package com.example.vendingmachine.models.payment.slots;


import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.coins.Coins;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.models.payment.notes.Notes;
import com.example.vendingmachine.models.payment.notes.NotesValues;
import com.example.vendingmachine.service.payment.CoinsPayment;
import com.example.vendingmachine.service.payment.NotesPayment;

public class NotesSlot implements ISlot{


    NotesPayment payment;


    public NotesSlot() {
        payment = new NotesPayment();

    }

    @Override
    public IMoney insert(IMoney money) {
        if(payment.Validate(money))
            return new Notes(NotesValues.valueOf(((Notes)money).getEnumValue()));
        else{
            System.out.println("invalid Coin");
            return null;
        }
    }

}
