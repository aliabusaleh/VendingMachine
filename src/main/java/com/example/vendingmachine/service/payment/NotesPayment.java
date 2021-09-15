package com.example.vendingmachine.service.payment;

import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.notes.Notes;

public class NotesPayment implements Payment{

    @Override
    public boolean Validate(IMoney money) {
        if(money.getClass() == Notes.class && ((Notes) money).getCurrency() == "USD")
            return true;
        return false;
    }
}
