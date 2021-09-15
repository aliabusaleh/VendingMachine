package com.example.vendingmachine.service.vending;

import com.example.vendingmachine.models.payment.Cash;
import com.example.vendingmachine.models.payment.IMoney;
import com.example.vendingmachine.models.payment.cards.Cards;
import com.example.vendingmachine.models.payment.coins.CoinsValues;
import com.example.vendingmachine.models.payment.notes.NotesValues;
import com.example.vendingmachine.models.payment.slots.CardSlot;
import com.example.vendingmachine.models.payment.slots.CoinSlot;
import com.example.vendingmachine.models.payment.slots.NotesSlot;
import com.example.vendingmachine.models.payment.slots.Slot;
import com.example.vendingmachine.models.snacks.SnacksSupported;



import java.util.*;

public class VendingMachine  {

    //saving how many notes, coins in the system
    private HashMap<String, Integer> CashSlot;
    //for inserting card and cash, check enter money function
    private List<IMoney> money;
    //enter money from user into the slot
    private Slot userslot;

    CoinSlot coinSlot;
    NotesSlot notesSlot;
    CardSlot cardSlot;

    //enter User KeyPad
    private int keypad =0;

    private double userSnackPrice = 0.0;

    private double returnedMoney= 0.0;

    private double remainingMoney;

    private HashMap<String,Integer> snacks;

    public VendingMachine() {
        CashSlot = new HashMap<>();
        snacks = new HashMap<>();
        userslot = new Slot(0.0);
        money = new ArrayList<IMoney>();
        coinSlot = new CoinSlot();
        notesSlot = new NotesSlot();
        cardSlot = new CardSlot();
        Init();
    }

    private void Init() {
        InitiSnacks();
        InitMoney();
    }


    private void InitiSnacks() {
        //5 snack of each type as initial values
        Arrays.stream(SnacksSupported.values()).forEach(snacksSupported -> snacks.put(snacksSupported.toString(),5));
    }

    private void InitMoney() {
        //each cash type, has 100 coins/notes as init value
        Arrays.stream(CoinsValues.values()).forEach(coinsValues -> CashSlot.put(coinsValues.toString(),100));
        Arrays.stream(NotesValues.values()).forEach(notesValues -> CashSlot.put(notesValues.toString(),100));

    }

    public CoinSlot getCoinSlot() {
        return coinSlot;
    }

    public NotesSlot getNotesSlot() {
        return notesSlot;
    }

    public CardSlot getCardSlot() {
        return cardSlot;
    }

    public void PrintStock(){
        System.out.println("**** Available\t| Snacks \t\t\t| Prices  \t| Available Stock \t| Snack Key ****");
        for (Map.Entry<String,Integer> entry : snacks.entrySet()) {
            System.out.println("Snack -->  \t\t| "+entry.getKey()+ "\t\t| "+
                    SnacksSupported.valueOf(entry.getKey()).getValue() +"\t\t | " + entry.getValue().toString()
                    +"\t\t\t\t|"+SnacksSupported.valueOf(entry.getKey()).ordinal());
        }
        System.out.println("Please Enter Enter the Snack Key: ");
    }
    public boolean EnterKeypad(int value){
        if(value > SnacksSupported.values().length){
            //need custom exceptions
            System.out.println("Invalid Snack key");
            return false;
        }
        else{
        keypad = value;
        userslot.setTotal(0.0);
        if(snacks.get(SnacksSupported.values()[keypad].name()) > 0) {
            userSnackPrice = SnacksSupported.values()[keypad].getValue() * 10;
            System.out.println("Snack "+SnacksSupported.values()[keypad]+", price is " + userSnackPrice/10);
            System.out.println("Please Add money, or Enter Card");
        }
        else
            {
                //should have custom exception
                System.out.println("Not available in the stock, please try again");
            }
        return true;
        }
    }

    public void EnterMoney(IMoney money){

        if(money.getClass()== Cards.class){
            if(!this.money.isEmpty()) {
                //must return money for user and uses Only the Card
                System.out.println("Will handle back the cash, and use only the Card");
                returnMoney();
                return;
            }
            else {
                // TODO: 9/4/2021 pay with card
                ((Cards) money).WithdrewMoney(userSnackPrice);
                userslot.setTotal(userSnackPrice);
                CompletePurchase();
                return;
            }
        }
        userslot.addMoney(money.getValue());
        int tempCashCounter = CashSlot.get(((Cash) money).getEnumValue());
        //add to the system the coin ( bank)
        CashSlot.put(((Cash)money).getEnumValue(),++tempCashCounter);
        //check if we got >= snack price
        if(userslot.getTotal() >= userSnackPrice){
            CompletePurchase();
        }
        
    }

    private double returnMoney() {
        returnedMoney = 0.0;
        Map<String, Integer> sortedMap = new TreeMap<>((o1, o2) -> {
           if(MoneyValue(o1) - MoneyValue(o2) > 0.0){
               return -1;
           }
           else if(MoneyValue(o1) - MoneyValue(o2) == 0.0){
               return 0;
           }
           else {
               return 1;
           }
        });

        sortedMap.putAll(CashSlot);
        System.out.println("we need to return "+ remainingMoney/10);
        if (remainingMoney == 0) return 0.0;
        while (remainingMoney > 0) {
            sortedMap.keySet().stream().filter((s) -> MoneyValue(s) <= remainingMoney ).forEach((s) -> {
                for(int i=0 ; i <= remainingMoney/MoneyValue(s); i++) {
                    int temp = sortedMap.get(s);
                    remainingMoney -= MoneyValue(s);
                    sortedMap.put(s, --temp);
                    returnedMoney += MoneyValue(s);
                    System.out.println("Returning --> " + MoneyValue(s)/10 + " , remaining " + remainingMoney/10);
                    i=0;
                }
            });
        }
        return returnedMoney;

    }

    private void PrintBank(){
        for(Map.Entry<String, Integer> entry : CashSlot.entrySet()) {
            System.out.println("Cash: "+ entry.getKey()+", Cash Value: " +MoneyValue(entry.getKey()) +", Cash Count: "+ entry.getValue());

        }
    }

    private void CompletePurchase(){
        //current stock
        int stock = Integer.parseInt(snacks.get(SnacksSupported.values()[keypad].name()).toString());
        //remove item from stock
        snacks.put(SnacksSupported.values()[keypad].name(),(--stock));


        System.out.println("drop the snack into the machine slot so the client will take it.");

        // calculate remaining money to user;
        remainingMoney = userslot.getTotal() - userSnackPrice;

      // TODO: 9/4/2021 return money
        returnMoney();

    }
    private double MoneyValue(String money){
        try {
            return CoinsValues.valueOf(money).getValue();
        }
        catch (IllegalArgumentException E){
            return NotesValues.valueOf(money).getValue();
        }

    }

    public double getReturnedMoney() {
        return returnedMoney;
    }

    public Slot getUserslot() {
        return userslot;
    }

    public int getKeypad() {
        return keypad;
    }

    public double getUserSnackPrice() {
        return userSnackPrice;
    }

    public double getRemainingMoney() {
        return remainingMoney;
    }

    public HashMap<String, Integer> getCashSlot() {
        return CashSlot;
    }

    public HashMap<String, Integer> getSnacks() {
        return snacks;
    }
}
