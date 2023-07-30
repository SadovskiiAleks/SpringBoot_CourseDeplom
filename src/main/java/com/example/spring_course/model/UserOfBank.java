package com.example.spring_course.model;

public class UserOfBank {

    private long cardNumber = 0;
    private int validTillMonth = 0;
    private int validTillYear = 0;
    private int CVV = 0;

    private long havMoney = 0;

    private int verificationCode;

    public UserOfBank(long cardNumber, int validTillMonth, int validTillYear, int CVV, long havMoney, int verificationCode) {
        this.cardNumber = cardNumber;
        this.validTillMonth = validTillMonth;
        this.validTillYear = validTillYear;
        this.CVV = CVV;
        this.havMoney = havMoney;
        this.verificationCode = verificationCode;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getCVV() {
        return this.CVV;
    }

    ;

    public int getValidTillMonth() {
        return this.validTillMonth;
    }

    ;

    public int getValidTillYear() {
        return this.validTillYear;
    }

    ;

    public int getVerificationCode() {
        return this.verificationCode;
    }

    public boolean userHaveMoney(long money) {
        return havMoney >= money ? true : false;
    }

    public void addMoneyToUser(long money) {
        havMoney += money;
    }

    public boolean takeMoneyFromUser(long money) {
        if (userHaveMoney(money)) {
            havMoney -= money;
            return true;
        }
        return false;
    }
}
