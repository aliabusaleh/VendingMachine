package com.example.vendingmachine.service.payment;


import com.example.vendingmachine.models.payment.IMoney;

import java.util.List;

public interface Payment {

    boolean Validate(IMoney money);
}
