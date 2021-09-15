package com.example.vendingmachine.models.payment.notes;


import com.example.vendingmachine.models.payment.Cash;
import com.example.vendingmachine.models.payment.IMoney;

public class Notes extends Cash implements IMoney {

    private final String currency = "USD";

    public Notes(NotesValues value) {
       super.setValue(value.getValue());
        super.setCurrency("USD");
        super.EnumValue = value.toString();

    }


}