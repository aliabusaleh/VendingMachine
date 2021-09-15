package com.example.vendingmachine;

import com.example.vendingmachine.models.payment.coins.Coins;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.models.payment.slots.CoinSlot;
import com.example.vendingmachine.service.payment.CoinsPayment;
import com.example.vendingmachine.service.vending.VendingMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class VendingMachineApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendingMachineApplication.class, args);
        Scanner scan = new Scanner(System.in);
        System.out.println("please Choose type 0, because the main code is hardcoded money");
        VendingMachine machine = new VendingMachine();
        machine.PrintStock();
        while(!machine.EnterKeypad(scan.nextInt()));

        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        machine.EnterMoney(machine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));


    }

}
