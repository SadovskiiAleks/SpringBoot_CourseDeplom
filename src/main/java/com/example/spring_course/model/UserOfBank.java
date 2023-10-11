package com.example.spring_course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class UserOfBank {
    @Getter
    private long cardNumber;
    @Getter
    private int validTillMonth;
    @Getter
    private int validTillYear;
    @Getter
    private int CVV;
    @Getter
    private int verificationCode;
    private BigDecimal havMoney;

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
