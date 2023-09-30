package com.example.spring_course.model;

import java.math.BigDecimal;

public class UserOfBank {

    private long cardNumber = 0;
    private int validTillMonth = 0;
    private int validTillYear = 0;
    private int CVV = 0;

    //private long havMoney = 0;
    private BigDecimal havMoney = new BigDecimal(0);

    private int verificationCode;

    public UserOfBank(long cardNumber, int validTillMonth, int validTillYear, int CVV, BigDecimal havMoney, int verificationCode) {
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

    public boolean userHaveMoney(BigDecimal money) {
        return havMoney.compareTo(money) >= 0 ? true : false;
    }

    public void addMoneyToUser(BigDecimal money) {
        havMoney.add(money);
    }

    public boolean takeMoneyFromUser(BigDecimal money) {
        if (userHaveMoney(money)) {
            havMoney.subtract(money);
            return true;
        }
        return false;
    }
}
