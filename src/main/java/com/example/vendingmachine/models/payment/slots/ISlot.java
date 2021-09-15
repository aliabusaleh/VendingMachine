package com.example.vendingmachine.models.payment.slots;


import com.example.vendingmachine.models.payment.IMoney;

public interface ISlot {

    IMoney insert(IMoney money);
}
