package com.example.vendingmachine.models.payment.slots;


import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.coins.Coins;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.service.payment.CoinsPayment;

public class CoinSlot implements ISlot{

    CoinsPayment payment;

    public CoinSlot() {
        payment = new CoinsPayment();
    }

    @Override
    public IMoney insert(IMoney money) {
    if(payment.Validate(money))
    return new Coins(CoinsValues.valueOf(((Coins)money).getEnumValue()));
    else{
            System.out.println("invalid Coin");
            return null;
        }
    }

}
