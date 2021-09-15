package com.example.vendingmachine;

import com.example.vendingmachine.models.payment.cards.Cards;
import com.example.vendingmachine.models.payment.coins.Coins;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.models.payment.notes.Notes;
import com.example.vendingmachine.models.payment.notes.NotesValues;
import com.example.vendingmachine.models.snacks.SnacksSupported;
import com.example.vendingmachine.service.vending.VendingMachine;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;



public class VendingMachineTest {

    /**
     * Needed more time for the testing to cover all the logic,:\
     *
     * */
    @Test
    void BuyLastSnackWithExtraNotes(){
        VendingMachine  vendingMachine = new VendingMachine();
        vendingMachine.EnterKeypad(SnacksSupported.values()[SnacksSupported.values().length-1].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));

        Assertions.assertEquals("4",vendingMachine.getSnacks().get(SnacksSupported.values()[SnacksSupported.values().length-1].name()).toString());

        Assertions.assertEquals(4,vendingMachine.getKeypad());
        Assertions.assertEquals(600,vendingMachine.getUserslot().getTotal());
        Assertions.assertEquals(420,vendingMachine.getUserSnackPrice());
        Assertions.assertEquals(18,vendingMachine.getReturnedMoney()/10);

        vendingMachine.EnterKeypad(SnacksSupported.values()[SnacksSupported.values().length-1].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getNotesSlot().insert(new Notes(NotesValues.TWENTY_DOLLER)));

        Assertions.assertEquals("3",vendingMachine.getSnacks().get(SnacksSupported.values()[SnacksSupported.values().length-1].name()).toString());

        Assertions.assertEquals(4,vendingMachine.getKeypad());
        Assertions.assertEquals(600,vendingMachine.getUserslot().getTotal());
        Assertions.assertEquals(420,vendingMachine.getUserSnackPrice());
        Assertions.assertEquals(18,vendingMachine.getReturnedMoney()/10);

    }


    @Test
    void BuyFirstSnackExactMoneyUsingCoins(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.EnterKeypad(SnacksSupported.values()[0].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.FIFTY_CENT)));
        Assertions.assertEquals( 0.00f,vendingMachine.getReturnedMoney() );
    }

    @Test
    void BuyFirstSnackExtraMoneyUsingCoinsReturnRemining(){
        VendingMachine  vendingMachine = new VendingMachine();
        vendingMachine.EnterKeypad(SnacksSupported.values()[0].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.ONE_DOLLER)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.TEN_CENT)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.TWENTY_CENT)));
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.FIFTY_CENT)));

        Assertions.assertEquals("4",vendingMachine.getSnacks().get(SnacksSupported.values()[0].name()).toString());

        Assertions.assertEquals(0.3,vendingMachine.getReturnedMoney()/10);
    }

    @Test
    void BuySecondSnackWithCard(){
        VendingMachine  vendingMachine = new VendingMachine();
        vendingMachine.EnterKeypad(SnacksSupported.values()[1].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getCardSlot().insert(new Cards(1234,"Ali Abu Saleh",132)));
        Assertions.assertEquals(0,vendingMachine.getReturnedMoney()/10);

       // Assertions.assertEquals(0.3,vendingMachine.getReturnedMoney()/10);
    }

    @Test
    void BuySecondSnackWithCardAndCoins(){
        VendingMachine  vendingMachine = new VendingMachine();
        vendingMachine.EnterKeypad(SnacksSupported.values()[1].ordinal());
        vendingMachine.EnterMoney(vendingMachine.getCoinSlot().insert(new Coins(CoinsValues.TWENTY_CENT)));
        vendingMachine.EnterMoney(new Cards(1234,"Ali Abu Saleh",132));


        Assertions.assertEquals(1,vendingMachine.getKeypad());
        Assertions.assertEquals(2,vendingMachine.getUserslot().getTotal());
        Assertions.assertEquals(100,vendingMachine.getUserSnackPrice());
        Assertions.assertEquals(0,vendingMachine.getReturnedMoney()/10);

        // Assertions.assertEquals(0.3,vendingMachine.getReturnedMoney()/10);
    }

}