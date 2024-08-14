package model;

import model.enums.Bank;

public class Card {
    private static long counterId = 1;
    private long id;
    private Bank bank;
    private int pin;
    private long cardNumber;
    public String cardDate;
    public String user;

    public Card(Bank bank, int pin, long cardNumber, String cardDate, String user) {
        this.id = counterId++;
        this.bank = bank;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
