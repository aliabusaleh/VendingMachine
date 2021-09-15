package com.example.vendingmachine.service.payment;

import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.cards.Cards;
import com.example.vendingmachine.models.payment.coins.Coins;

public class CardPayment implements Payment{

    @Override
    public boolean Validate(IMoney money) {
        return ((Cards)money).Validate();

    }
}
